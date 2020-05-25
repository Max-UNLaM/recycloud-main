package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import lombok.Data;

@Data
public class Dialog {
    Location location;
    String address;
    String[] categories;
    String firstHeading;
    String bodyContent;
    String[] days;
    String schedule;
    String link;
}
