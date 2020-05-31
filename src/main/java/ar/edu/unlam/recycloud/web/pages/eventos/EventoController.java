package ar.edu.unlam.recycloud.web.pages.eventos;

import ar.edu.unlam.recycloud.app.evento.Evento;
import ar.edu.unlam.recycloud.app.evento.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
        model.put("eventos", this.eventoService.findAll());
        return new ModelAndView("/eventos/eventos", model);
    }
    @GetMapping(path = "/eventos/crear")
    public String crear(Evento evento) {
        return "/eventos/crear";
    }

    @PostMapping(path = "/eventos/crear")
    public String crearConfirmar(@Valid Evento evento, BindingResult bindingResult)
            //Agregar->HttpSession session,
    {
        if (bindingResult.hasErrors()) {
            return "/eventos/crear";
        } else {
            eventoService.save(evento);
            return "/index";
        }

    }
}
