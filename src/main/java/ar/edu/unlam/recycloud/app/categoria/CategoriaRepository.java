package ar.edu.unlam.recycloud.app.categoria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
    Categoria getById(Long id);
    @Query(value = "SELECT COUNT(*) FROM categoria", nativeQuery = true)
    Integer totalDeCategorias();

    @Query(value = "SELECT COUNT(*) FROM evento", nativeQuery = true)
    Integer total();
    @Query(value = "SELECT COUNT(*) FROM evento WHERE fecha < :tiempo", nativeQuery = true)
    Integer activo(@Param("tiempo") String tiempo);
    @Query(value = "SELECT COUNT(*) FROM evento WHERE fecha >= :tiempo", nativeQuery = true)
    Integer inactivo(@Param("tiempo") String tiempo);
}
