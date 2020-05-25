package ar.edu.unlam.recycloud.app.categoria;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
}
