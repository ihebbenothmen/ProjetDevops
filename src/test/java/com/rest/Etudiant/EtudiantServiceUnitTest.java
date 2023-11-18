package com.rest.Etudiant;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.exceptions.OrderNotFoundException;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
 class EtudiantServiceUnitTest {
    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    EtudiantServiceImpl etudiantService;

    @BeforeEach
    public void setup() {

    }

    @Test
     void testGetEtudiantsList() {
        Etudiant etudiant1 = new Etudiant(15, "Aouididi", "ahmed", Option.SE);
        Etudiant etudiant2 = new Etudiant(16, "chetti", "amal", Option.GAMIX);
        when(etudiantRepository.findAll()).thenReturn(Arrays.asList(etudiant1, etudiant2));
        List<Etudiant> orderList = etudiantService.retrieveAllEtudiants();
        assertEquals(orderList.size(), 2);
        assertEquals(orderList.get(0).getNomE(), "Aouididi");
        assertEquals(orderList.get(1).getNomE(), "chetti");
        assertEquals(orderList.get(0).getOp(), Option.SE);
        assertEquals(orderList.get(1).getOp(), Option.GAMIX);
    }

    @Test
     void testGetEtudiantById() {
        Etudiant etudiant = new Etudiant(19, "didi", "damine", Option.SE);
        when(etudiantRepository.findById(19)).thenReturn(Optional.of(etudiant));
        Etudiant etudiantById = etudiantService.retrieveEtudiant(19);
        assertNotEquals(etudiantById, null);
        assertEquals(etudiantById.getNomE(), "didi");
        assertEquals(etudiantById.getPrenomE(), "damine");
        assertEquals(etudiantById.getOp(), Option.SE);
    }


    @Test
     void testGetInvalidEtudiantById() {
        when(etudiantRepository.findById(19)).thenThrow(new OrderNotFoundException("Etudiant Not Found with ID"));
        Exception exception = assertThrows(OrderNotFoundException.class, () -> {
            etudiantService.retrieveEtudiant(19);
        });
        assertTrue(exception.getMessage().contains("Etudiant Not Found with ID"));
    }

    @Test
     void testCreateEtudiant() {
        Etudiant etudiant = new Etudiant(20, "Aouididi", "Mohamed", Option.GAMIX);
        etudiantService.addEtudiant(etudiant);
        verify(etudiantRepository, times(1)).save(etudiant);
        ArgumentCaptor<Etudiant> etudiantArgumentCaptor = ArgumentCaptor.forClass(Etudiant.class);
        verify(etudiantRepository).save(etudiantArgumentCaptor.capture());
        Etudiant etudiantCreated = etudiantArgumentCaptor.getValue();
        assertNotNull(etudiantCreated.getIdEtudiant());
        assertEquals("Aouididi", etudiantCreated.getNomE());
    }
/*
    @Test
    public void testDeleteOrder() {
        Etudiant etudiant = new Etudiant(15, "Aouididi", "ahmed", Option.SE);
        when(etudiantRepository.findById(15)).thenReturn(Optional.of(etudiant));
        etudiantService.removeEtudiant(etudiant.getIdEtudiant());
        verify(etudiantRepository, times(1)).deleteById(etudiant.getIdEtudiant());
        ArgumentCaptor<Long> etudiantArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(etudiantRepository).deleteById(Math.toIntExact(etudiantArgumentCaptor.capture()));
        Long etudiantIdDeleted = etudiantArgumentCaptor.getValue();
        assertNotNull(etudiantIdDeleted);
        assertEquals(15, etudiantIdDeleted);
    }*/
}
