package ar.edu.unlam.recycloud.app.categoriaInformacion;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaInformacionService {
    private final CategoriaInformacionRepository categoriaInformacionRepository;

    CategoriaInformacionService(CategoriaInformacionRepository categoriaInformacionRepository) {
        this.categoriaInformacionRepository = categoriaInformacionRepository;
    }

    public List<CategoriaInformacion> findAll() {
        return categoriaInformacionRepository.findAll();
    }

    public CategoriaInformacion getBy(Long id) {
        return categoriaInformacionRepository.getById(id);
    }

    public CategoriaInformacion getBy(Categoria categoria) {
        return categoriaInformacionRepository.getByCategoria(categoria);
    }

    public CategoriaInformacion save(CategoriaInformacion categoriaInformacion) {
        return categoriaInformacionRepository.save(categoriaInformacion);
    }
    public List<CategoriaInformacion> trerTodaLaInfoPorCategoria(Long id) {
        return categoriaInformacionRepository.trerTodaLaInfoPorCategoria(id);
    }

}
