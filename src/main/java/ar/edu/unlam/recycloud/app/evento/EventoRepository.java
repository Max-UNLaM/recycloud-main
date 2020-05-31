package ar.edu.unlam.recycloud.app.evento;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    List<Evento> findAll();

}
