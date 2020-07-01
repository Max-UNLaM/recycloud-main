package ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit;

import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class PuntoReciclajeCreateVMService {

    private final CategoriaService categoriaService;

    public PuntoReciclajeCreateVMService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public PuntoReciclajeEditViewModel buildCreate() {
        PuntoReciclajeEditViewModel model = new PuntoReciclajeEditViewModel();
        model.setCategories(categoriaService.getCategoriaNames());
        model.setTitle("Crear Punto de Entrega");
        model.setAction("create");
        model.setType("create");
        return model;
    }

    public PuntoReciclajeEditViewModel buildEdit(Long id) {
        PuntoReciclajeEditViewModel model = new PuntoReciclajeEditViewModel();
        model.setCategories(categoriaService.getCategoriaNames());
        model.setTitle("Editar Punto de Entrega");
        model.setAction("edit/" + id);
        model.setType("edit");
        return model;

    }
}
