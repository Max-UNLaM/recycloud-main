package ar.edu.unlam.recycloud.web.pages.home;

import ar.edu.unlam.recycloud.app.usuario.Password;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final UsuarioService usuarioService;

    public HomeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String home(){
        return "/index";
    }
    @GetMapping("/header")
    public String index(){
        return "/index";
    }
    @GetMapping("/home/perfil")
    public ModelAndView perfil(){
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("password", new Password());
        return new ModelAndView("/home/perfil", modelo);
    }

    @PostMapping(path = "/home/password")
    public String confirmar (HttpSession session, @Valid Password pass) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Usuario p = usuarioService.confirmarUsuario(usuario.getEmail(), pass.getOldPassword());
        if(p != null){
            usuarioService.actualizarPass(pass.getNewPassword(), p);
        }
        return "/home/perfil";
    }

    @PostMapping(path = "/home/completar")
        public String completar (HttpSession session, @Valid Usuario usuario, BindingResult asd){
        Usuario user = (Usuario) session.getAttribute("usuario");
        usuarioService.completarDatos(user.getId(), usuario.getIdentificacion());
        session.setAttribute("usuario", usuarioService.validarUsuario(user.getEmail()));
        return "/home/perfil";
    }

    @PostMapping(path = "/home/modificar")
    public String modificar (HttpSession session, Usuario usuario){
        Usuario user = (Usuario) session.getAttribute("usuario");
        usuarioService.modificarDatos(user.getId(), usuario.getDni(),usuario.getDia(),usuario.getMes(), usuario.getAnio());
        session.setAttribute("usuario", usuarioService.validarUsuario(user.getEmail()));
        return "/home/perfil";
    }
}
