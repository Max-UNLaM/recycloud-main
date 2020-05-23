package ar.edu.unlam.recycloud.app.mongo;


import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Component
@Singleton
class MongoConsumer {

    private final MongoDatabase mongoDatabase;

    MongoConsumer(MongoFactory mongoFactory) {
        this.mongoDatabase = mongoFactory.getDatabase();
    }


}
