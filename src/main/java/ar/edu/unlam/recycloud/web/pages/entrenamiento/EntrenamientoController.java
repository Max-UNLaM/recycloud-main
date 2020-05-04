package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    public ModelAndView guardarEntrenamiento (@ModelAttribute Object clasificador) {
            this.en.guardarClasificador(clasificador);
            return new ModelAndView("redirect:/Scanner/scanner");
    }
}
