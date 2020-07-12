package ar.edu.unlam.recycloud.api.recypoints;


import ar.edu.unlam.recycloud.app.exceptions.BadRequestException;
import ar.edu.unlam.recycloud.app.recypoints.RecypointService;
import ar.edu.unlam.recycloud.app.recypoints.RecypointUpdateDTO;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
@RequestMapping(value = API_PATH + "/recypoints", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecypointsApiController {

    private final Gson gson;
    private final RecypointService recypointService;

    public RecypointsApiController(Gson gson, RecypointService recypointService) {
        this.gson = gson;
        this.recypointService = recypointService;
    }

    @PutMapping(value = "/add/{id}")
    private String add(@PathVariable long id, @RequestBody() RecypointUpdateDTO data) {
        if (id != data.getBeneficiary()) {
            throw new BadRequestException("Beneficiary's body does not match path id");
        }
        return gson.toJson(this.recypointService.addPoints(data));
    }

}
