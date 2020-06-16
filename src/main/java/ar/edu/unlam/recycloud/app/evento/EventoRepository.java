package ar.edu.unlam.recycloud.app.evento;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    List<Evento> findAllByOrderByFechaAsc();
    @Query(value = "SELECT * FROM evento WHERE usuario_id = :id ORDER BY fecha ASC", nativeQuery = true)
    List<Evento> eventosporId(@Param("id") Long id);
}
