package tn.esprit.spring.kaddem.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContratServiceImplTest {
@Mock
    ContratRepository contratRepository;

@InjectMocks
ContratServiceImpl contratService;

Contrat contrat = new Contrat(1, new Date(),new Date(), Specialite.IA);


    @Test
    public void retrieveAllContrats() {
    }

    @Test
    public void updateContrat() {
    }

    @Test
    public void addContrat() {
    }

    @Test
    public void retrieveContrat() {

        when(contratRepository.findById(Mockito.any())).thenReturn(Optional.of(contrat))
        ;
        Contrat user1 = contratService.retrieveContrat(1);
        Assertions.assertNotNull(user1);
    }


    /*@Test
    public void removeContrat() {
        Integer idContrat = 1; // Replace with a valid ID
        Contrat contrat = new Contrat(); // Create a mock Contrat object

        // Mock the behavior of retrieveContrat
        Mockito.when(contratRepository.findByIdContrat(idContrat)).thenReturn(contrat);

        // Act
        contratService.removeContrat(idContrat);

        // Assert
        // Verify that the delete method was called with the mock Contrat object
        Mockito.verify(contratRepository).delete(contrat);
    }*/
/////
    @Test
    public void affectContratToEtudiant() {
    }

    @Test
    public void nbContratsValides() {
    }

    @Test
    public void retrieveAndUpdateStatusContrat() {
    }

    @Test
    public void getChiffreAffaireEntreDeuxDates() {
    }
}