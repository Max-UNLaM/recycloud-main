package ar.edu.unlam.recycloud.web.pages.login;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        modelo.addAttribute("usuario", new Usuario());
        return new ModelAndView("/login/login", modelo);
    }

    @PostMapping(path = "/login")
    public String confirmar(HttpSession session, Usuario usuario, BindingResult asd) {
        Usuario log = usuarioService.confirmarUsuario(usuario.getEmail(), usuario.getPassword());

        if (log == null) {
            return "/login/login";
        } else {
            session.setAttribute("usuario", log);
            return "/index";
        }
    }

    @GetMapping(path = "/login/registrar")
    public ModelAndView registrar() {
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("usuario", new Usuario());
        return new ModelAndView("/login/registrar", modelo);
    }

    @PostMapping(path = "/login/registrar")
    public String registrarConfirmar(HttpSession session, @Valid Usuario usuario) {
        Usuario l = usuarioService.validarUsuario(usuario.getEmail());
        if(l != null){
            return "/login/registrar";
        }
        usuario.setRol(2);
        usuarioService.registro(usuario);
        Usuario log = usuarioService.validarUsuario(usuario.getEmail());
        session.setAttribute("usuario", log);
        return "/index";
    }
}
