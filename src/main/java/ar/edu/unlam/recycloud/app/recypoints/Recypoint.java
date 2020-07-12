package ar.edu.unlam.recycloud.app.recypoints;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Recypoint {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Usuario provider;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    private Usuario beneficiary;

    private Long amount;

}
