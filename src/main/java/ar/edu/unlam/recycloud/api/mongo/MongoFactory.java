package ar.edu.unlam.recycloud.api.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Singleton
@Component
class MongoFactory {

    private final ConnectionString connectionString;

    MongoFactory() {
        this.connectionString = new ConnectionString(
                "mongodb://localhost"
        );
    }

    MongoDatabase getDatabase() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(this.connectionString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase("test");
    }

}
