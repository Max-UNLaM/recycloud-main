package ar.edu.unlam.recycloud.app.recypoints;

import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecypointService {

    private final RecypointRepository recypointRepository;
    private final UsuarioService usuarioService;


    public RecypointService(RecypointRepository recypointRepository, UsuarioService usuarioService) {
        this.recypointRepository = recypointRepository;
        this.usuarioService = usuarioService;
    }

    public List<Recypoint> getAllPointsFromProvider(Usuario provider) {
        return this.recypointRepository.findAllByProvider(provider);
    }

    public Recypoint getPointsFromPair(String providerEmail, String beneficiaryEmail) {
        Usuario provider = usuarioService.getUsuarioByEmail(providerEmail);
        Usuario beneficiary = usuarioService.getUsuarioByEmail(beneficiaryEmail);
        Optional<Recypoint> current = Optional.ofNullable(
                this.recypointRepository.findDistinctFirstByProvider_IdAndBeneficiary_Id(
                        provider.getId(),
                        beneficiary.getId()
                )
        );
        if (current.isPresent()) {
            return current.get();
        } else {
            throw new NotFoundException("No se encontró proveedor " + providerEmail + " para el usuario " + beneficiaryEmail);
        }
    }

    public void addPoints(RecypointCreateDTO create) {
        RecypointUpdateDTO update = new RecypointUpdateDTO();
        update.setProvider(create.getProviderId());
        update.setBeneficiary(usuarioService.getUsuarioByEmail(create.getEmail()).getId());
        update.setAmount(create.getAmount());
        this.addPoints(update);
    }

    public Recypoint addPoints(RecypointUpdateDTO update) {
        Recypoint result;
        Optional<Recypoint> current = Optional.ofNullable(
                this.recypointRepository.findDistinctFirstByProvider_IdAndBeneficiary_Id(
                        update.getProvider(),
                        update.getBeneficiary()
                )
        );

        if (current.isPresent()) {
            result = current.get();
            long currentAmount = result.getAmount();
            result.setAmount(currentAmount + update.getAmount());
        } else {
            result = new Recypoint();
            result.setAmount(update.getAmount());
            result.setBeneficiary(usuarioService.getUsuarioById(update.getBeneficiary()));
            result.setProvider(usuarioService.getUsuarioById(update.getProvider()));
        }
        recypointRepository.save(result);

        return result;
    }

}
