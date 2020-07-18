package ar.edu.unlam.recycloud.app.statistics;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.mongo.MongoConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsRepository<T> {
    private final MongoConsumer<T> mongoConsumer;

    public MetricsRepository(MongoConsumer<T> mongoConsumer) {
        this.mongoConsumer = mongoConsumer;
    }

    public void set(T metricData, Class<T> clazz) {
        this.mongoConsumer.set(metricData, clazz);
    }

    public List<T> list(Class<T> clazz) {
        return this.mongoConsumer.findAll(clazz);
    }

    public List<T> list(Location location, Class<T> clazz) {
        return this.mongoConsumer.listBy(location, clazz);
    }
}
