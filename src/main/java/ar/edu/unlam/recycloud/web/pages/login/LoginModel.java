package ar.edu.unlam.recycloud.web.pages.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginModel {

    @NotNull(message = "Debe ingresar un nombre de usuario")
    @NotEmpty(message = "Debe ingresar un nombre de usuario")
    private String usuario;

    @NotNull(message = "Debe ingresar una clave")
    @NotEmpty(message = "Debe ingresar una clave")
    private String pass;
    private Integer rol;

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
