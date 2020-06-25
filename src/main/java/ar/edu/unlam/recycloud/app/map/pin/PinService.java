package ar.edu.unlam.recycloud.app.map.pin;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PinService {

    private final PinRepository<Pin> pinRepository;

    PinService(PinMongoRepository pinesRepository) {
        this.pinRepository = pinesRepository;
    }

    public List<Pin> get() {
        return this.pinRepository.findAll();
    }

    public List<Pin> get(Map<String, String> filters) {
        return this.pinRepository.find(filters);
    }

}
