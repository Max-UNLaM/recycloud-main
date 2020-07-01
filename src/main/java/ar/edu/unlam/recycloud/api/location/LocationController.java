package ar.edu.unlam.recycloud.api.location;

import ar.edu.unlam.recycloud.api.message.ErrorMessage;
import ar.edu.unlam.recycloud.app.google.GoogleService;
import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
@RequestMapping(API_PATH)
public class LocationController {

    private static final String GEOLOCATE = "/geolocate";
    private static final String DEGEOLOCATE = "/degeolocate";
    private final GoogleService googleService;
    private final Gson gson;

    public LocationController(GoogleService googleService, Gson gson) {
        this.googleService = googleService;
        this.gson = gson;
    }

    @ExceptionHandler(InterruptedException.class)
    public String handleException(InterruptedException ie) {
        return this.gson.toJson(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ie.getMessage()));
    }

    @ExceptionHandler(IOException.class)
    public String handleException(IOException ie) {
        return this.gson.toJson(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ie.getMessage()));
    }

    @ExceptionHandler(ApiException.class)
    public String handleException(ApiException ie) {
        return this.gson.toJson(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ie.getMessage()));
    }


    @GetMapping(value = GEOLOCATE)
    public String getGeolocation(@RequestParam String address) throws InterruptedException, ApiException, IOException {
        return this.gson.toJson(googleService.geoLocate(address));
    }

    @GetMapping(value = DEGEOLOCATE)
    public String getDegeolocation(@RequestParam Double[] coords) throws InterruptedException, ApiException, IOException {
        return this.gson.toJson(googleService.geoLocate(new LatLng(coords[0], coords[1])));
    }

}
