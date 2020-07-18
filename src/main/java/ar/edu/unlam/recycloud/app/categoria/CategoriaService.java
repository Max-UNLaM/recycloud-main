package ar.edu.unlam.recycloud.app.categoria;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria saveCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.getById(id);
    }

    public List<String> getCategoriaNames() {
        List<String> categoriaNames = new ArrayList<>();
        findAll().forEach(categoria -> categoriaNames.add(categoria.getNombre().toLowerCase()));
        return categoriaNames;
    }

    public long getTotalCategorias() {
        return this.categoriaRepository.count();
    }
}
