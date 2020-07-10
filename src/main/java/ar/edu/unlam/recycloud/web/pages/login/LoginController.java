package ar.edu.unlam.recycloud.web.pages.login;

import ar.edu.unlam.recycloud.app.usuario.Login;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(path = "/login/cerrarSession")
    public String cerrarSession(HttpSession session) {
        session.setAttribute("usuario", null);
        return "/index";
    }

    @GetMapping(path = "/login")
    public ModelAndView pantallaLogin() {
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("login", new Login());
        return new ModelAndView("/login/login", modelo);
    }

    @PostMapping(path = "/login")
    public String confirmar(HttpSession session, @Valid Login login, BindingResult bindingResult) {
        Usuario log= new Usuario();
        if (bindingResult.hasErrors()) {
            return "/login/login";
        }
        else{
            log = usuarioService.confirmarUsuario(login.getEmail(), login.getPassword());
            if (log == null) {
                return "/login/login";
            } else {
                session.setAttribute("usuario", log);
                return "/index";
            }
        }

    }

    @GetMapping(path = "/login/registrar")
    public ModelAndView registrar() {
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("usuario", new Usuario());
        return new ModelAndView("/login/registrar", modelo);
    }

    @PostMapping(path = "/login/registrar")
    public String registrarConfirmar(HttpSession session, @Valid Usuario usuario, BindingResult bindingResult){
        Usuario l;
        if (bindingResult.hasErrors()) {
            return "/login/registrar";
        }
        else{
            l = usuarioService.validarUsuario(usuario.getEmail());
            if(l != null){
                return "/login/registrar";
            }
            usuario.setRol(2);
            usuario.setIdentificacion(0);
            usuarioService.registro(usuario);
            Usuario log = usuarioService.validarUsuario(usuario.getEmail());
            session.setAttribute("usuario", log);
            return "/index";
        }
    }

/*
    @GetMapping(path = "/login/logingoogle")
    public String loginGoogle() {
        return "/login/logingoogle";
    }*/

    @PostMapping(value = "logingooglefacebook")
    public String logingooglefacebook(HttpSession session, HttpServletRequest request) {
        Usuario usr= new Usuario();
        Usuario u = usuarioService.validarUsuario(request.getParameter("email"));
        if(u == null){
            usr.setNombre(request.getParameter("nombre"));
            usr.setApellido(request.getParameter("apellido"));
            usr.setPassword(request.getParameter("pass"));
            usr.setEmail(request.getParameter("email"));
            usr.setRol(2);
            usr.setIdentificacion(2);// es por que es google o facebook
            usuarioService.registro(usr);
            session.setAttribute("usuario", usr);
        }
        else{
            session.setAttribute("usuario", u);
        }

        return "/index";

    }
   /* @RequestMapping(...)
    public String getCountySelected(@RequestParam(value = "UR_PARAM_NAME") String param){
        return "/login/logingoogle";
    }*/
}
