package ar.edu.unlam.recycloud.app.map.pin;

import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class PinService {

    private final PinRepository<Pin> pinRepository;
    private final PinMetric pinMetric;

    PinService(PinMongoRepository pinesRepository, PinMetric pinMetric) {
        this.pinRepository = pinesRepository;
        this.pinMetric = pinMetric;
    }

    public List<Pin> get() {
        return this.pinRepository.findAll();
    }

    public List<Pin> get(Map<String, String> filters) {
        CompletableFuture.runAsync(() -> pinMetric.meterPin(filters));
        return this.pinRepository.find(filters);
    }

    public List<Pin> get(Bson filter) {
        return this.pinRepository.find(filter);
    }

    public void set(Pin pin) {
        this.pinRepository.setPunto(pin);
    }

    public void update(Pin pin) {
        this.pinRepository.updatePunto(pin);
    }

    public int count() {
        return this.pinRepository.findAll().size();
    }
}
