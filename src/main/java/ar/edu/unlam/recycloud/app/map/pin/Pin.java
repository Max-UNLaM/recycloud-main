package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import lombok.Data;

import java.util.List;

@Data
public class Pin {
    String title;
    List<String> categories;
    Location location;
}
