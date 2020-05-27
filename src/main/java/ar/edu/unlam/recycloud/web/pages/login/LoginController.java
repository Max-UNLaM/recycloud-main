package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(path = "/login/cerrarSession")
    public String cerrarSession(HttpSession session) {
        session.setAttribute("usuario", null);
        return "/index";
    }

    @GetMapping(path = "/login")
    public String pantallaLogin(LoginModel loginModel) {

        return "/login/login";

    }

    @PostMapping(path = "/login")
    public String confirmar(HttpSession session, @Valid LoginModel loginModel, BindingResult bindingResult) {
        LoginModel log = loginService.confirmarUsuario(loginModel.getPass(), loginModel.getUsuario());

        if (bindingResult.hasErrors()) {
            return "/login/login";
        } else {
            log.setRol(1);
            session.setAttribute("usuario", log);
            return "/index";
        }
    }

    @GetMapping(path = "/login/registrar")
    public String registrar(RegisterModel RegisterModel) {
        return "/login/registrar";
    }

    @PostMapping(path = "/login/registrar")
    public String registrarConfirmar(HttpSession session, @Valid RegisterModel RegisterModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/login/registrar";
        } else {
            LoginModel log = loginService.confirmarUsuario(RegisterModel.getPass(), RegisterModel.getNombre());
            log.setRol(1);
            session.setAttribute("usuario", log);
            return "/index";
        }
    }

}
