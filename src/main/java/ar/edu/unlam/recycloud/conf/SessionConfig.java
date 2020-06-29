package ar.edu.unlam.recycloud.conf;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

@Configuration
public class SessionConfig {

    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Usuario usuario(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setRol(0);
        }
        return usuario;
    }

}
