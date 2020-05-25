package ar.edu.unlam.recycloud.app.dialogs;

import ar.edu.unlam.recycloud.app.geolocation.Coords;
import lombok.Data;

@Data
public class Dialogs {
    Coords coords;
    String address;
    String[] categories;
    String firstHeading;
    String bodyContent;
    String[] days;
    String schedule;
    String link;
}
