package ar.edu.unlam.recycloud.app.categoriaEntrenada;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class CategoriaEntrenada {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String imagen;
    @OneToOne
    private Categoria categoria;
}
