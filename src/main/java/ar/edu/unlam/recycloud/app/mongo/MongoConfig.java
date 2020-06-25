package ar.edu.unlam.recycloud.app.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MongoConfig {

    private static final String CONNECTION_STRING_CONFIG_KEY = "mongo.connection-string";
    private static final String CONNECTION_STRING_DEFAULT = "mongodb://localhost";
    private static final String DATABASE_NAME_KEY = "mongo.database";
    private static final String DATABASE_NAME_DEFAULT = "recycloud";
    private final MongoClient mongoClient;
    private String databaseName;

    MongoConfig(Environment environment) {
        ConnectionString connectionString = new ConnectionString(
                environment.getProperty(CONNECTION_STRING_CONFIG_KEY, CONNECTION_STRING_DEFAULT)
        );
        this.databaseName = environment.getProperty(DATABASE_NAME_KEY, DATABASE_NAME_DEFAULT);
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(buildPojoCodecRegistry())
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
    }

    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(databaseName);
    }

    public void setCustomDatabase(String databaseName) {
        this.databaseName = databaseName;
    }

    private CodecRegistry buildPojoCodecRegistry() {
        return CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
    }

}
