package ar.edu.unlam.recycloud.app.recypoints;

import lombok.Data;

@Data
public class RecypointUpdateDTO {
    private long provider;
    private long beneficiary;
    private long amount;
}
