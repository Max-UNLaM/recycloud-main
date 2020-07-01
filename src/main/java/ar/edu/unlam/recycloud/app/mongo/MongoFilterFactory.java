package ar.edu.unlam.recycloud.app.mongo;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.utils.CoordTools;
import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MongoFilterFactory {

    private static final String LOCATION_COORDS_KEY = "location.coordinates";

    private final CoordTools coordTools;
    private final Gson gson;

    MongoFilterFactory(CoordTools coordTools, Gson gson) {
        this.coordTools = coordTools;
        this.gson = gson;
    }

    public Bson locationFilter(Location location) {
        return Filters.near("location", new Point(location.getPosition()), 0.0, 0.0);
    }

    public Bson locationListFilter(List<String> stringLocations) {
        List<List<Double>> coords = coordTools.fromStringArrayToDoubleList(stringLocations);
        Map<String, List<List<Double>>> query = new HashMap<>();
        query.put(LOCATION_COORDS_KEY, coords);
        return BsonDocument.parse(this.gson.toJson(query));
    }
}
