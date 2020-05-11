package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import ar.edu.unlam.recycloud.web.pages.login.loginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EntrenamientoController {

    private final EntrenamientoService en;

    EntrenamientoController(EntrenamientoService en) {
        this.en = en;
    }

    @GetMapping("/entrenamiento")
    public String scanner( HttpSession session) {
        loginModel l= (loginModel) session.getAttribute("usuario");
        if(l == null){
            return ("/index");
        }
        if(l.getRol() != 1){
            return ("/index");
        }
        return "/entrenamiento/entrenamiento";
    }
}
