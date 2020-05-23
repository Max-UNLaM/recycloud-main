package ar.edu.unlam.recycloud.web.pages.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public LoginModel confirmarUsuario(String pass, String usuario){
        LoginModel l = new LoginModel();
        l.setPass(pass);
        l.setUsuario(usuario);
        return l;
    }
}
