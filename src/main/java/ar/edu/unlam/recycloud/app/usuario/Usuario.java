package ar.edu.unlam.recycloud.app.usuario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 20, message
            = "Debe ser entre 2 y 20 caracteres")
    private String nombre;

    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 20, message
            = "Debe ser entre 2 y 20 caracteres")
    private String apellido;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String mail;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String password;

    private Integer rol;
}
