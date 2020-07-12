package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.recypoints.home;

import ar.edu.unlam.recycloud.app.recypoints.Recypoint;
import lombok.Data;

import java.util.List;

@Data
public class RecypointsHomeViewModel {

    private List<Recypoint> givenRecypoints;
    private long providerId;

}
