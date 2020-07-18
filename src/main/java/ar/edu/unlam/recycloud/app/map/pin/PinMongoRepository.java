package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PinMongoRepository implements PinRepository<Pin> {

    private final MongoConsumer<Pin> mongoConsumer;
    private final Gson gson;

    PinMongoRepository(MongoConsumer<Pin> mongoConsumer, Gson gson) {
        this.mongoConsumer = mongoConsumer;
        this.gson = gson;
    }

    @Override
    public List<Pin> findAll() {
        return this.mongoConsumer.findAll(Pin.class);
    }

    // Todo, crear un convertidor de mapas a filtros locos
    @Override
    public List<Pin> find(Map<String, String> filters) {
        Bson bsonFilter = BsonDocument.parse(this.gson.toJson(filters));
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (entry.getValue().contains(",")) {
                List<BsonString> filterList = new ArrayList<>();
                String[] stringList = entry.getValue().split(",");
                for (String string : stringList) {
                    filterList.add(new BsonString(string));
                }
                bsonFilter = findIn(entry.getKey(), filterList);
            }
        }
        return this.mongoConsumer.filter(bsonFilter, Pin.class);
    }

    @Override
    public List<Pin> find(Bson filter) {
        return this.mongoConsumer.filter(filter, Pin.class);
    }

    private BsonDocument findIn(String key, List<BsonString> values) {
        BsonDocument inFilter = new BsonDocument("$in", new BsonArray(values));
        return new BsonDocument(key, inFilter);
    }

    @Override
    public void setPunto(Pin punto) {
        this.mongoConsumer.set(punto, Pin.class);
    }

    @Override
    public void updatePunto(Pin pin) {
        Bson filter = Filters.near("location", new Point(pin.getLocation().getPosition()), 0.0, 0.0);
        this.mongoConsumer.update(filter, pin, Pin.class);
    }
}
