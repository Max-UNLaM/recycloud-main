package ar.edu.unlam.recycloud.app.statistics.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuntoStatistic {
    private String address;
    private Long count;
}
