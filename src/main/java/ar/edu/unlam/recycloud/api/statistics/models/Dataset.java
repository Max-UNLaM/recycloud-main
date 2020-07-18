package ar.edu.unlam.recycloud.api.statistics.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Dataset {
    private String label;
    @SerializedName("fillColor")
    private String fillColor;
    @SerializedName("strokeColor")
    private String strokeColor;
    @SerializedName("pointColor")
    private String pointColor;
    @SerializedName("pointStrokeColor")
    private String pointStrokeColor;
    @SerializedName("pointHighlightFill")
    private String pointHighlightFill;
    @SerializedName("pointHighlightStroke")
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
