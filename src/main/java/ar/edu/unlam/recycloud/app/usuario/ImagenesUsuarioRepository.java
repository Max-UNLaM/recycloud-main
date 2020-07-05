package ar.edu.unlam.recycloud.app.usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImagenesUsuarioRepository extends CrudRepository<ImagenesUsuario, Long> {
    @Query(value = "SELECT * FROM imagenes_usuario WHERE estado =1 ORDER BY usuario_id", nativeQuery=true)
    List<ImagenesUsuario> buscarPorIdDeUsuario();
    @Query(value = "SELECT * FROM imagenes_usuario WHERE estado =1 GROUP BY usuario_id ORDER BY usuario_id", nativeQuery=true)
    List<ImagenesUsuario> usuariosParaValidar();

    @Transactional
    @Modifying
    @Query(value = "UPDATE imagenes_usuario SET estado=0 WHERE usuario_id = :id", nativeQuery = true)
    void cambiarEstadoImagen(@Param ("id") Long id);
}
