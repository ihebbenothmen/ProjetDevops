package com.rest.Etudiant;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.controllers.EtudiantRestController;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.entities.dto.EtudiantDTO;
import tn.esprit.spring.kaddem.services.IEtudiantService;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


 class EtudiantRestControllerTest {

    @Mock
    private IEtudiantService etudiantService;

    @InjectMocks
    private EtudiantRestController etudiantController;

    public EtudiantRestControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testRetrieveAllEtudiants() {
        // Mocking the service method
        List<Etudiant> mockEtudiants = new ArrayList<>();
        when(etudiantService.retrieveAllEtudiants()).thenReturn(mockEtudiants);

        List<Etudiant> result = etudiantController.getEtudiants();

        assertEquals(mockEtudiants, result);
    }

    @Test
     void testRetrieveEtudiant() {
        // Mocking the service method
        Integer etudiantId = 1;
        Etudiant mockEtudiant = new Etudiant("John", "Doe", Option.SE);
        when(etudiantService.retrieveEtudiant(etudiantId)).thenReturn(mockEtudiant);

        Etudiant result = etudiantController.retrieveEtudiant(etudiantId);

        assertEquals(mockEtudiant, result);
    }

    @Test
    public void testAddEtudiant() {
       // Mocking the service method
       Etudiant mockEtudiant = new Etudiant();
       when(etudiantService.addEtudiant(any(Etudiant.class))).thenReturn(mockEtudiant);

       Etudiant result = etudiantController.addEtudiant(new Etudiant());

       assertEquals(mockEtudiant, result);
    }
}

