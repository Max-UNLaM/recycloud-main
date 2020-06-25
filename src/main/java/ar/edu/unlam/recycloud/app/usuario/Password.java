package ar.edu.unlam.recycloud.app.usuario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class Password {
    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String oldPassword;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String newPassword;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String reNewPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
