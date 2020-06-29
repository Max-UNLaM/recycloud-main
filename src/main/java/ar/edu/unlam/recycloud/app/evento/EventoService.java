package ar.edu.unlam.recycloud.app.evento;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.app.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        return eventoRepository.findAllByOrderByFechaAsc(this.hoy());
    }

    public List<Evento> eventosPorId(Usuario user){
        return eventoRepository.eventosporId(usuarioService.validarUsuario(user.getEmail()).getId());
    }

    public void save(Evento evento, Usuario user){
        evento.setUsuario(usuarioService.validarUsuario(user.getEmail()));
        eventoRepository.save(evento);
    }

    public String hoy(){
        Format formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date today = Calendar.getInstance().getTime();
        String d = formatter.format(today);
        return d;
    }
    public String sumaAlDiaActual(Integer diasASumar){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, diasASumar);
        String s = sdf.format(c.getTime());
        return s;
    }

    public List<Evento> filtroPorTiempo(String tiempo) {

        switch (tiempo.toLowerCase()) {
            case "hoy":
                return eventoRepository.filtroPorTiempoHoy(this.hoy());
            case "semana":
                return eventoRepository.filtroPorTiempoSemana(this.hoy(),this.sumaAlDiaActual(7));
            case "mes":
                return eventoRepository.filtroPorTiempoSemana(this.hoy(),this.sumaAlDiaActual(30));
            default:
                return eventoRepository.findAllByOrderByFechaAsc(this.hoy());
        }
    }
}
