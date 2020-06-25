package ar.edu.unlam.recycloud.app.usuario;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
    @Query(value = "SELECT * FROM usuario WHERE email = :email AND password = :password", nativeQuery=true)
    Usuario buscarUsuario(@Param ("email") String email, @Param ("password") String password);
    @Query(value = "SELECT * FROM usuario WHERE email = :email", nativeQuery = true)
    Usuario validarUsuario(@Param ("email") String email);
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET password = :password WHERE id = :id", nativeQuery = true)
    void cambiarPassword(@Param ("password") String password, @Param ("id") Long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET identificacion = :identificacion, rol = 3 WHERE id = :id", nativeQuery = true)
    void completarUsuario(@Param ("id") Long id, @Param ("identificacion") Integer identificacion);
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET dni = :dni, dia = :dia, mes = :mes, anio = :anio WHERE id = :id", nativeQuery = true)
    void modificarUsuario(@Param ("id") Long id, @Param ("dni") Integer dni, @Param ("dia") Integer dia, @Param ("mes") String mes, @Param ("anio") Integer anio);
}
