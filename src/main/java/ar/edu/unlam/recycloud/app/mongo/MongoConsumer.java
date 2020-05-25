package ar.edu.unlam.recycloud.app.mongo;


import com.google.inject.internal.util.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.List;

@Component
@Singleton
class MongoConsumer<T> {

    private final MongoDatabase mongoDatabase;

    MongoConsumer(MongoConfig mongoConfig) {
        this.mongoDatabase = mongoConfig.getDatabase();
    }

    public List<T> findAll(Class<T> clazz) {
        MongoCollection<T> collection = this.mongoDatabase.getCollection(clazz.getSimpleName(), clazz);
        return Lists.newArrayList(collection.find());
    }

}
