package ar.edu.unlam.recycloud.app.puntoreciclaje;

import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntoReciclajeService {

    private final PuntoReciclajeRepository repository;

    public PuntoReciclajeService(PuntoReciclajeRepository repository) {
        this.repository = repository;
    }

    public PuntoReciclaje getById(Long id) {
        Optional<PuntoReciclaje> puntoReciclajeOptional = repository.findById(id);
        if (puntoReciclajeOptional.isPresent()) {
            return puntoReciclajeOptional.get();
        }
        throw new NotFoundException("Punto de Reciclaje", id);
    }

    public PuntoReciclaje getByCoordinates(String coordinates) {
        return repository.findPuntoReciclajeByCoordinates(coordinates);
    }

    public List<PuntoReciclaje> listByUserId(Long userId) {
        return repository.findPuntoReciclajeByUsuarioId(userId);
    }

    public List<PuntoReciclaje> listByCoordinates(List<String> stringList) {
        return repository.findPuntoReciclajeByCoordinatesIn(stringList);
    }

    public PuntoReciclaje create(PuntoReciclaje puntoReciclaje) {
        return repository.save(puntoReciclaje);
    }

    public PuntoReciclaje update(PuntoReciclaje puntoReciclaje) {
        return repository.save(puntoReciclaje);
    }
}
