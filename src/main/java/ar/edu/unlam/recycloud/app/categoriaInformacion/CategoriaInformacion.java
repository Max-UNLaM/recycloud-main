package ar.edu.unlam.recycloud.app.categoriaInformacion;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class CategoriaInformacion {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String tipos;

    @Column(columnDefinition = "TEXT")
    private String como;

    private String donde;

    @OneToOne
    private Categoria categoria;
}
