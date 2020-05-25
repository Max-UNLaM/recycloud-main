package ar.edu.unlam.recycloud.app.categoriaInformacion;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaInformacionRepository extends CrudRepository<CategoriaInformacion, Long> {
    List<CategoriaInformacion> findAll();
    CategoriaInformacion findFirstBy();
}
