package ar.edu.unlam.recycloud.app.entrenamiento;

import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {
    private final EntrenamientoRepository entrenamientoRepository;

    EntrenamientoService(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }

}
