package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenadaService;
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
    private final CategoriaService categoriaService;
    @Autowired
    private final CategoriaEntrenadaService categoriaEntrenadaService;

    public ScannerController(CategoriaService categoriaService, CategoriaEntrenadaService categoriaEntrenadaService) {
        this.categoriaService = categoriaService;
        this.categoriaEntrenadaService = categoriaEntrenadaService;
    }

    @RequestMapping(path = "/scanner/scanner")
    public ModelAndView read() {
        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriaEntrenadaService.findAll());
        return new ModelAndView("scanner/scanner", mod);
    }
    @RequestMapping(path = "/scanner/scannerdos")
    public ModelAndView rasdead() {
        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriaEntrenadaService.findAll());
        return new ModelAndView("scanner/scannerDos", mod);
    }

    @GetMapping (path = "/scanner/masinfo/{categoria}")
    public ModelAndView llevarAPantalla(@PathVariable Long categoria) {
        ModelMap model = new ModelMap();
        model.put("informacion", categoriaService.getCategoriaById(categoria));
        model.put("allcategoria",this.categoriaService.findAll());
        return new ModelAndView ("/categoria/descripcion",model);
    }
}
