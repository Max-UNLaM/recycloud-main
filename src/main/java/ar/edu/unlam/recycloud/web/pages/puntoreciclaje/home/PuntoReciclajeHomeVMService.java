package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home;

import ar.edu.unlam.recycloud.app.geolocation.Location;
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
public class PuntoReciclajeHomeVMService {

    private final PinService pinService;
    private final PuntoReciclajeService puntoReciclajeService;
    private final MongoFilterFactory mongoFilterFactory;

    public PuntoReciclajeHomeVMService(PinService pinService, PuntoReciclajeService puntoReciclajeService, MongoFilterFactory mongoFilterFactory) {
        this.pinService = pinService;
        this.puntoReciclajeService = puntoReciclajeService;
        this.mongoFilterFactory = mongoFilterFactory;
    }

    public PuntoReciclajeHomeViewModel build(Usuario usuario) {
        List<PuntoReciclajeElement> puntoReciclajeElements = new ArrayList<>();
        List<PuntoReciclaje> puntoReciclajes = puntoReciclajeService.listByUserId(usuario.getId());
        puntoReciclajes.forEach(puntoReciclaje -> {
            Pin pin = getPinFromPuntoReciclaje(puntoReciclaje);
            puntoReciclajeElements.add(new PuntoReciclajeElement(pin, puntoReciclaje));
        });
        PuntoReciclajeHomeViewModel viewModel = new PuntoReciclajeHomeViewModel();
        viewModel.setPuntosReciclaje(puntoReciclajeElements);
        return viewModel;
    }

    private Pin getPinFromPuntoReciclaje(PuntoReciclaje puntoReciclajes) {
        return getPinFromCoord(puntoReciclajes.getCoordinatesAsDouble()).get(0);
    }

    private List<Pin> getPinFromCoord(List<Double> coords) {
        Location location = new Location();
        location.setCoordinates(coords);
        return pinService.get(mongoFilterFactory.locationFilter(location));
    }

}
