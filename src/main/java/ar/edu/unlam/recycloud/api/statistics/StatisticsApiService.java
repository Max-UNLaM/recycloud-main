package ar.edu.unlam.recycloud.api.statistics;

import ar.edu.unlam.recycloud.api.statistics.models.*;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.map.dialog.DialogStatisticService;
import ar.edu.unlam.recycloud.app.statistics.StatisticService;
import ar.edu.unlam.recycloud.app.statistics.models.LocationMetric;
import ar.edu.unlam.recycloud.app.statistics.models.PuntoStatistic;
import ar.edu.unlam.recycloud.app.utils.JsonTools;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticsApiService {
    private final CategoriaService categoriaService;
    private final DialogStatisticService dialogStatisticService;
    private final StatisticService statisticService;
    private final DatasetFactory datasetFactory;
    private final Semester[] semesters;
    private List<Dataset> datasetList = new ArrayList<>();

    public StatisticsApiService(
            CategoriaService categoriaService, DialogStatisticService dialogStatisticService,
            StatisticService statisticService,
            DatasetFactory datasetFactory,
            JsonTools gson) {
        this.categoriaService = categoriaService;
        this.dialogStatisticService = dialogStatisticService;
        this.statisticService = statisticService;
        this.datasetFactory = datasetFactory;
        try {
            this.semesters = gson.loadFile("/charts/semesters.json", Semester[].class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new RuntimeException();
        }

    }

    public SimpleData getTotalVisitors() {
        return new SimpleData("Visitas Totales", statisticService.getTotalVisitors());
    }

    public SimpleData getTotalAccounts() {
        return new SimpleData("Usuarios Totales", statisticService.getTotalAccounts());
    }

    public List<PuntoStatistic> getTopDialogs() {
        return this.dialogStatisticService.getTopDialogs(2020, 6);
    }

    public LineChart getPuntoStatisticLineCharts(int semesterId) throws IOException {
        Semester semester = this.semesters[semesterId - 1]; // Termidoooor de copa en copa
        LineChart lineChart = new LineChart();
        lineChart.setLabels(semester.getNames());
        lineChart.setDatasets(getDatasets(semester));
        return lineChart;
    }

    public List<Dataset> getDatasets(Semester semester) throws IOException {
        List<List<PuntoStatistic>> allData = new ArrayList<>();
        for (int month : semester.getIndex()) {
            allData.add(this.dialogStatisticService.getTopDialogs(2020, month));
        }
        allData.forEach(listaDeListaPuntos -> listaDeListaPuntos.forEach(this::addDataToDataset));
        try {
            return this.datasetFactory.fillDatasetWithColors(this.datasetList);
        } finally {
            this.datasetList = new ArrayList<>();
        }
    }

    public void addDataToDataset(PuntoStatistic puntoStatistic) {
        Optional<Dataset> optionalDataset = this.datasetList.stream().filter(
                dataset -> dataset.getLabel().equals(puntoStatistic.getAddress())
        ).findFirst();
        if (optionalDataset.isPresent()) {
            optionalDataset.get().getData().add(puntoStatistic.getCount());
        } else {
            Dataset dataset = new Dataset();
            dataset.setLabel(puntoStatistic.getAddress());
            List<Long> values = new ArrayList<>();
            values.add(puntoStatistic.getCount());
            dataset.setData(values);
            this.datasetList.add(dataset);
        }
    }

    public LineChart getVisitorsChart(int semesterId) throws IOException {
        Semester semester = this.semesters[semesterId - 1]; // Termidoooor de copa en copa
        LineChart lineChart = new LineChart();
        lineChart.setLabels(semester.getNames());
        lineChart.setDatasets(datasetFactory.fillDatasetWithColors(getVisitorsDataset(semester)));
        return lineChart;
    }

    public List<Dataset> getVisitorsDataset(Semester semester) {
        List<Dataset> datasetList = new ArrayList<>();
        List<Long> dataList = new ArrayList<>();
        for (int index : semester.getIndex()) {
            dataList.add(statisticService.getVisitors(2020, index));
        }
        Dataset dataset = new Dataset();
        dataset.setData(dataList);
        dataset.setLabel("Visitors");
        datasetList.add(dataset);
        return datasetList;
    }

    public List<LocationMetric> getLocations() {
        return this.statisticService.getAll();
    }

    public SimpleData getTotalPines() {
        return new SimpleData("Pines Totales", this.statisticService.getTotalPines());
    }

    public SimpleData getTotalCategorias() {
        return new SimpleData("Categorias Totales", this.categoriaService.getTotalCategorias());
    }
}
