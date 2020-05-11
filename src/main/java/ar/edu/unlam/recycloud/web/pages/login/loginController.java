package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class loginController {

    private final loginService loginService;

    public loginController(loginService loginService) {
        this.loginService = loginService;
    }
//    @GetMapping("/")
//    public String showForm(PersonForm personForm) {
//        return "form";
//    }
//
//    @PostMapping("/")
//    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//
//        return "redirect:/results";
//    }
    @GetMapping(path = "/login")
    public String pantallaLogin (loginModel loginModel) {

            return "/login/login";

    }

    @PostMapping(path = "/login")
    public String confirmar ( HttpSession session,@Valid loginModel loginModel, BindingResult bindingResult) {
        loginModel log = loginService.confirmarUsuario(loginModel.getPass(),loginModel.getUsuario());

        if (bindingResult.hasErrors()){
            return "/login/login";
        }
        else{
            log.setRol(1);
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
