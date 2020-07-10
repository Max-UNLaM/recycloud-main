package ar.edu.unlam.recycloud.app.categoria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
    Categoria getById(Long id);
    @Query(value = "SELECT COUNT(*) FROM categoria", nativeQuery = true)
    Integer totalDeCategorias();
}
