package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import org.springframework.stereotype.Service;

@Service
public class DialogService {

    DialogRepository repository;

    DialogService(DialogMockRepository repository) {
        this.repository = repository;
    }

    public Dialog getDialogFromDouble(double[] doubles) {
        Location location = new Location();
        location.setCoordinates(doubles);
        return repository.findByLocation(location);
    }

}
