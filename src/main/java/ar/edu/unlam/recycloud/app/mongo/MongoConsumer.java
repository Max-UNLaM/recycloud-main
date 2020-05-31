package ar.edu.unlam.recycloud.app.mongo;


import ar.edu.unlam.recycloud.app.geolocation.Location;
import com.google.inject.internal.util.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.List;

@Component
@Singleton
public class MongoConsumer<T> {

    private final MongoDatabase mongoDatabase;

    MongoConsumer(MongoConfig mongoConfig) {
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

}
