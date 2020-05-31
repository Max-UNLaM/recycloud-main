package ar.edu.unlam.recycloud.app.mongo;


import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.utils.GsonRecyBuilder;
import com.google.gson.Gson;
import com.google.inject.internal.util.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Component
@Singleton
public class MongoConsumer<T> {

    private final Gson gson;
    private final MongoDatabase mongoDatabase;

    MongoConsumer(GsonRecyBuilder gson, MongoConfig mongoConfig) {
        this.gson = gson.getGson();
        this.mongoDatabase = mongoConfig.getDatabase();
    }

    public List<T> findAll(Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return Lists.newArrayList(collection.find());
    }

    public T findBy(Location location, Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return collection.find(Filters.near("location", new Point(location.getPosition()), 0.0, 0.0)).first();
    }

    public List<T> filter(Map<String, String> filter, Class<T> clazz) {
        Bson bsonFilter = BsonDocument.parse(gson.toJson(filter));
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return Lists.newArrayList(collection.find(bsonFilter));
    }

}
