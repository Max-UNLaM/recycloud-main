package ar.edu.unlam.recycloud.web.pages.admin;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacion;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdmCategoriaInfoController {

    private final CategoriaInformacionService categoriaInformacionService;
    private final CategoriaService categoriaService;

    AdmCategoriaInfoController(
            CategoriaInformacionService categoriaInformacionService,
            CategoriaService categoriaService
    ) {
        this.categoriaInformacionService = categoriaInformacionService;
        this.categoriaService = categoriaService;
    }

    // Categoría Información

    @PostMapping(path = "/categoria/informacion")
    public String createInformacion(CategoriaInformacion categoria) {
        categoria = categoriaInformacionService.save(categoria);
        return "redirect:/admin/categoria/" + categoria.getCategoria().getId() + "/informacion";
    }

    @GetMapping(path = "/categoria/informacion/create")
    public ModelAndView create() {
        ModelMap mod = new ModelMap();
        mod.put("categorias", this.categoriaService.findAll());
        return new ModelAndView("admin/categoria/informacion/create", mod);
    }

    @GetMapping(path = "/categoria/{categoriaId}/informacion/update")
    public ModelAndView update(@PathVariable Long categoriaId) {
        ModelMap mod = new ModelMap();
        Categoria categoria = this.categoriaService.getCategoriaById(categoriaId);
        CategoriaInformacion categoriaInformacion = this.categoriaInformacionService.getBy(categoria);
        mod.put("informacion", categoriaInformacion);
        return new ModelAndView("admin/categoria/informacion/update", mod);
    }

}
