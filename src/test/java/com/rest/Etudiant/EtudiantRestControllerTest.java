package com.rest.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.controllers.EtudiantRestController;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.services.IEtudiantService;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtudiantRestControllerTest {

    @Mock
    private IEtudiantService etudiantService;

    @InjectMocks
    private EtudiantRestController etudiantController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEtudiants() {
        // Mocking the service method
        List<Etudiant> mockEtudiants = new ArrayList<>();
        when(etudiantService.retrieveAllEtudiants()).thenReturn(mockEtudiants);

        List<Etudiant> result = etudiantController.getEtudiants();

        assertEquals(mockEtudiants, result);
    }

    @Test
    public void testRetrieveEtudiant() {
        // Mocking the service method
        Integer etudiantId = 1;
        Etudiant mockEtudiant = new Etudiant();
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

    @Test
    public void testRemoveEtudiant() {
        Integer etudiantId = 1;
        etudiantController.removeEtudiant(etudiantId);

        verify(etudiantService, times(1)).removeEtudiant(etudiantId);
    }

    @Test
    public void testUpdateEtudiant() {
        Etudiant etudiant = new Etudiant();
        when(etudiantService.updateEtudiant(any(Etudiant.class))).thenReturn(etudiant);

        Etudiant result = etudiantController.updateEtudiant(new Etudiant());

        assertEquals(etudiant, result);
    }


}
