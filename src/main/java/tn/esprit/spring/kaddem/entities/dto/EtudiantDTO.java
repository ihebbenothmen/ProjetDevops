package tn.esprit.spring.kaddem.entities.dto;

public class EtudiantDTO {
    private String name;
    private Integer id;
    private String prenom;
    private String option;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getOption() {
        return option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
