package ar.edu.unlam.recycloud.web.pages.admin;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenadaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdmCategoriaController {

    private final CategoriaEntrenadaService categoriaEntrenadaService;
    private final CategoriaService categoriaService;

    AdmCategoriaController(
            CategoriaEntrenadaService categoriaEntrenadaService,
            CategoriaService categoriaService
    ) {
        this.categoriaEntrenadaService = categoriaEntrenadaService;
        this.categoriaService = categoriaService;
    }

    @RequestMapping(path = "/categoria")
    public ModelAndView listCategoria() {
        ModelMap mod = new ModelMap();
        mod.put("categoriasEntrenada", this.categoriaEntrenadaService.findAll());
        mod.put("categorias", this.categoriaService.findAll());
        return new ModelAndView("admin/categoria/list", mod);
    }

    @PostMapping(path = "/categoria")
    public String createCategoria(@ModelAttribute Categoria categoria, HttpSession session) {
        categoria = categoriaService.saveCategoria(categoria);
        return "redirect:/admin/categoria/" + categoria.getId();
    }

    @RequestMapping(path = "/categoria/{categoriaId}")
    public ModelAndView readCategoria(@PathVariable Long categoriaId) {
        ModelMap viewModel = new ModelMap();
        viewModel.put("categoria", this.categoriaService.getCategoriaById(categoriaId));
        return new ModelAndView("admin/categoria/read", viewModel);
    }

}
