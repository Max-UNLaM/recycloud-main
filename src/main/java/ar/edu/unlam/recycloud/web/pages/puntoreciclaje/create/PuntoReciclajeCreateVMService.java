package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.create;

import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class PuntoReciclajeCreateVMService {

    private final CategoriaService categoriaService;

    public PuntoReciclajeCreateVMService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public PuntoReciclajeCreateViewModel build() {
        PuntoReciclajeCreateViewModel model = new PuntoReciclajeCreateViewModel();
        model.setCategories(categoriaService.getCategoriaNames());
        return model;
    }

}
