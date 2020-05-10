package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.web.pages.Scanner.ScannerModel;
import ar.edu.unlam.recycloud.web.pages.login.loginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class categoriaController {

    @Autowired
    private final categoriaService categoriaService;

    public categoriaController(categoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(path = "/categoria/categoria")
    public ModelAndView read(HttpSession session) {
        loginModel l= (loginModel) session.getAttribute("usuario");
        if(l == null){
            return new ModelAndView("/index");
        }
        if(l.getRol() != 1){
            return new ModelAndView("/index");
        }

        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriaService.getListaDeCategoria());
        return new ModelAndView("categoria/categoria",mod);
    }

    @RequestMapping(path = "/categoria/guardar")
    public String read(@ModelAttribute ScannerModel categoria, HttpSession session) {
        loginModel l= (loginModel) session.getAttribute("usuario");
        if(l == null){
            return ("/index");
        }
        if(l.getRol() != 1){
            return ("/index");
        }
        categoriaService.setListaDeCategoria(categoria);
        return"redirect:/categoria/categoria";
    }
}
