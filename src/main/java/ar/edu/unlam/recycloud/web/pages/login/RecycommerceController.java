package ar.edu.unlam.recycloud.web.pages.login;


import ar.edu.unlam.recycloud.app.recycommerce.CustomerService;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static ar.edu.unlam.recycloud.conf.ConfigConstants.RECYCOMMERCE_HOST_KEY;

@Controller
@RequestMapping("/recycommerce")
public class RecycommerceController {

    private static final String LOGIN_PATH = "/index.php?route=account/login";
    private final String RECYCOMMERCE_HOST;
    private final CustomerService customerService;

    public RecycommerceController(Environment environment, CustomerService customerService) {
        this.RECYCOMMERCE_HOST = environment.getProperty(RECYCOMMERCE_HOST_KEY);
        this.customerService = customerService;
    }

    @GetMapping(path = "/login")
    public String goToRecycommerce(RedirectAttributes redirectAttributes, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        redirectAttributes.addAttribute("email", usuario.getEmail());
        redirectAttributes.addAttribute("password", usuario.getPassword());
        return "redirect:" + RECYCOMMERCE_HOST + LOGIN_PATH;
    }


}
