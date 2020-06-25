package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import org.springframework.stereotype.Component;

@Component
public class DialogMongoRepository implements DialogRepository {

    private final MongoConsumer<Dialog> mongoConsumer;

    public DialogMongoRepository(MongoConsumer<Dialog> mongoConsumer) {
        this.mongoConsumer = mongoConsumer;
    }

    @Override
    public Dialog findByLocation(Location location) {
        return this.mongoConsumer.findBy(location, Dialog.class);
    }
}
