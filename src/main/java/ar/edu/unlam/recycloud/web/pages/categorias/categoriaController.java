package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.web.pages.Scanner.ScannerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class categoriaController {

    @Autowired
    private final categoriaService categoriaService;

    public categoriaController(categoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(path = "/categoria/categoria")
    public ModelAndView read() {
        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriaService.getListaDeCategoria());
        return new ModelAndView("categoria/categoria",mod);
    }

    @RequestMapping(path = "/categoria/guardar")
    public String read(@ModelAttribute ScannerModel categoria) {
        categoriaService.setListaDeCategoria(categoria);
        return"redirect:/categoria/categoria";
    }
}
