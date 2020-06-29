package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.map.pin.Pin;
import ar.edu.unlam.recycloud.app.map.pin.PinService;
import ar.edu.unlam.recycloud.app.mongo.MongoFilterFactory;
import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclaje;
import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclajeService;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PuntoReciclajeVMService {

    private final PinService pinService;
    private final PuntoReciclajeService puntoReciclajeService;
    private final MongoFilterFactory mongoFilterFactory;

    PuntoReciclajeVMService(PinService pinService, PuntoReciclajeService puntoReciclajeService, MongoFilterFactory mongoFilterFactory) {
        this.pinService = pinService;
        this.puntoReciclajeService = puntoReciclajeService;
        this.mongoFilterFactory = mongoFilterFactory;
    }

    PuntoReciclajeHomeViewModel buildPuntoReciclajeVM(Usuario usuario) {
        PuntoReciclajeHomeViewModel viewModel = new PuntoReciclajeHomeViewModel();
        viewModel.setUserPines(getPinesFromUser(usuario));
        return viewModel;
    }

    private List<Pin> getPinesFromUser(Usuario usuario) {
        List<PuntoReciclaje> puntoReciclajes = puntoReciclajeService.listByUserId(usuario.getId());
        List<String> coords = new ArrayList<>();
        puntoReciclajes.forEach((el) -> coords.add(el.getCoordinates()));
        return pinService.get(mongoFilterFactory.locationListFilter(coords));
    }

}
