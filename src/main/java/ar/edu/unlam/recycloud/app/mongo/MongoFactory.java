package ar.edu.unlam.recycloud.app.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
class MongoFactory {

    private static final String STRING_CONFIG_NAME = "mongo.connection-string";
    private static final String DEFAULT_CONNECTION_STRING = "mongodb://localhost";
    private final ConnectionString connectionString;

    MongoFactory(Environment environment) {
        this.connectionString = new ConnectionString(
                environment.getProperty(STRING_CONFIG_NAME, DEFAULT_CONNECTION_STRING)
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
