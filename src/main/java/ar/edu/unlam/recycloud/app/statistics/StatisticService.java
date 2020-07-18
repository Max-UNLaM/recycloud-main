package ar.edu.unlam.recycloud.app.statistics;

import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.map.pin.PinService;
import ar.edu.unlam.recycloud.app.statistics.models.CountMetric;
import ar.edu.unlam.recycloud.app.statistics.models.LocationMetric;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    private final CategoriaService categoriaService;
    private final MetricsRepository<CountMetric> countMetricMetricsRepository;
    private final MetricsRepository<LocationMetric> locationRepository;
    private final UsuarioService usuarioService;
    private final PinService pinService;

    public StatisticService(
            CategoriaService categoriaService, MetricsRepository<CountMetric> countMetricMetricsRepository,
            MetricsRepository<LocationMetric> locationRepository,
            UsuarioService usuarioService, PinService pinService) {
        this.categoriaService = categoriaService;
        this.countMetricMetricsRepository = countMetricMetricsRepository;
        this.locationRepository = locationRepository;
        this.usuarioService = usuarioService;
        this.pinService = pinService;
    }

    public List<LocationMetric> getAll() {
        return this.locationRepository.list(LocationMetric.class);
    }

    public Long getVisitors(int year, int month) {
        return countMetricMetricsRepository.list(CountMetric.class).stream()
                .filter(el -> el.getMonth() == month)
                .filter(el -> el.getYear() == year)
                .count();
    }

    public Map<List<Double>, Long> getTopLocation(int year, int month) {
        return getAll().stream()
                .sorted()
                .filter(el -> el.getMonth() == month)
                .filter(el -> el.getYear() == year)
                .collect(Collectors.groupingBy(locationMetric -> locationMetric.getData().getCoordinates(), Collectors.counting()));
    }

    public int getTotalVisitors() {
        return countMetricMetricsRepository.count(CountMetric.class, "visitor");
    }

    public long getTotalAccounts() {
        return usuarioService.getTotalAccounts();
    }

    public int getTotalPines() {
        return pinService.count();
    }

    public long getTotalCategories() {
        return categoriaService.getTotalCategorias();
    }
}
