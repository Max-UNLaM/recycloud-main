package ar.edu.unlam.recycloud.app.recypoints;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecypointRepository extends CrudRepository<Recypoint, Long> {

    List<Recypoint> findAllByProvider(Usuario provider);

    List<Recypoint> findAllByBeneficiary(Usuario provider);

    Recypoint findDistinctFirstByProvider_IdAndBeneficiary_Id(long provider, long beneficiary);

}
