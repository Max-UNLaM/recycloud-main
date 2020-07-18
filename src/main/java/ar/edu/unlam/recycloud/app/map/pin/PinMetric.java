package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.statistics.MetricsService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static ar.edu.unlam.recycloud.conf.MetricsConstants.PIN_METRIC;

@Service
public class PinMetric {

    private final MetricsService metricsService;

    public PinMetric(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    public void meterPin(Map<String, String> filter) {
        filter.forEach((key, value) -> metricsService.count(PIN_METRIC + "_" + key, value));
    }
}
