package ar.edu.unlam.recycloud.web.pages.login;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class loginModel {
    private String usuario;
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
