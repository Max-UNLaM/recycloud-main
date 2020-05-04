package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.web.pages.entrenamiento.EntrenamientoModel;
import ar.edu.unlam.recycloud.web.pages.entrenamiento.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScannerController {

    private final EntrenamientoService entrenamientoService;

    ScannerController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @RequestMapping(path = "/Scanner/scanner", method = RequestMethod.POST)
    public ModelAndView recibir () {
        ModelMap m= new ModelMap();
        m.put("clasif",entrenamientoService.traerClasificador());
        return new ModelAndView("scanner/scanner", m);
    }
}
