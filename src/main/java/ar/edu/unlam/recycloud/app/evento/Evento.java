package ar.edu.unlam.recycloud.app.evento;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 50, message
            = "Debe ser entre 2 y 50 caracteres")
    private String titulo;

    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 20, message
            = "Debe ser entre 2 y 20 caracteres")
    private String nombreEmpresa;

    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 100, message
            = "Debe ser entre 2 y 100 caracteres")
    private String direccion;

    @NotEmpty(message="Campo requerido")
    @Size(min = 2, max = 100, message
            = "Debe ser entre 2 y 100 caracteres")
    private String localidad;

    private Date fechaInicio;

    private Date fechaFin;

    private Long idUsuario;

}
