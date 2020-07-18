package ar.edu.unlam.recycloud.app.mongo;


import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.gson.Gson;
import com.google.inject.internal.util.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Singleton
public class MongoConsumer<T> {

    private final Gson gson;
    private final MongoDatabase mongoDatabase;

    MongoConsumer(Gson gson, MongoConfig mongoConfig) {
        this.gson = gson;
        this.mongoDatabase = mongoConfig.getDatabase();
    }

    public List<T> findAll(Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return Lists.newArrayList(collection.find());
    }

    public T findBy(Location location, Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return collection.find(Filters.near(
                "location", new Point(location.getPosition()), 0.0, 0.0)).first();
    }

    public List<T> listBy(Location location, Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return Lists.newArrayList(collection.find(Filters.near(
                "location", new Point(location.getPosition()), 0.0, 0.0)));
    }

    public List<T> filter(Bson bsonFilter, Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName().toLowerCase(), clazz);
        return Lists.newArrayList(collection.find(bsonFilter));
    }

    public void set(T element, Class<T> type) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(type.getSimpleName().toLowerCase(), type);
        collection.insertOne(element);
    }

    public void update(Bson bsonFilter, T element, Class<T> type) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(type.getSimpleName().toLowerCase(), type);
        collection.replaceOne(bsonFilter, element);
    }
}
