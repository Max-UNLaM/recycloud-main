package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PuntoReciclajeEdit {
    @NotEmpty
    @Size(min = 2, max = 20, message = "Completar el título")
    public String title;
    @NotEmpty
    @Size(min = 8, max = 80, message = "Completar la dirección")
    private String address;
    private String city;
    private String province;
    @NotEmpty
    @Size(min = 2, max = 500, message = "Completar la descripción")
    private String content;
    @NotEmpty
    @Size(min = 2, max = 80, message = "Completar el link al sitio web / red social")
    private String link;
    @NotEmpty
    private String categories;
    @NotEmpty
    private String days;
    @SerializedName("begin_hour")
    private String beginHour;
    @SerializedName("end_hour")
    private String endHour;
    private String coordinates;

    @BsonIgnore
    public List<String> getCategoriesAsList() {
        return Arrays.stream(categories.split(",")).map(String::toUpperCase).collect(Collectors.toList());
    }

    @BsonIgnore
    public String getFullHour() {
        return beginHour + " a " + endHour + " horas";
    }

    @BsonIgnore
    public List<Double> getCoordinatesAsList() {
        List<Double> coordsList = new ArrayList<>();
        coordinates = coordinates.replace("[", "").replace("]", "");
        Arrays.stream(coordinates.split(",")).forEach((coord) -> coordsList.add(Double.valueOf(coord)));
        return coordsList;
    }

    @BsonIgnore
    public Location getLocation() {
        Location location = new Location();
        location.setCoordinates(getCoordinatesAsList());
        return location;
    }

}