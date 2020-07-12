package ar.edu.unlam.recycloud.app.recypoints;

import lombok.Data;

@Data
public class RecypointCreateDTO {
    private String email;
    private long providerId;
    private long amount;
}
