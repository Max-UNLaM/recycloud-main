package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.web.pages.entrenamiento.entrenamientoModel;
import ar.edu.unlam.recycloud.web.pages.entrenamiento.entrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScannerController {

    @Autowired
    public ar.edu.unlam.recycloud.web.pages.entrenamiento.entrenamientoService entrenamientoService;

    @RequestMapping(path = "/Scanner/scanner", method = RequestMethod.GET)
    public ModelAndView recibir (@ModelAttribute entrenamientoModel clasificador) {


        ModelMap model = new ModelMap();
        model.put("clasificador",entrenamientoService.traerClasificador());
        return new ModelAndView("/scanner/scanner",model);
    }
}
