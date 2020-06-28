package ar.edu.unlam.recycloud.app.categoriaInformacion;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoriaInformacionRepository extends CrudRepository<CategoriaInformacion, Long> {
    List<CategoriaInformacion> findAll();

    CategoriaInformacion getByCategoria(Categoria categoria);

    CategoriaInformacion getById(Long id);

    @Transactional
    @Query(value = "SELECT * FROM categoria_informacion WHERE categoria_id = :id", nativeQuery = true)
    List<CategoriaInformacion> trerTodaLaInfoPorCategoria(@Param ("id") Long id);
}
