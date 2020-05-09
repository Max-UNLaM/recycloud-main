package ar.edu.unlam.recycloud.web.pages.Scanner;

import ar.edu.unlam.recycloud.web.pages.categorias.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScannerController {

    @Autowired
    private final categoriaService categoriaService;

    public ScannerController( categoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(path = "/scanner/scanner")
    public ModelAndView read() {
        ModelMap mod = new ModelMap();
        mod.put("categorias",this.categoriaService.getListaDeCategoria());
        return new ModelAndView("scanner/scanner", mod);
    }
}
