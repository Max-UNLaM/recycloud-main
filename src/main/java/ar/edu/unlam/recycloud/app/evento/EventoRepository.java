package ar.edu.unlam.recycloud.app.evento;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    @Query(value = "SELECT * FROM evento WHERE fecha >= :tiempo ORDER BY fecha ASC", nativeQuery = true)
    List<Evento> findAllByOrderByFechaAsc(@Param("tiempo") String tiempo);;

    @Query(value = "SELECT * FROM evento WHERE usuario_id = :id ORDER BY fecha ASC", nativeQuery = true)
    List<Evento> eventosporId(@Param("id") Long id);

    @Query(value = "SELECT * FROM evento WHERE fecha = :tiempo ORDER BY fecha ASC", nativeQuery = true)
    List<Evento> filtroPorTiempoHoy(@Param("tiempo") String tiempo);

    @Query(value = "SELECT * FROM evento WHERE fecha >= :tiempo AND fecha <= :siempoMasSiete ORDER BY fecha ASC", nativeQuery = true)
    List<Evento> filtroPorTiempoSemana(@Param("tiempo") String tiempo,@Param("siempoMasSiete") String siempoMasSiete);
}
