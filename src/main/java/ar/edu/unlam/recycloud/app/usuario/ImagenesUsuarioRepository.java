package ar.edu.unlam.recycloud.app.usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImagenesUsuarioRepository extends CrudRepository<ImagenesUsuario, Long> {
    @Query(value = "SELECT * FROM imagenes_usuario WHERE usuario_id = :id", nativeQuery=true)
    List<ImagenesUsuario> buscarPorIdDeUsuario(@Param("id") Long id);
}
