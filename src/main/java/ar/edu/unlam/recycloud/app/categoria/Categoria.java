package ar.edu.unlam.recycloud.app.categoria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String tipos;
    private String como;
    private String donde;
}
