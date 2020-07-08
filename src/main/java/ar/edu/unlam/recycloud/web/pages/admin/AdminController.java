package ar.edu.unlam.recycloud.web.pages.admin;

import ar.edu.unlam.recycloud.app.usuario.ImagenesUsuario;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsuarioService usuarioService;

    public AdminController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/estadisticas")
    public ModelAndView as(HttpSession session){
        ModelMap modelo = new ModelMap();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        modelo.addAttribute("usuario", usuarioService.validarUsuario(usuario.getEmail()));
        modelo.addAttribute("estadisticas", usuarioService.getAllEstadistics());
        return new ModelAndView( "/lumino/charts", modelo);
    }

    @GetMapping("/punto")
    public ModelAndView asd(HttpSession session, Model model){
        ModelMap modelo = new ModelMap();
        List<ImagenesUsuario> imgUsu = usuarioService.getImagenesUsuario();
        modelo.addAttribute("imagenes", imgUsu);
        modelo.addAttribute("usu", usuarioService.usuariosParaValidar());
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        modelo.addAttribute("usuario", usuarioService.validarUsuario(usuario.getEmail()));
        return new ModelAndView("/lumino/index", modelo);
    }
    @GetMapping("/validacion/{estado}/{id}")
    public ModelAndView asdrewrd(HttpSession session, @PathVariable String estado, @PathVariable Long id){
        if(estado.equals("aceptada"))
        {
            usuarioService.cambiarDeEstado(id);
        }
        else
        {
            usuarioService.rechazarcambioDeEstado(id);
        }
        return new ModelAndView("redirect:/admin/punto");
    }
}
