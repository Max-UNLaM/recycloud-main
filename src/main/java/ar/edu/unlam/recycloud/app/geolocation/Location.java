package ar.edu.unlam.recycloud.app.geolocation;

import com.mongodb.client.model.geojson.Position;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Location {
    @Getter
    @Setter
    String type = "Point";
    @Getter
    @Setter
    List<Double> coordinates = new ArrayList<>();

    @BsonIgnore
    public Position getPosition() {
        return new Position(getCoordinates());
    }
}
