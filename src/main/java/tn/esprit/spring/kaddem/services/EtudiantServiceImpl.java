package tn.esprit.spring.kaddem.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class EtudiantServiceImpl implements IEtudiantService{

	private final EtudiantRepository etudiantRepository;
	private final ContratRepository contratRepository;
	private final EquipeRepository equipeRepository;
	private final DepartementRepository departementRepository;

	public EtudiantServiceImpl(EtudiantRepository etudiantRepository, ContratRepository contratRepository,
							   EquipeRepository equipeRepository, DepartementRepository departementRepository) {
		this.etudiantRepository = etudiantRepository;
		this.contratRepository = contratRepository;
		this.equipeRepository = equipeRepository;
		this.departementRepository = departementRepository;
	}


	public List<Etudiant> retrieveAllEtudiants(){
	return (List<Etudiant>) etudiantRepository.findAll();
	}

	public Etudiant addEtudiant (Etudiant e){
		return etudiantRepository.save(e);
	}

	public Etudiant updateEtudiant (Etudiant e){
		return etudiantRepository.save(e);
	}

	private static final String ETUDIANT_NOT_FOUND_ERROR = "Etudiant not found";

	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(idEtudiant);
		if (etudiantOptional.isPresent()) {
			return etudiantOptional.get();
		} else {
			// handle the case when the Etudiant is not present
			// throw an exception using the constant
			throw new NoSuchElementException(ETUDIANT_NOT_FOUND_ERROR + " with id " + idEtudiant);
		}
	}




	public boolean removeEtudiant(Integer idEtudiant){
		Etudiant e = retrieveEtudiant(idEtudiant);
		if (e != null) {
			etudiantRepository.delete(e);
			return true; // Deletion successful
		} else {
			return false; // Deletion failed
		}
	}

	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
		Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
		Departement departement = departementRepository.findById(departementId).orElse(null);
		if (etudiant != null) {
			etudiant.setDepartement(departement);
			etudiantRepository.save(etudiant);
		} else {
			// handle the case when the Etudiant is null
		}
	}
	@Transactional
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
		Contrat c = contratRepository.findById(idContrat).orElseThrow(() -> new IllegalArgumentException("Contrat with id " + idContrat + " not found"));
		Equipe eq = equipeRepository.findById(idEquipe).orElseThrow(() -> new IllegalArgumentException("Equipe with id " + idEquipe + " not found"));
		if (c != null && eq != null) {
			c.setEtudiant(e);
			eq.getEtudiants().add(e);
		} else {
			// Handle the case when either Contrat or Equipe is null
		}
		return e;
	}

	public 	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
return  etudiantRepository.findEtudiantsByDepartement_IdDepart((idDepartement));
	}
}
