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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
