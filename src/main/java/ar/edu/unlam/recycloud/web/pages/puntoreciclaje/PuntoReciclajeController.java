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

import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.PuntoReciclajeConstants.*;

@Controller
@SessionScope
@RequestMapping(BASE_PATH)
public class PuntoReciclajeController {

    private static final Integer VALID_ROL = 3;
    private final PuntoReciclajeViewService puntoReciclajeViewService;

    public PuntoReciclajeController(PuntoReciclajeViewService puntoReciclajeViewService) {
        this.puntoReciclajeViewService = puntoReciclajeViewService;
    }

    @GetMapping
    public ModelAndView home(HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView( "redirect:/");
        }
        ModelMap modelMap = new ModelMap();
        usuario.setId(usuario.getId());
        modelMap.put("data", this.puntoReciclajeViewService.buildHome(usuario));
        return new ModelAndView("punto-reciclaje/home", modelMap);
    }

    @GetMapping(value = CREATE_PATH)
    public String create(HttpSession httpSession, Model model) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return "redirect:/";
        }
        model.addAttribute("data", puntoReciclajeViewService.buildCreate());
        model.addAttribute("form", new PuntoReciclajeEdit());
        return "punto-reciclaje/create";
    }

    @PostMapping(value = CREATE_PATH)
    public ModelAndView create(
            HttpSession httpSession,
            @ModelAttribute("PuntoReciclajeForm") PuntoReciclajeEdit puntoReciclajeEdit
    ) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView( "redirect:/");
        }
        PuntoReciclaje pr = puntoReciclajeViewService.save(puntoReciclajeEdit, usuario.getId());
        return new ModelAndView("redirect:/punto-reciclaje");
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
    ) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null || !usuario.getRol().equals(VALID_ROL)) {
            return new ModelAndView( "redirect:/");
        }
        PuntoReciclaje pr = puntoReciclajeViewService.update(puntoReciclajeEdit, 2L, id);
        return new ModelAndView("redirect:/punto-reciclaje/edit/" + pr.getId());
    }

}
