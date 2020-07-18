package ar.edu.unlam.recycloud.app.usuario;

import ar.edu.unlam.recycloud.app.admin.Estadisticas;
import ar.edu.unlam.recycloud.app.categoria.CategoriaRepository;
import ar.edu.unlam.recycloud.app.puntoreciclaje.EstadisticasPuntoReciclaje;
import ar.edu.unlam.recycloud.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ImagenesUsuarioRepository imagenesUsuarioRepository;
    private final CategoriaRepository categoriaRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, ImagenesUsuarioRepository imagenesUsuarioRepository, CategoriaRepository categoriaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.imagenesUsuarioRepository = imagenesUsuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Usuario confirmarUsuario(String email, String password){
        Usuario l =usuarioRepository.buscarUsuario(email, password);
        return l;
    }

    public void registro(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario validarUsuario(String email){
        Usuario l = usuarioRepository.validarUsuario(email);
        return l;
    }

    public void actualizarPass(String pass, Usuario usuario){
        Usuario l = usuarioRepository.buscarUsuario(usuario.getEmail(),usuario.getPassword());
        usuarioRepository.cambiarPassword(pass, l.getId());
    }
    public void modificarDatos(Long id, String dni, Integer dia, String mes, Integer anio, String telefono, String cod){
        telefono= '('+cod+')'+' '+telefono.replaceFirst("(\\d{4})(\\d+)", "$1-$2");
        usuarioRepository.modificarUsuario(id, dni, dia, mes, anio, telefono);
    }

    public void saveFile (MultipartFile file, Usuario usuario) throws Exception{
        String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/imagenesParaEvaluar/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadDirectory + file.getOriginalFilename());
        Files.write(path,bytes);

        ImagenesUsuario imgUsu = new ImagenesUsuario();
        imgUsu.setNombre(file.getOriginalFilename());
        imgUsu.setEstado(1);
        imgUsu.setUsuario(usuarioRepository.validarUsuario(usuario.getEmail()));
        imagenesUsuarioRepository.save(imgUsu);
    }

    public void saveFileInUser (MultipartFile file, Usuario usuario) throws Exception{
        String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/imagenesDePerfil/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadDirectory + file.getOriginalFilename());
        Files.write(path,bytes);

        usuario.setNombreImagen(file.getOriginalFilename());

        usuarioRepository.save(usuario);
    }
    public List<ImagenesUsuario> getImagenesUsuario (){
        return imagenesUsuarioRepository.buscarPorIdDeUsuario();
    }
    public List<ImagenesUsuario> usuariosParaValidar(){

        return imagenesUsuarioRepository.usuariosParaValidar();
    }
    public void cambiarDeEstado(Long id){

        usuarioRepository.cambiarDeEstado(id);
        imagenesUsuarioRepository.cambiarEstadoImagenAceptado(id);
    }
    public void rechazarcambioDeEstado(Long id){

        imagenesUsuarioRepository.cambiarEstadoImagen(id);
    }
    public ImagenesUsuario traerEstadosDeImagenes(Usuario usuario) {

        return imagenesUsuarioRepository.traerEstadosDeImagenes(usuario.getId());
    }
    public String hoy(){
        Format formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date today = Calendar.getInstance().getTime();
        String d = formatter.format(today);
        return d;
    }
    public EstadisticasPuntoReciclaje estadisticasDelPuntoDeReciclaje(Usuario usuario) {
        EstadisticasPuntoReciclaje lista = new EstadisticasPuntoReciclaje();
        lista.setEventosTotales(usuarioRepository.eventosTotales(usuario.getId()));
        lista.setEventosActivos(usuarioRepository.eventosActivos(hoy(),usuario.getId()));
        lista.setEventosInactivos(usuarioRepository.eventosInactivos(hoy(),usuario.getId()));
        lista.setPinesTotales(usuarioRepository.pinesTotales(usuario.getId()));
        return lista;
    }

    public Estadisticas getAllEstadistics() {
        Estadisticas lista = new Estadisticas();

        lista.setUsuariosTotales(usuarioRepository.totalDeUsuarios());
        lista.setUsuariosTotalesRol1(usuarioRepository.totalDeUsuariosRol1());
        lista.setUsuariosTotalesRol2(usuarioRepository.totalDeUsuariosRol2());
        lista.setUsuariosTotalesRol3(usuarioRepository.totalDeUsuariosRol3());
        lista.setCategoriasTotales(categoriaRepository.totalDeCategorias());
        lista.setActivo(categoriaRepository.activo(hoy()));
        lista.setInactivo(categoriaRepository.inactivo(hoy()));
        lista.setTotal(categoriaRepository.total());
        return lista;
    }

    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = usuarioRepository.validarUsuario(email);
        if (usuario == null) {
            throw new NotFoundException("Mail " + email + " no encontrado");
        }
        return usuario;
    }

    public Usuario getUsuarioById(long id) {
        Optional<Usuario> opt = this.usuarioRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new NotFoundException("Usuario " + id + " no encontrado");
        }
    }

    public long getTotalAccounts() {
        return usuarioRepository.count();
    }

}
