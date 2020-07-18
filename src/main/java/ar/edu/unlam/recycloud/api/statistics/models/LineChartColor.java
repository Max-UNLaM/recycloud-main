package ar.edu.unlam.recycloud.api.statistics.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LineChartColor {
    @SerializedName("fill_color")
    String fillColor;
    @SerializedName("stroke_color")
    String strokeColor;
    @SerializedName("point_color")
    String pointColor;
    @SerializedName("point_stroke_color")
    String pointStrokeColor;
    @SerializedName("point_highlight_fill")
    String pointHighlightFill;
    @SerializedName("point_highlight_stroke")
    String pointHighlightStroke;
}
