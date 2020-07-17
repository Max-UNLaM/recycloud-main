package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EntrenamientoController {

    @GetMapping("/entrenamiento")
    public String scanner( HttpSession session) {
        Usuario l= (Usuario) session.getAttribute("usuario");
        if(l == null){
            return "redirect:/";
        }
        if(l.getRol() != 1){
            return "redirect:/";
        }
        return "/entrenamiento/entrenamiento";
    }
}
