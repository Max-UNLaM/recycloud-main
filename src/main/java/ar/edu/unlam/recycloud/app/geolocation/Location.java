package ar.edu.unlam.recycloud.app.geolocation;

import com.mongodb.client.model.geojson.Position;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Location {
    String type = "Point";
    List<Double> coordinates = new ArrayList<>();

    public Position getPosition() {
        return new Position(getCoordinates());
    }
}
