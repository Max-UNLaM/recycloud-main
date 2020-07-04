package ar.edu.unlam.recycloud.app.puntoreciclaje;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(indexes = {
        @Index(name = "PUNTO_RECICLAJE_INDEX_0", columnList = "id"),
        @Index(name = "PUNTO_RECICLAJE_INDEX_1", columnList = "coordinates"),
        @Index(name = "PUNTO_RECICLAJE_INDEX_2", columnList = "usuarioId")
})
public class PuntoReciclaje {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "coordinates")
    private String coordinates;

    private Long usuarioId;

    public List<Double> getCoordinatesAsDouble() {
        List<Double> result = new ArrayList<>();
        Arrays.stream(coordinates.split(",")).forEach((dato) -> result.add(Double.valueOf(dato)));
        return result;
    }

    public List<String> getCoordinatesAsList() {
        return Arrays.asList(coordinates.split(","));
    }
}
