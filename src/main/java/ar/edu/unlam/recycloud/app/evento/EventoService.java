package ar.edu.unlam.recycloud.app.evento;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    private final UsuarioService usuarioService;

    public EventoService(EventoRepository eventoRepository, UsuarioService usuarioService) {
        this.eventoRepository = eventoRepository;
        this.usuarioService = usuarioService;
    }

    public List<Evento> findAllByOrderByFechaAsc() {
        return eventoRepository.findAllByOrderByFechaAsc();
    }

    public List<Evento> eventosPorId(Usuario user){
        return eventoRepository.eventosporId(usuarioService.validarUsuario(user.getEmail()).getId());
    }

    public void save(Evento evento, Usuario user){
        evento.setUsuario(usuarioService.validarUsuario(user.getEmail()));
        eventoRepository.save(evento);
    }

}
