package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create.PuntoReciclajeCreateVMService;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create.PuntoReciclajeCreateViewModel;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home.PuntoReciclajeHomeVMService;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home.PuntoReciclajeHomeViewModel;
import org.springframework.stereotype.Service;

@Service
class PuntoReciclajeVMService {

    private final PuntoReciclajeCreateVMService puntoReciclajeCreateVMService;
    private final PuntoReciclajeHomeVMService puntoReciclajeHomeVMService;

    PuntoReciclajeVMService(PuntoReciclajeCreateVMService puntoReciclajeCreateVMService, PuntoReciclajeHomeVMService puntoReciclajeHomeVMService) {
        this.puntoReciclajeCreateVMService = puntoReciclajeCreateVMService;
        this.puntoReciclajeHomeVMService = puntoReciclajeHomeVMService;
    }

    PuntoReciclajeHomeViewModel buildHome(Usuario usuario) {
        return puntoReciclajeHomeVMService.build(usuario);
    }

    PuntoReciclajeCreateViewModel buildCreate() {
        return puntoReciclajeCreateVMService.build();
    }

}
