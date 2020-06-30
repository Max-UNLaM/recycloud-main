package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PuntoReciclajeCreate {
    @NotEmpty
    @Size(min = 2, max = 20, message = "Completar el título")
    public String title;
    @NotEmpty
    @Size(min = 8, max = 80, message = "Completar la dirección")
    private String address;
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

    public List<String> getCategoriesAsList() {
        return Arrays.stream(categories.split(",")).map(String::toUpperCase).collect(Collectors.toList());
    }

    public String getFullHour() {
        return beginHour + " a " + endHour + " horas";
    }

}