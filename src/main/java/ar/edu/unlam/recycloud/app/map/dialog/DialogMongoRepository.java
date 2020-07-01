package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

@Component
public class DialogMongoRepository implements DialogRepository {

    private final Gson gson;
    private final MongoConsumer<Dialog> mongoConsumer;

    public DialogMongoRepository(Gson gson, MongoConsumer<Dialog> mongoConsumer) {
        this.gson = gson;
        this.mongoConsumer = mongoConsumer;
    }

    @Override
    public Dialog findByLocation(Location location) {
        return this.mongoConsumer.findBy(location, Dialog.class);
    }

    @Override
    public void setDialog(Dialog dialog) {
        this.mongoConsumer.set(dialog, Dialog.class);
    }

    @Override
    public void updateDialog(Dialog dialog) {
        Bson filter = Filters.near("location", new Point(dialog.getLocation().getPosition()), 0.0, 0.0);
        this.mongoConsumer.update(filter, dialog, Dialog.class);
    }
}
