package ar.edu.unlam.recycloud.app.categoria;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nombre;
    private String icon;
    private String shortDesc;
    private String color;
    private String backgroundColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
