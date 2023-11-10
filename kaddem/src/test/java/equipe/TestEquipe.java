package  equipe;
import org.aspectj.lang.annotation.Before;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;


import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringBootConfiguration
public class TestEquipe {
    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @Before("")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestretrieveAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        // Add some equipes objects to the list

        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> result = equipeService.retrieveAllEquipes();

        assertEquals(equipes, result);
    }

    @Test
    public void TestaddEquipe() {
        Equipe equipe = new Equipe();

        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);

        Equipe result = equipeService.addEquipe(equipe);

        assertEquals(equipe, result);
    }

  //  @Test
    //public void testdeleteEquipe() {
      //  Integer id = 1;
        //doNothing().when(equipeRepository).deleteById(id);

        //equipeService.deleteEquipe(id);

      //  verify(equipeRepository, times(1)).deleteById(id);
    //}

    @Test
    public void testupdateEquipe() {
        Equipe equipe = new Equipe();

        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);

        Equipe result = equipeService.updateEquipe(equipe);

        assertEquals(equipe, result);
    }

    @Test
    public void testretrieveEquipe() {
        Integer id = 1;
        Equipe equipe = new Equipe();

        when(equipeRepository.findById(id)).thenReturn(Optional.of(equipe));

        Equipe result = equipeService.retrieveEquipe(id);

        assertEquals(equipe, result);
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