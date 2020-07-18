package ar.edu.unlam.recycloud.api.statistics;

import ar.edu.unlam.recycloud.api.statistics.models.Dataset;
import ar.edu.unlam.recycloud.api.statistics.models.DatasetFactory;
import ar.edu.unlam.recycloud.api.statistics.models.LineChart;
import ar.edu.unlam.recycloud.app.map.dialog.DialogStatisticService;
import ar.edu.unlam.recycloud.app.statistics.StatisticService;
import ar.edu.unlam.recycloud.app.statistics.models.LocationMetric;
import ar.edu.unlam.recycloud.app.statistics.models.PuntoStatistic;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticsApiService {

    private static final int[] months = {6, 7, 8, 9, 10, 11};

    private final DialogStatisticService dialogStatisticService;
    private final StatisticService statisticService;
    private final DatasetFactory datasetFactory;
    private List<Dataset> datasetList = new ArrayList<>();

    public StatisticsApiService(
            DialogStatisticService dialogStatisticService,
            StatisticService statisticService,
            DatasetFactory datasetFactory
    ) {
        this.dialogStatisticService = dialogStatisticService;
        this.statisticService = statisticService;
        this.datasetFactory = datasetFactory;
    }

    public List<Dataset> getTopPines() {
        return null;
    }

    public List<PuntoStatistic> getTopDialogs() {
        return this.dialogStatisticService.getTopDialogs(2020, 6);
    }

    public LineChart getPuntoStatisticLineCharts() throws IOException {
        LineChart lineChart = new LineChart();
        lineChart.setLabels(new String[]{"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "diciembre"});
        lineChart.setDatasets(getDatasets());
        return lineChart;
    }

    public List<Dataset> getDatasets() throws IOException {
        List<List<PuntoStatistic>> allData = new ArrayList<>();
        for (int month : months) {
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

    public List<LocationMetric> getLocations() {
        return this.statisticService.getAll();
    }
}
