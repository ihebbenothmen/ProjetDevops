package  University;
import org.aspectj.lang.annotation.Before;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.*;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;


import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringBootConfiguration
public class TestUniversity {
    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;

    @Before("")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestretrieveAllUniversites() {
        List<Universite> equipes = new ArrayList<>();
        // Add some equipes objects to the list

        when(universiteRepository.findAll()).thenReturn(equipes);

        List<Universite> result = universiteService.retrieveAllUniversites();

        assertEquals(equipes, result);
    }

    @Test
    public void TestaddEquipe() {
        Universite universite = new Universite();

        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        Universite result = universiteService.addUniversite(universite);

        assertEquals(universite, result);
    }

    //  @Test
    //public void testdeleteEquipe() {
    //  Integer id = 1;
    //doNothing().when(equipeRepository).deleteById(id);

    //equipeService.deleteEquipe(id);

    //  verify(equipeRepository, times(1)).deleteById(id);
    //}

    @Test
    public void testupdateUniversite() {
        Universite universite = new Universite();

        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        Universite result = universiteService.updateUniversite(universite);

        assertEquals(universite, result);
    }

    @Test
    public void testretrieveUniversite() {
        Integer id = 1;
        Universite universite = new Universite();

        when(universiteRepository.findById(id)).thenReturn(Optional.of(universite));

        Universite result = universiteService.retrieveUniversite(id);

        assertEquals(universite, result);
    }
    //  @Test
    //public void testEvoluerEquipes() {
    //  Equipe equipe = new Equipe();
    //equipe.setNiveau(Niveau.JUNIOR);
    //Etudiant etudiant1 = new Etudiant();
    //Contrat contrat1 = new Contrat();
    //contrat1.setArchive(false);
    //contrat1.setDateFinContrat(new Date());
    //  etudiant1.getContrats().add(contrat1);
    //  equipe.getEtudiants().add(etudiant1);
    //  when(equipeRepository.findAll()).thenReturn(Arrays.asList(equipe));
    //  EquipeServiceImpl equipeService = new EquipeServiceImpl(equipeRepository);
    // equipeService.evoluerEquipes();
    // assertEquals(Niveau.SENIOR, equipe.getNiveau());

    // }

}