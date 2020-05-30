package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@Data
public class Dialog {
    Location location;
    String address;
    List<String> categories;
    @BsonProperty("first_heading")
    @SerializedName("first_heading")
    String firstHeading;
    @BsonProperty("body_content")
    @SerializedName("body_content")
    String bodyContent;
    List<String> days;
    String schedule;
    String link;
}
