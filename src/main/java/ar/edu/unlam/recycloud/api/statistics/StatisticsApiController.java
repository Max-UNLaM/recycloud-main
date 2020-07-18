package ar.edu.unlam.recycloud.api.statistics;

import ar.edu.unlam.recycloud.api.message.ErrorMessage;
import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
@RequestMapping(value = API_PATH + "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticsApiController {

    private final Gson gson;
    private final StatisticsApiService statisticsApiService;

    public StatisticsApiController(Gson gson, StatisticsApiService statisticsApiService) {
        this.gson = gson;
        this.statisticsApiService = statisticsApiService;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(NotFoundException ie) {
        return new ResponseEntity<>(
                new ErrorMessage(HttpStatus.NOT_FOUND.value(), ie.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping(value = "/top-dialogs")
    public String getTopPines() {
        return gson.toJson(statisticsApiService.getTopDialogs());
    }

    @GetMapping(value = "/locations")
    public String getLocations() {
        return gson.toJson(statisticsApiService.getLocations());
    }

    @GetMapping(value = "/datasets/dialogs")
    public String getDialogs() throws IOException {
        return gson.toJson(statisticsApiService.getDatasets());
    }

    @GetMapping(value = "/datasets/top-points")
    public String getTopPointsDataset() throws IOException {
        return gson.toJson(statisticsApiService.getPuntoStatisticLineCharts());
    }
}
