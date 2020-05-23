package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.web.pages.categorias.CategoriasPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScannerController {

    @Autowired
    private final CategoriasPageService categoriasPageService;

    public ScannerController(CategoriasPageService categoriasPageService) {
        this.categoriasPageService = categoriasPageService;
    }

    @RequestMapping(path = "/scanner/scanner")
    public ModelAndView read() {
        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriasPageService.getAllScannerModels());
        return new ModelAndView("scanner/scanner", mod);
    }
    @GetMapping(path = "/scanner/masinfo/{categoria}")
    public ModelAndView llevarAPantalla(@PathVariable String categoria) {
        ModelMap model = new ModelMap();
        model.put("allcategoria", categoriasPageService.getListaDeInformacion());
        model.put("categoria", categoriasPageService.getCategoriaByName(categoria));
        return new ModelAndView ("/categoria/descripcion",model);
    }
}
