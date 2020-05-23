package ar.edu.unlam.recycloud.app.categoria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();

    List<Categoria> findByNombre(String nombre);

    @Query("SELECT DISTINCT nombre, id FROM Categoria")
    Map<String, Long> getCategoriasNamesAndId();
}
