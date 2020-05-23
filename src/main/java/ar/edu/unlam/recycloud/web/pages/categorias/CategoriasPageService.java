package ar.edu.unlam.recycloud.web.pages.categorias;


import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.web.pages.scanner.ScannerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriasPageService {

    public static List<ScannerModel> listaDeCategorias = new ArrayList<>();
    private final CategoriaService categoriaService;


    CategoriasPageService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public List<ScannerModel> getAllScannerModels() {
        return listaDeCategorias;
    }

    public void setListaDeCategoria(ScannerModel scannerModel) {
        if (!scannerModel.getImagen().isEmpty() || !scannerModel.getCategoria().isEmpty()) {
            listaDeCategorias.add(scannerModel);
        }
    }

    public void setCategoria(Categoria categoria) {
        this.categoriaService.setCategoria(categoria);
    }

    public List<Categoria> getAllCategorias() {
        return this.categoriaService.getAllCategorias();
    }

    public Categoria getCategoriaByName(String nombre) {
        return this.categoriaService.getCategoriaByNombre(nombre);
    }

    public Categoria getCategoriaById(Long id) {
        return this.categoriaService.getCategoriaById(id);
    }

    public List<Categoria> getListaDeInformacion() {
        return this.categoriaService.getAllCategorias();
    }
}
