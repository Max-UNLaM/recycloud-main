package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.web.pages.login.LoginModel;
import ar.edu.unlam.recycloud.web.pages.scanner.ScannerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CategoriasController {

    @Autowired
    private final CategoriasPageService categoriasPageService;

    public CategoriasController(CategoriasPageService categoriasPageService) {
        this.categoriasPageService = categoriasPageService;
    }

    @GetMapping(path = "/categoria/{categoria}")
    public ModelAndView llevarAPantallaTodo(@PathVariable Long categoria) {
        ModelMap viewModel = new ModelMap();
        viewModel.put("categoria", categoriasPageService.getCategoriaById(categoria));
        viewModel.put("nombresCategorias", categoriasPageService.getAllCategorias());
        return new ModelAndView("/categoria/descripcion", viewModel);
    }

    @RequestMapping(path = "/categoria/guardarinformacion")
    public String infodos(@ModelAttribute Categoria categoria, HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return ("/index");
        }
        if (l.getRol() != 1) {
            return ("/index");
        }
        categoriasPageService.setCategoria(categoria);
        return "redirect:/categoria/informacion";
    }

    @RequestMapping(path = "/categoria/categoria")
    public ModelAndView read(HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return new ModelAndView("/index");
        }
        if (l.getRol() != 1) {
            return new ModelAndView("/index");
        }

        ModelMap mod = new ModelMap();
        mod.put("categorias", this.categoriasPageService.getAllScannerModels());
        return new ModelAndView("categoria/categoria", mod);
    }

    @RequestMapping(path = "/categoria/guardar")
    public String read(@ModelAttribute ScannerModel categoria, HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return ("/index");
        }
        if (l.getRol() != 1) {
            return ("/index");
        }
        categoriasPageService.setListaDeCategoria(categoria);
        return "redirect:/categoria/categoria";
    }

    @GetMapping(path = "/categoria/redirect/{categoria}")
    public ModelAndView llevarAPantalla(@PathVariable String categoria) {
        ModelMap model = new ModelMap();
        model.put("allcategoria", categoriasPageService.getAllCategorias());
        model.put("categoria", categoriasPageService.getCategoriaByName(categoria));

        return new ModelAndView("/categoria/descripcion", model);
    }
}