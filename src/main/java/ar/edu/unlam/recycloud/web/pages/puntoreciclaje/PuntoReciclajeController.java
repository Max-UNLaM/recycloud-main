package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.PuntoReciclajeConstants.BASE_PATH;

@Controller
public class PuntoReciclajeController {

    private final PuntoReciclajeVMService puntoReciclajeVMService;

    public PuntoReciclajeController(PuntoReciclajeVMService puntoReciclajeVMService) {
        this.puntoReciclajeVMService = puntoReciclajeVMService;
    }

    @GetMapping(value = BASE_PATH)
    public ModelAndView home(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", this.puntoReciclajeVMService.buildPuntoReciclajeVM(usuario));
        return new ModelAndView("punto-reciclaje/home", modelMap);
    }

}
