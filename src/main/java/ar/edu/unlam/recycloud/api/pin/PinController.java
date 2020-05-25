package ar.edu.unlam.recycloud.api.pin;

import ar.edu.unlam.recycloud.app.utils.GsonRecyBuilder;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
public class PinController {

    private final PinApiService pinApiService;
    private final Gson gson;

    PinController(PinApiService pinApiService, GsonRecyBuilder gsonRecyBuilder) {
        this.pinApiService = pinApiService;
        this.gson = gsonRecyBuilder.getGson();
    }

    @GetMapping(value = API_PATH + "/pin", produces = MediaType.APPLICATION_JSON_VALUE)

    public String getAllPines() {
        return gson.toJson(pinApiService.getAllPines());
    }

}
