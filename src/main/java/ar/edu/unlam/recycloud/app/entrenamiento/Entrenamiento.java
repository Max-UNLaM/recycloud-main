package ar.edu.unlam.recycloud.app.entrenamiento;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String entreno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getEntreno() {
        return entreno;
    }

    public void setEntreno(String entreno) {
        this.entreno = entreno;
    }
}
