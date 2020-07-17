package ar.edu.unlam.recycloud.app.email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SuscriptoresRepository extends CrudRepository<Suscriptores, Long> {
    @Query(value = "SELECT * FROM suscriptores WHERE email =:email ", nativeQuery=true)
    Suscriptores verificarSiYaExiste(@Param("email") String email);
}
