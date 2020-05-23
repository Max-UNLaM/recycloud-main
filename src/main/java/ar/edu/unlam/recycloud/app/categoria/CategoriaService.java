package ar.edu.unlam.recycloud.app.categoria;

import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public void setCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Categoria getCategoriaByNombre(String category) {
        List<Categoria> filteredCategoria = categoriaRepository.findByNombre(category);
        return filteredCategoria.get(0);
    }

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> information = categoriaRepository.findById(id);
        if (information.isPresent()) {
            return information.get();
        } else {
            throw new NotFoundException("Information", id);
        }
    }
}
