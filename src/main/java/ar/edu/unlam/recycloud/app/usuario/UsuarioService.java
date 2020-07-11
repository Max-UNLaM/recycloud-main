package ar.edu.unlam.recycloud.app.usuario;

import ar.edu.unlam.recycloud.app.admin.Estadisticas;
import ar.edu.unlam.recycloud.app.categoria.CategoriaRepository;
import ar.edu.unlam.recycloud.app.puntoreciclaje.EstadisticasPuntoReciclaje;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/imagenes/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadDirectory + file.getOriginalFilename());
        Files.write(path,bytes);

        ImagenesUsuario imgUsu = new ImagenesUsuario();
        imgUsu.setNombre(file.getOriginalFilename());
        imgUsu.setEstado(1);
        imgUsu.setUsuario(usuarioRepository.validarUsuario(usuario.getEmail()));
        imagenesUsuarioRepository.save(imgUsu);
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
    public EstadisticasPuntoReciclaje estadisticasDelPuntoDeReciclaje(Usuario usuario) {
        EstadisticasPuntoReciclaje lista = new EstadisticasPuntoReciclaje();
        lista.setEventosTotales(usuarioRepository. eventosTotales(usuario.getId()));
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
        return lista;
    }


}
