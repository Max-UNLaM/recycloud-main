package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class loginController {

    private final loginService loginService;

    public loginController(loginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(path = "/login")
    public String pantallaLogin () {
        return "/login/login";
    }

    @RequestMapping(path = "/login/confirmar", method = RequestMethod.POST )
    public String confirmar (@ModelAttribute loginModel usuario, HttpServletRequest request) {
        loginModel log = new loginModel();
            log = loginService.confirmarUsuario(usuario.getPass(),usuario.getUsuario());
            log.setRol(1);
        if(log == null){
            return "redirect:/login/login";
        }
        else{
            request.getSession().setAttribute("usuario",log);
            return "/index";
        }
    }

}
