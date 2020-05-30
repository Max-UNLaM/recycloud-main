package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinMongoRepository implements PinRepository<Pin> {

    private final MongoConsumer<Pin> mongoConsumer;

    PinMongoRepository(MongoConsumer<Pin> mongoConsumer) {
        this.mongoConsumer = mongoConsumer;
    }

    @Override
    public List<Pin> findAll() {
        return this.mongoConsumer.findAll(Pin.class);
    }
}
