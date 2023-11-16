package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)

public class DepartementImpTestUni {
    @Mock
    DepartementRepository departementRepository;

    @InjectMocks
    DepartementServiceImpl departmentService;

    @BeforeEach
    public void setup() {

    }
    @Test
    public void testretrieveAllDepartements() {
        // création de deux départements pour test de l'affichage
        Departement department1 = new Departement (1,"informatique");
        Departement department2 = new Departement(2,"éléctromécanique");
        when(departementRepository.findAll()).thenReturn(Arrays.asList(department1, department2));
        List<Departement> orderList = departmentService.retrieveAllDepartements();
        assertEquals(orderList.size(), 2);
        assertEquals(orderList.get(0).getNomDepart(), "informatique");
        assertEquals(orderList.get(1).getNomDepart(), "éléctromécanique");
        assertEquals(orderList.get(0).getNomDepart() ,1);
        assertEquals(orderList.get(1).getNomDepart() ,2);
    }
    @Test
    public void testretrieveDepartement() {
        Departement departement = new Departement (5,"scolarité");
        when(departementRepository.findById(5)).thenReturn(Optional.of(departement));
        Departement dep = departmentService.retrieveDepartement(5);
        assertNotEquals(dep, null);
        assertEquals(dep.getNomDepart(), "scolarité");


    }
    @Test
    public void updateDepartement() {
        Departement dep = new Departement();
        when(departementRepository.save(dep)).thenReturn(dep);
        Departement rslt = departmentService.updateDepartement(dep);
        assert rslt.equals(dep);
    }

}
