package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @BsonIgnore
    public String getBeginHour() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(getSchedule());
        if (m.find()) {
            return m.group(0);
        } else {
            return "0";
        }
    }

    // Termidooor de copa en copa
    @BsonIgnore
    public String getEndHour() {
        String[] strings = getSchedule().split("a ");
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(strings[1]);
        if (m.find()) {
            return m.group(0);
        } else {
            return "0";
        }
    }

    @BsonIgnore
    public String getCoordinates() {
        return location.getCoordinates().toString();
    }

    @BsonIgnore
    public String getCategoriesAsString() {
        return categories.toString().replace("[", "").replace("]", "");
    }

    public String getDaysAsString() {
        return days.toString().replace("[", "").replace("]", "");
    }
}
