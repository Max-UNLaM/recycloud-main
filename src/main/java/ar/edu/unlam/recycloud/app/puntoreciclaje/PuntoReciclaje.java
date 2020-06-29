package ar.edu.unlam.recycloud.app.puntoreciclaje;

import lombok.Data;

import javax.persistence.*;

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
}
