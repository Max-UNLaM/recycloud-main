package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home;

import ar.edu.unlam.recycloud.app.map.pin.Pin;
import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclaje;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuntoReciclajeElement {
    private Pin pin;
    private PuntoReciclaje puntoReciclaje;
}
