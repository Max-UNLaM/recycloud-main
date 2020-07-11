package ar.edu.unlam.recycloud.web.pages.home;

import ar.edu.unlam.recycloud.app.usuario.Password;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    public ModelAndView perfil(HttpSession session,Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("password", new Password());
        modelo.addAttribute("estadisticaspunto", usuarioService.estadisticasDelPuntoDeReciclaje(usuario));
        session.setAttribute("estado", usuarioService.traerEstadosDeImagenes(usuarioService.validarUsuario(usuario.getEmail())));
        session.setAttribute("usuario", usuarioService.validarUsuario(usuario.getEmail()));
        modelo.addAttribute("estadisticas", usuarioService.getAllEstadistics());
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
        public String completar (HttpSession session, @RequestParam("files") MultipartFile[] files){
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        for (MultipartFile file :files){

            try {
                usuarioService.saveFile(file,usuario);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/home/perfil";

    }

    @PostMapping(path = "/home/modificar")
    public String modificar (HttpSession session, Usuario usuario){
        Usuario user = (Usuario) session.getAttribute("usuario");
        usuarioService.modificarDatos(user.getId(), usuario.getDni(),usuario.getDia(),usuario.getMes(), usuario.getAnio());
        session.setAttribute("usuario", usuarioService.validarUsuario(user.getEmail()));
        return "/home/perfil";
    }


}
