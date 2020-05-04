package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class EntrenamientoModel {

    private Object clasificador;
}
