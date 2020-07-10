package ar.edu.unlam.recycloud.app.usuario;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class Login {
    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String email;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
