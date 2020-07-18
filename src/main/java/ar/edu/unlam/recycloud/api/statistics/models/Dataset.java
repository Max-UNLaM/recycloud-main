package ar.edu.unlam.recycloud.api.statistics.models;

import lombok.Data;

import java.util.List;

@Data
public class Dataset {
    private String label;
    private String fillColor;
    private String strokeColor;
    private String pointColor;
    private String pointStrokeColor;
    private String pointHighlightFill;
    private String pointHighlightStroke;
    private List<Long> data;

    public Dataset() {
    }

    public Dataset(LineChartColor lineChartColor) {
        this.fillColor = lineChartColor.getFillColor();
        this.strokeColor = lineChartColor.getStrokeColor();
        this.pointColor = lineChartColor.getPointColor();
        this.pointStrokeColor = lineChartColor.getPointStrokeColor();
        this.pointHighlightFill = lineChartColor.getPointHighlightFill();
        this.pointHighlightStroke = lineChartColor.getPointHighlightStroke();
    }

    public void fill(LineChartColor lineChartColor) {
        this.fillColor = lineChartColor.getFillColor();
        this.strokeColor = lineChartColor.getStrokeColor();
        this.pointColor = lineChartColor.getPointColor();
        this.pointStrokeColor = lineChartColor.getPointStrokeColor();
        this.pointHighlightFill = lineChartColor.getPointHighlightFill();
        this.pointHighlightStroke = lineChartColor.getPointHighlightStroke();
    }

}
