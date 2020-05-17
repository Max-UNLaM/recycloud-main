package ar.edu.unlam.recycloud.web.pages.eventos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class eventosController {

    @GetMapping(path = "/eventos")
    public String read() {
        return "/eventos/eventos";
    }
}
