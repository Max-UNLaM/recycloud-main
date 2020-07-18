package ar.edu.unlam.recycloud.api.statistics.models;

import ar.edu.unlam.recycloud.app.utils.JsonTools;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DatasetFactory {

    private static final String CHART_PATH = "/charts";
    private static final String LINE_CHARTS_FILE = CHART_PATH + "/line_charts.json";

    private final JsonTools jsonTools;

    public DatasetFactory(JsonTools jsonTools) {
        this.jsonTools = jsonTools;
    }

    public List<Dataset> fillDatasetWithColors(List<Dataset> dataList) throws IOException {
        LineChartColor[] colors = jsonTools.loadFile(LINE_CHARTS_FILE, LineChartColor[].class);
        for (int i = 0; i < dataList.size(); i++) {
            dataList.get(i).fill(colors[i]);
        }
        return dataList;
    }

}
