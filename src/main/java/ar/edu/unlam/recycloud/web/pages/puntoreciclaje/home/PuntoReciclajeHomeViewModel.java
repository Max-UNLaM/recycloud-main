package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home;

import ar.edu.unlam.recycloud.app.map.pin.Pin;
import lombok.Data;

import java.util.List;

@Data
public class PuntoReciclajeHomeViewModel {
    List<Pin> userPines;
}
