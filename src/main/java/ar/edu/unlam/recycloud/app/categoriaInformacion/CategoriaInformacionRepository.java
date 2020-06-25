package ar.edu.unlam.recycloud.app.categoriaInformacion;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaInformacionRepository extends CrudRepository<CategoriaInformacion, Long> {
    List<CategoriaInformacion> findAll();

    CategoriaInformacion getByCategoria(Categoria categoria);

    CategoriaInformacion getById(Long id);
}
