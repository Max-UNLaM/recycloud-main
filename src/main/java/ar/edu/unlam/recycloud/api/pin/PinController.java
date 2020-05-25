package ar.edu.unlam.recycloud.api.pin;

import ar.edu.unlam.recycloud.app.map.dialog.DialogService;
import ar.edu.unlam.recycloud.app.utils.GsonRecyBuilder;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
public class PinController {

    private static final String PIN_PATH = "/pin";
    private static final String DIALOG_PATH = "/dialog";
    private final DialogService dialogService;
    private final Gson gson;
    private final PinApiService pinApiService;

    PinController(DialogService dialogService, GsonRecyBuilder gsonRecyBuilder, PinApiService pinApiService) {
        this.dialogService = dialogService;
        this.pinApiService = pinApiService;
        this.gson = gsonRecyBuilder.getGson();
    }

    @GetMapping(value = API_PATH + PIN_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllPines() {
        return gson.toJson(pinApiService.getAllPines());
    }

    @GetMapping(value = API_PATH + PIN_PATH + "/{coords}" + DIALOG_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDialogFromPin(@PathVariable(name = "coords") double[] coords) {
        return gson.toJson(dialogService.getDialogFromDouble(coords));
    }
}
