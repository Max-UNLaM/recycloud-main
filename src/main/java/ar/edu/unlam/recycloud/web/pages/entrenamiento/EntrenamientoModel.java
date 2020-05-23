package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import lombok.Data;


@Data
public class EntrenamientoModel {
    public Object getEntreno() {
        return entreno;
    }

    public void setEntreno(Object entreno) {
        this.entreno = entreno;
    }

    private Object entreno;
}
