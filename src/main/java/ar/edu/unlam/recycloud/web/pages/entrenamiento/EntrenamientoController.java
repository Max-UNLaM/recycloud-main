package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntrenamientoController {

    entrenamientoService en = new entrenamientoService();

    @GetMapping("/entrenamiento")
    public String scanner() {
        return "/entrenamiento/entrenamiento";
    }

    @RequestMapping(path = "/entrenamiento/guardarEntrenamiento", method = RequestMethod.POST)
    public ModelAndView guardar (@ModelAttribute entrenamientoModel clasificador) {
        this.en.guardarClasificador(clasificador);
        return new ModelAndView("redirect:/Scanner/scanner");
    }
}
