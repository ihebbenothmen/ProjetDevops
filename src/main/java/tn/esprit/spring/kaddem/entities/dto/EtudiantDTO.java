package tn.esprit.spring.kaddem.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.kaddem.entities.Option;

@Getter
@Setter
public class EtudiantDTO {
    @JsonProperty("nomE")
    private String nomE;
    @JsonProperty("idEtudiant")
    private Integer idEtudiant;
    @JsonProperty("prenomE")
    private String prenomE;
    @JsonProperty("op")
    private Option op;

}
