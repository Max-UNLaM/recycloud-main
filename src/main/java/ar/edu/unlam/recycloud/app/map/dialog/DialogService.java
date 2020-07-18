package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DialogService {

    private final DialogMetric dialogMetric;
    DialogRepository repository;

    DialogService(DialogMongoRepository repository, DialogMetric dialogMetric) {
        this.repository = repository;
        this.dialogMetric = dialogMetric;
    }

    public Dialog getDialogFromDouble(List<Double> doubles) {
        Location location = new Location();
        location.setCoordinates(doubles);
        CompletableFuture.runAsync(() -> dialogMetric.meterDialog(location));
        return repository.findByLocation(location);
    }

    public Dialog getDialogFromLocation(Location location) {
        return repository.findByLocation(location);
    }

    public Dialog getDialogFromLocation(List<Double> doubles) {
        Location location = new Location();
        location.setCoordinates(doubles);
        return repository.findByLocation(location);
    }

    public void createDialog(Dialog dialog) {
        repository.setDialog(dialog);
    }

    public void updateDialog(Dialog dialog) {
        repository.updateDialog(dialog);
    }

}
