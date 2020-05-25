package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import lombok.Data;

@Data
public class Pin {
    String title;
    String[] categories;
    Location location;
}
