package ar.edu.unlam.recycloud.app.statistics;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import com.google.gson.Gson;
import org.bson.BsonDocument;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MetricsRepository<T> {

    private final Gson gson;
    private final MongoConsumer<T> mongoConsumer;

    public MetricsRepository(Gson gson, MongoConsumer<T> mongoConsumer) {
        this.gson = gson;
        this.mongoConsumer = mongoConsumer;
    }

    public void set(T metricData, Class<T> clazz) {
        this.mongoConsumer.set(metricData, clazz);
    }

    public List<T> list(Class<T> clazz) {
        return this.mongoConsumer.findAll(clazz);
    }

    public List<T> list(Location location, Class<T> clazz) {
        return this.mongoConsumer.listBy(location, clazz);
    }

    public int count(Class<T> clazz, String name) {
        Map<String, String> filter = new HashMap<>();
        filter.put("metricName", name);
        return this.mongoConsumer.filter(BsonDocument.parse(gson.toJson(filter)), clazz).size();
    }
}
