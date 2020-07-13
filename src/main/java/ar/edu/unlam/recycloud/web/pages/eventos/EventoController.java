package ar.edu.unlam.recycloud.web.pages.eventos;

import ar.edu.unlam.recycloud.app.evento.Evento;
import ar.edu.unlam.recycloud.app.evento.EventoService;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EventoController {
    private final EventoService eventoService;
    public EventoController(EventoService eventoService) {
        this.eventoService=eventoService;
    }

    @GetMapping(path = "/eventos")
    public ModelAndView listar() {
        ModelMap model = new ModelMap();
        model.addAttribute("listaDeEventos", eventoService.findAllByOrderByFechaAsc());
        return new ModelAndView("/eventos/eventos", model);
    }

    @GetMapping(path = "/eventos/crear")
    public ModelAndView crear(HttpSession session) {
        ModelMap modelo = new ModelMap();
        Usuario user = (Usuario) session.getAttribute("usuario");
        modelo.addAttribute("evento", new Evento());
        modelo.addAttribute("listaDeEventos", eventoService.eventosPorId(user));
        return new ModelAndView("/eventos/crear", modelo);
    }

    @PostMapping(path = "/eventos/crear")
    public String crearConfirmar(HttpSession session, @Valid Evento evento, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            return "/eventos/crear";
        } else {
            Usuario user = (Usuario) session.getAttribute("usuario");
            eventoService.save(evento, user);
            return "redirect:/";
        }
    }

    @GetMapping(path = "/eventos/filtro/{tiempo}")
    public ModelAndView leer(@PathVariable String tiempo) {
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("listaDeEventos", eventoService.filtroPorTiempo(tiempo));
        return new ModelAndView("/eventos/eventos", modelo);
    }
}
