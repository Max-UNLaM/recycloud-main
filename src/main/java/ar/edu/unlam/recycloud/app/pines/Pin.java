package ar.edu.unlam.recycloud.app.pines;

import ar.edu.unlam.recycloud.app.geolocation.Coords;
import lombok.Data;

@Data
public class Pin {
    String title;
    String[] categories;
    Coords coords;
}
