package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.web.pages.entrenamiento.EntrenamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScannerController {

    private final EntrenamientoService entrenamientoService;

    ScannerController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @RequestMapping(path = "/scanner/scanner")
    public ModelAndView read() {
        return new ModelAndView("scanner/scanner");
    }
}
