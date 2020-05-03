package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntrenamientoController {

    public String a;

    @GetMapping("/entrenamiento")
    public String scanner() {
        return "/entrenamiento/entrenamiento";
    }

    @RequestMapping(path = "/entrenamiento/guardarEntrenamiento", method = RequestMethod.POST)
    public String guardar (@ModelAttribute String clasificador) {
        this.a=clasificador;
        return "/entrenamiento/entrenamiento";
    }
}
