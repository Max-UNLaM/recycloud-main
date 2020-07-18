package ar.edu.unlam.recycloud.api.usuario;

import ar.edu.unlam.recycloud.api.message.ErrorMessage;
import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ar.edu.unlam.recycloud.api.conf.ApiConstants.API_PATH;

@RestController
@RequestMapping(value = API_PATH + "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioApiController {

    private final Gson gson;
    private final UsuarioService usuarioService;

    public UsuarioApiController(Gson gson, UsuarioService usuarioService) {
        this.gson = gson;
        this.usuarioService = usuarioService;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(NotFoundException ie) {
        return new ResponseEntity<>(
                new ErrorMessage(HttpStatus.NOT_FOUND.value(), ie.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping(value = "/{email}")
    public String getByEmail(@PathVariable String email) {
        return gson.toJson(this.usuarioService.getUsuarioByEmail(email));
    }

}
