package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class EntrenamientoModel {
    public Object getEntreno() {
        return entreno;
    }

    public void setEntreno(Object entreno) {
        this.entreno = entreno;
    }

    private Object entreno;
}
