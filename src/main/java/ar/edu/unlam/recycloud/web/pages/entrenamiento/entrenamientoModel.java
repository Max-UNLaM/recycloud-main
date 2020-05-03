package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class entrenamientoModel {
    private String path;
    private List<String> nombres;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }
}
