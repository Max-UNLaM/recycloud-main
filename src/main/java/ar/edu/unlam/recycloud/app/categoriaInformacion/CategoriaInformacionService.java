package ar.edu.unlam.recycloud.app.categoriaInformacion;

import org.springframework.stereotype.Service;

@Service
public class CategoriaInformacionService {
    private final CategoriaInformacionRepository categoriaInformacionRepository;

    CategoriaInformacionService(CategoriaInformacionRepository categoriaInformacionRepository) {
        this.categoriaInformacionRepository = categoriaInformacionRepository;
    }

    public void findAll(){
        categoriaInformacionRepository.findAll();
    }
}
