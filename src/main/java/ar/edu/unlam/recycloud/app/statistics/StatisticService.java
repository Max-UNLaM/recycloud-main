package ar.edu.unlam.recycloud.app.statistics;

import ar.edu.unlam.recycloud.app.statistics.models.LocationMetric;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    private final MetricsRepository<LocationMetric> locationRepository;

    public StatisticService(MetricsRepository<LocationMetric> locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationMetric> getAll() {
        return this.locationRepository.list(LocationMetric.class);
    }

    public Map<List<Double>, Long> getTopLocation(int year, int month) {
        return getAll().stream()
                .sorted()
                .filter(el -> el.getMonth() == month)
                .filter(el -> el.getYear() == year)
                .collect(Collectors.groupingBy(locationMetric -> locationMetric.getData().getCoordinates(), Collectors.counting()));
    }

}
