package ar.edu.unlam.recycloud.web.pages.login;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class registrarModel {
    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 20, message
            = "Debe ser entre 2 y 20 caracteres")
    private String nombre;

    @Size(min = 2, max = 50, message
            = "Debe ser entre 2 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String apellido;

    @NotEmpty(message="Campo requerido")
    @Email(message="Email Invalido")
    private String email;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    private String clave;
}
