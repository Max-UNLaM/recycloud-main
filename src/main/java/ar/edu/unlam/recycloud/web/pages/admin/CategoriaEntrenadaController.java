package ar.edu.unlam.recycloud.web.pages.admin;

import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenada;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenadaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoriaEntrenadaController {

    private final CategoriaEntrenadaService categoriaEntrenadaService;

    CategoriaEntrenadaController(
            CategoriaEntrenadaService categoriaEntrenadaService
    ) {
        this.categoriaEntrenadaService = categoriaEntrenadaService;
    }

    // Categoría Entrenada

    @PostMapping(path = "/categoria/entrenada")
    public String createEntrenada(CategoriaEntrenada categoria) {
        CategoriaEntrenada categoriaEntrenada = categoriaEntrenadaService.save(categoria);
        return "redirect:/admin/categoria/" + categoriaEntrenada.getCategoria().getId();
    }

}
