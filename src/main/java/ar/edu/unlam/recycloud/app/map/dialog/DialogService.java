package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogService {

    DialogRepository repository;

    DialogService(DialogMongoRepository repository) {
        this.repository = repository;
    }

    public Dialog getDialogFromDouble(List<Double> doubles) {
        Location location = new Location();
        location.setCoordinates(doubles);
        return repository.findByLocation(location);
    }

}
