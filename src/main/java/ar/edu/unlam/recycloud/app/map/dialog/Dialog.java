package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Dialog {
    Location location;
    String address;
    String[] categories;
    @SerializedName("first_heading")
    String firstHeading;
    @SerializedName("body_content")
    String bodyContent;
    String[] days;
    String schedule;
    String link;
}
