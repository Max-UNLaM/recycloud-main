package ar.edu.unlam.recycloud.app.map.pin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinService {

    private final PinRepository<Pin> pinRepository;

    PinService(PinMongoRepository pinesRepository) {
        this.pinRepository = pinesRepository;
    }

    public List<Pin> getAll() {
        return this.pinRepository.findAll();
    }

}
