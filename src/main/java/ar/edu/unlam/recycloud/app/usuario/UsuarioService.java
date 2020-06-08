package ar.edu.unlam.recycloud.app.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

    public void completarDatos(Long id, Integer dni, String nacimiento){
        usuarioRepository.completarUsuario(id, dni, nacimiento);
    }
}
