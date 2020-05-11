package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    private final loginService loginService;

    public loginController(loginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(path = "/login")
    public String pantallaLogin (HttpSession session) {
        session.setAttribute("usuario",null);
        return "/login/login";
    }

    @RequestMapping(path = "/login/confirmar", method = RequestMethod.POST )
    public String confirmar (@ModelAttribute loginModel usuario, HttpSession session) {
        loginModel log = new loginModel();
            log = loginService.confirmarUsuario(usuario.getPass(),usuario.getUsuario());
            log.setRol(1);
        if(log == null){
            return "redirect:/login/login";
        }
        else{
            session.setAttribute("usuario",log);
            return "/index";
        }
    }

    @RequestMapping(path = "/login/cerrarSession")
    public String cerrarSession ( HttpSession session) {
            session.setAttribute("usuario",null);
            return "/index";
    }
    @RequestMapping(path = "/login/registrar", method = RequestMethod.POST )
    public String registrarConfirmar ( registrarModel reg, HttpSession session) {
        if(false){
            return "/login/registrar";
        }
        loginModel log = loginService.confirmarUsuario(reg.getPass(),reg.getNombre());
        log.setRol(1);
        session.setAttribute("usuario",log);
        return "/index";
    }
    @RequestMapping(path = "/login/registrar")
    public String registrar (HttpSession session) {
        session.setAttribute("usuario",null);
        return "/login/registrar";
    }
}
