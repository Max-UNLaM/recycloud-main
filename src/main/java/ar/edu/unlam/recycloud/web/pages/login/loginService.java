package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Service;

@Service
public class loginService {
    public loginModel confirmarUsuario(String pass, String usuario){
        loginModel l = new loginModel();
        l.setPass(pass);
        l.setUsuario(usuario);
        return l;
    }
}
