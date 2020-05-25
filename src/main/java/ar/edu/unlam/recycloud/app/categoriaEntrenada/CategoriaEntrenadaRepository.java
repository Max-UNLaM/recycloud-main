package ar.edu.unlam.recycloud.app.categoriaEntrenada;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaEntrenadaRepository extends CrudRepository<CategoriaEntrenada, Long> {
    List<CategoriaEntrenada> findAll();

}
