package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.recypoints.home;

import ar.edu.unlam.recycloud.app.recypoints.RecypointService;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class RecypointsVMService {

    private final RecypointService recypointService;

    public RecypointsVMService(RecypointService recypointService) {
        this.recypointService = recypointService;
    }

    public RecypointsHomeViewModel build(Usuario usuario) {
        RecypointsHomeViewModel model = new RecypointsHomeViewModel();
        model.setGivenRecypoints(this.recypointService.getAllPointsFromProvider(usuario));
        model.setProviderId(usuario.getId());
        return model;
    }

}
