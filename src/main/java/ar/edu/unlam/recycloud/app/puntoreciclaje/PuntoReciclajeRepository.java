package ar.edu.unlam.recycloud.app.puntoreciclaje;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface PuntoReciclajeRepository extends CrudRepository<PuntoReciclaje, Long> {
    PuntoReciclaje findPuntoReciclajeByCoordinates(String coordinates);

    List<PuntoReciclaje> findPuntoReciclajeByUsuarioId(Long usuarioId);

    List<PuntoReciclaje> findPuntoReciclajeByCoordinatesIn(List<String> coordinates);
}
