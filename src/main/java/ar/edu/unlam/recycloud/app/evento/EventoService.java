package ar.edu.unlam.recycloud.app.evento;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }
    public void save(Evento evento){
        eventoRepository.save(evento);
    }

}
