package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit;

import ar.edu.unlam.recycloud.app.google.GoogleService;
import ar.edu.unlam.recycloud.app.map.dialog.Dialog;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PuntoReciclajeEditFactory {

    private final GoogleService googleService;

    public PuntoReciclajeEditFactory(GoogleService googleService) {
        this.googleService = googleService;
    }

    public PuntoReciclajeEdit build(Dialog dialog) {
        PuntoReciclajeEdit result = new PuntoReciclajeEdit();
        result.setTitle(dialog.getFirstHeading());
        result.setCoordinates(dialog.getCoordinates());
        LatLng latLng = new LatLng(result.getCoordinatesAsList().get(0), result.getCoordinatesAsList().get(1));
        try {
            result.setAddress(googleService.geoLocate(latLng).formattedAddress);
        } catch (InterruptedException | IOException | ApiException e) {
            result.setAddress(dialog.getAddress());
        }
        result.setDays(dialog.getDaysAsString());
        result.setCategories(dialog.getCategoriesAsString());
        result.setContent(dialog.getBodyContent());
        result.setBeginHour(dialog.getBeginHour());
        result.setEndHour(dialog.getEndHour());
        result.setLink(dialog.getLink());
        return result;
    }

}
