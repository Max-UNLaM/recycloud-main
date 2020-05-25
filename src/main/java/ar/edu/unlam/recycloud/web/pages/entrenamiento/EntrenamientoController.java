package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import ar.edu.unlam.recycloud.web.pages.login.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EntrenamientoController {

    @GetMapping("/entrenamiento")
    public String scanner( HttpSession session) {
        LoginModel l= (LoginModel) session.getAttribute("usuario");
        if(l == null){
            return ("/index");
        }
        if(l.getRol() != 1){
            return ("/index");
        }
        return "/entrenamiento/entrenamiento";
    }
}
