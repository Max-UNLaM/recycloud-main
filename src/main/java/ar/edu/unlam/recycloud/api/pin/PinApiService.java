package ar.edu.unlam.recycloud.api.pin;

import ar.edu.unlam.recycloud.app.map.pin.Pin;
import ar.edu.unlam.recycloud.app.map.pin.PinService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
class PinApiService {

    private final PinService pinService;

    PinApiService(PinService pinService) {
        this.pinService = pinService;
    }

    public List<Pin> getAllPines(Map<String, String> filter) {
        if (filter.size() == 0) {
            return pinService.get();
        } else {
            return pinService.get(filter);
        }

    }

}
