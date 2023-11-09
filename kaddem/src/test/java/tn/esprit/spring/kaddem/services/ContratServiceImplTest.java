package tn.esprit.spring.kaddem.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContratServiceImplTest {
    @Mock
    ContratRepository contratRepository;

    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    ContratServiceImpl contratService;

Contrat contrat = new Contrat(1, new Date(),new Date(), Specialite.IA);



    @Test
    public void retrieveAllContrats() {
        List<Contrat> contratList = new ArrayList<>();
        when(contratRepository.findAll()).thenReturn(contratList);

        // Act
        List<Contrat> result = contratService.retrieveAllContrats();

        // Assert
        assert result.size() == contratList.size();
    }



    @Test
    public void updateContrat() {
        Contrat contrat = new Contrat();
        when(contratRepository.save(contrat)).thenReturn(contrat);

        // Act
        Contrat result = contratService.updateContrat(contrat);

        // Assert
        assert result.equals(contrat);
    }

    @Test
    public void addContrat() {
        Contrat contrat = new Contrat();
        when(contratRepository.save(contrat)).thenReturn(contrat);

        // Act
        Contrat result = contratService.addContrat(contrat);

        // Assert
        assert result.equals(contrat);

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
    /*@Test
    public void affectContratToEtudiant() {
        Integer idContrat = 1;
        String nomE = "John";
        String prenomE = "Doe";
        Etudiant etudiant = new Etudiant(); // Create an Etudiant object
        when(etudiantRepository.findByNomEAndPrenomE(nomE, prenomE)).thenReturn(etudiant);
        Contrat contrat = new Contrat(); // Create a Contrat object
        when(contratRepository.findByIdContrat(idContrat)).thenReturn(contrat);

        // Act
        Contrat result = contratService.affectContratToEtudiant(idContrat, nomE, prenomE);

        // Assert
        assert result.equals(contrat);
    }*/

    @Test
    public void nbContratsValides() {
        Date startDate = new Date(); // Provide a valid start date
        Date endDate = new Date(); // Provide a valid end date
        when(contratRepository.getnbContratsValides(startDate, endDate)).thenReturn(5);

        // Act
        Integer result = contratService.nbContratsValides(startDate, endDate);

        // Assert
        assert result == 5;
    }

    /*@Test
    public void retrieveAndUpdateStatusContrat() {
    }*/

   @Test
    public void getChiffreAffaireEntreDeuxDates() {
        Date startDate = new Date(); // Provide a valid start date
        Date endDate = new Date(); // Provide a valid end date
        List<Contrat> contratList = new ArrayList<>();
        // Add sample Contrat objects with different Specialite values to the contratList
        when(contratRepository.findAll()).thenReturn(contratList);

        // Act
        float result = contratService.getChiffreAffaireEntreDeuxDates(startDate, endDate);
    }
}