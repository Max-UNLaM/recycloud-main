package ar.edu.unlam.recycloud.app.pines;

import org.springframework.stereotype.Service;

@Service
public class PinService {

    private final PinesRepository pinesRepository;

    PinService(PinesMockRepository pinesRepository) {
        this.pinesRepository = pinesRepository;
    }

    public Pin[] getAll() {
        return this.pinesRepository.findAll();
    }

}
