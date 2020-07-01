package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit;

import lombok.Data;

import java.util.List;

import static ar.edu.unlam.recycloud.web.components.CommonConstants.*;

@Data
public class PuntoReciclajeEditViewModel {
    private List<String> categories;
    private String[] days = DAYS;
    private String[] hours = HOURS;
    private String[] provinces = PROVINCIAS;
    private String title;
    private String action;
    private String type;
}
