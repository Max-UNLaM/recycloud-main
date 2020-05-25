package ar.edu.unlam.recycloud.api.pin;

import ar.edu.unlam.recycloud.app.map.pin.Pin;
import ar.edu.unlam.recycloud.app.map.pin.PinService;
import org.springframework.stereotype.Service;

@Service
class PinApiService {

    private final PinService pinService;

    PinApiService(PinService pinService) {
        this.pinService = pinService;
    }

    public Pin[] getAllPines() {
        return pinService.getAll();
    }

}
