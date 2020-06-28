package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {


    private final CategoriaInformacionService categoriaInformacionService;
    private final CategoriaService categoriaService;

    public CategoriaController(
            CategoriaInformacionService categoriaInformacionService,
            CategoriaService categoriaService
    ) {
        this.categoriaInformacionService = categoriaInformacionService;
        this.categoriaService = categoriaService;
    }

    @GetMapping(path = "/categoria")
    public ModelAndView listar() {
        ModelMap model = new ModelMap();
        model.put("categorias", this.categoriaService.findAll());
        return new ModelAndView("/categoria/lista", model);
    }

    @GetMapping(path = "/categoria/{categoriaId}")
    public ModelAndView leer(@PathVariable Long categoriaId) {
        ModelMap viewModel = new ModelMap();
        Categoria categoria = categoriaService.getCategoriaById(categoriaId);
        viewModel.put("informacion", categoriaInformacionService.trerTodaLaInfoPorCategoria(categoria.getId()));
        viewModel.put("allcategoria", categoriaService.findAll());
        viewModel.put("cateseleccionada", categoria);
        return new ModelAndView("/categoria/descripcion", viewModel);
    }
}
