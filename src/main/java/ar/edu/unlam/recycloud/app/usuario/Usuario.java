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
    private String email;

    @Size(min = 8, max = 50, message
            = "Debe ser entre 8 y 50 caracteres")
    @NotEmpty(message="Campo requerido")
    private String password;

    private Integer rol;

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    private String nacimiento;

    private Integer dni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
}
