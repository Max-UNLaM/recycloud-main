package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.PuntoReciclajeConstants.BASE_PATH;
import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.PuntoReciclajeConstants.CREATE_PATH;

@Controller
@SessionScope
public class PuntoReciclajeController {

    private final PuntoReciclajeVMService puntoReciclajeVMService;
    private static final Integer VALID_ROL = 3;

    public PuntoReciclajeController(PuntoReciclajeVMService puntoReciclajeVMService) {
        this.puntoReciclajeVMService = puntoReciclajeVMService;
    }

    @GetMapping(value = BASE_PATH)
    public ModelAndView home(HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView("index");
        }
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", this.puntoReciclajeVMService.buildHome(usuario));
        return new ModelAndView("punto-reciclaje/home", modelMap);
    }

    @GetMapping(value = CREATE_PATH)
    public ModelAndView create(HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView("index");
        }
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", this.puntoReciclajeVMService.buildCreate());
        return new ModelAndView("punto-reciclaje/create", modelMap);
    }

}
