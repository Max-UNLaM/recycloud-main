package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntrenamientoController {

    @GetMapping("/entrenamiento")
    public String scanner() {
        return "/entrenamiento/entrenamiento";
    }
}
