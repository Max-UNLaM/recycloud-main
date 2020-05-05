package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntrenamientoController {

    private final EntrenamientoService en;

    EntrenamientoController(EntrenamientoService en) {
        this.en = en;
    }

    @GetMapping("/entrenamiento")
    public String scanner() {
        return "/entrenamiento/entrenamiento";
    }


    @RequestMapping(path = "/entrenamiento/guardarEntrenamiento", method = RequestMethod.POST)
    public String guardarEntrenamiento (@ModelAttribute EntrenamientoModel clasificador) {
            this.en.guardarClasificador(clasificador.getEntreno());
            return "/entrenamiento/entrenamiento";
    }
}
