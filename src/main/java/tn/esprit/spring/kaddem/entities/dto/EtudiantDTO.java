package tn.esprit.spring.kaddem.entities.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.kaddem.entities.Option;

@Getter
@Setter
public class EtudiantDTO {
    private String nomE;
    private Integer idEtudiant;
    private String prenomE;
    private Option op;

}
