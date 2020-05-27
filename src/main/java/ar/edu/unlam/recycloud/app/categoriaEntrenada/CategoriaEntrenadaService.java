package ar.edu.unlam.recycloud.app.categoriaEntrenada;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEntrenadaService {
    private final CategoriaEntrenadaRepository categoriaEntrenadaRepository;

    CategoriaEntrenadaService(CategoriaEntrenadaRepository categoriaEntrenadaRepository) {
        this.categoriaEntrenadaRepository = categoriaEntrenadaRepository;
    }

    public CategoriaEntrenada save(CategoriaEntrenada categoriaEntrenada) {
        return categoriaEntrenadaRepository.save(categoriaEntrenada);
    }

    public List<CategoriaEntrenada> findAll() {
        return categoriaEntrenadaRepository.findAll();
    }
}
