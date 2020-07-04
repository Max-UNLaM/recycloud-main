package ar.edu.unlam.recycloud.app.usuario;

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


    public UsuarioService(UsuarioRepository usuarioRepository, ImagenesUsuarioRepository imagenesUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.imagenesUsuarioRepository = imagenesUsuarioRepository;
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
    public void modificarDatos(Long id, Integer dni, Integer dia, String mes, Integer anio){
        usuarioRepository.modificarUsuario(id, dni, dia, mes, anio);
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
    public List<ImagenesUsuario> getImagenesUsuario (Usuario usuario){
        return imagenesUsuarioRepository.buscarPorIdDeUsuario(usuario.getId());
    }

}
