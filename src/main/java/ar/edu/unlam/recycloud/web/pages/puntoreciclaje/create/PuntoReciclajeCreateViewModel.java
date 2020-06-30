package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create;

import lombok.Data;

import java.util.List;

import static ar.edu.unlam.recycloud.web.components.CommonConstants.DAYS;
import static ar.edu.unlam.recycloud.web.components.CommonConstants.HOURS;

@Data
public class PuntoReciclajeCreateViewModel {
    private List<String> categories;
    private String[] days = DAYS;
    private String[] hours = HOURS;
}
