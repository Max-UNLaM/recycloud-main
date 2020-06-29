package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create;

import lombok.Data;

import java.util.List;

@Data
public class PuntoReciclajeCreate {
    private String title;
    private String address;
    private List<String> days;
    private String schedule;
    private String content;
    private String link;
    private List<String> categories;
}