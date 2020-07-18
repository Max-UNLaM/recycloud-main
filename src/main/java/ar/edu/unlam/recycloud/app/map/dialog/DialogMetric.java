package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.statistics.MetricsService;
import org.springframework.stereotype.Service;

@Service
public class DialogMetric {

    private static final String DIALOG_METRIC = "dialog_get";

    private final MetricsService metricsService;

    public DialogMetric(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    public void meterDialog(Location coords) {
        this.metricsService.countLocation(DIALOG_METRIC, coords);
    }

}
