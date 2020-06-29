package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create;

import lombok.Data;

import java.util.List;

@Data
public class PuntoReciclajeCreateViewModel {
    public PuntoReciclajeCreate expectedData = new PuntoReciclajeCreate();
    public List<String> categories;
}
