package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclaje;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit.PuntoReciclajeEdit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.util.concurrent.ExecutionException;

import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.PuntoReciclajeConstants.*;

@Controller
@SessionScope
public class PuntoReciclajeController {

    private static final Integer VALID_ROL = 3;
    private final PuntoReciclajeViewService puntoReciclajeViewService;

    public PuntoReciclajeController(PuntoReciclajeViewService puntoReciclajeViewService) {
        this.puntoReciclajeViewService = puntoReciclajeViewService;
    }

    @GetMapping(value = BASE_PATH)
    public ModelAndView home(HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView("index");
        }
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", this.puntoReciclajeViewService.buildHome(usuario));
        return new ModelAndView("punto-reciclaje/home", modelMap);
    }

    @GetMapping(value = CREATE_PATH)
    public String create(HttpSession httpSession, Model model) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return "index";
        }
        model.addAttribute("data", puntoReciclajeViewService.buildCreate());
        model.addAttribute("form", new PuntoReciclajeEdit());
        return "punto-reciclaje/create";
    }

    @PostMapping(value = CREATE_PATH)
    public ModelAndView create(
            HttpSession httpSession,
            @ModelAttribute("PuntoReciclajeForm") PuntoReciclajeEdit puntoReciclajeEdit
    ) throws ExecutionException, InterruptedException {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView("index");
        }
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", puntoReciclajeViewService.save(puntoReciclajeEdit, usuario.getId()));
        return new ModelAndView("punto-reciclaje/edit", modelMap);
    }

    @RequestMapping(value = EDIT_PATH + "/{puntoId}")
    public String updateView(@PathVariable(value = "puntoId") Long id, Model model) {
        model.addAttribute("data", this.puntoReciclajeViewService.buildEdit(id));
        model.addAttribute("form", this.puntoReciclajeViewService.getPuntoReciclajeEditById(id));
        return "punto-reciclaje/edit";
    }

    @PostMapping(value = EDIT_PATH + "/{puntoId}")
    public ModelAndView update(
            HttpSession httpSession,
            @PathVariable(value = "puntoId") Long id,
            @ModelAttribute("PuntoReciclajeForm") PuntoReciclajeEdit puntoReciclajeEdit
    ) throws ExecutionException, InterruptedException {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        ModelMap modelMap = new ModelMap();
        PuntoReciclaje pr = puntoReciclajeViewService.update(puntoReciclajeEdit, 2L, id);
        modelMap.put("form", puntoReciclajeEdit);
        return new ModelAndView("redirect:/punto-reciclaje/edit/" + pr.getId());
    }

}
