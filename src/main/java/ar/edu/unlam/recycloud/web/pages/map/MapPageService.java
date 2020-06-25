package ar.edu.unlam.recycloud.web.pages.map;

import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
class MapPageService {

    private final CategoriaService categoriaService;

    MapPageService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    ModelAndView build() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("categorias", categoriaService.findAll());
        return new ModelAndView("map/map", modelMap);
    }

}
