package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.recypoints;

import ar.edu.unlam.recycloud.app.recypoints.RecypointCreateDTO;
import ar.edu.unlam.recycloud.app.recypoints.RecypointService;
import ar.edu.unlam.recycloud.app.recypoints.RecypointUpdateDTO;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.recypoints.home.RecypointsVMService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static ar.edu.unlam.recycloud.web.pages.puntoreciclaje.recypoints.RecypointsConstants.BASE_PATH;


@Controller
@RequestMapping(BASE_PATH)
public class RecypointsController {

    private final RecypointsVMService service;
    private final RecypointService recypointService;

    public RecypointsController(RecypointsVMService service, RecypointService recypointService) {
        this.service = service;
        this.recypointService = recypointService;
    }

    @GetMapping
    public ModelAndView index(HttpSession session) {
        ModelMap model = new ModelMap();
        model.put("data", this.service.build((Usuario) session.getAttribute("usuario")));
        return new ModelAndView("punto-reciclaje/recypoints/home", model);
    }

    @PostMapping
    public String home(@ModelAttribute RecypointCreateDTO data) {
        RecypointUpdateDTO update = new RecypointUpdateDTO();
        recypointService.addPoints(data);
        return "redirect:" + BASE_PATH;
    }

    @GetMapping(value = "/create")
    public String create(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        RecypointCreateDTO form = new RecypointCreateDTO();
        form.setProviderId(usuario.getId());
        model.addAttribute("form", form);
        model.addAttribute("providerId", usuario.getId());
        return "punto-reciclaje/recypoints/create";
    }


}
