package ar.edu.unlam.recycloud.app.statistics;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.statistics.models.CountMetric;
import ar.edu.unlam.recycloud.app.statistics.models.CountMetricBuilder;
import ar.edu.unlam.recycloud.app.statistics.models.LocationMetric;
import ar.edu.unlam.recycloud.app.statistics.models.LocationMetricBuilder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.Calendar;

@Service
public class MetricsService {

    private final MetricsRepository<CountMetric> countRepository;
    private final MetricsRepository<LocationMetric> locationRepository;

    public MetricsService(
            MetricsRepository<CountMetric> countRepository,
            MetricsRepository<LocationMetric> locationRepository) {
        this.countRepository = countRepository;
        this.locationRepository = locationRepository;
    }

    public void count(String name, String data) {
        CountMetric metric = CountMetricBuilder.build(
                data,
                Instant.now().toEpochMilli(),
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                name);
        this.countRepository.set(metric, CountMetric.class);
    }

    public void countLocation(String name, Location location) {
        LocationMetric metric = LocationMetricBuilder.build(
                location,
                Instant.now().toEpochMilli(),
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                name);
        this.locationRepository.set(metric, LocationMetric.class);
    }

    public int getCountLocation(String name, Location location) {
        return this.locationRepository.list(location, LocationMetric.class).size();
    }

    public void registerSession(HttpSession session) {

    }

}
