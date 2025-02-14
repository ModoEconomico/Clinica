package com.joaovitor.controllerTests;

import com.joaovitor.controller.PatientController;
import com.joaovitor.entity.PatientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientControllerTest {
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        patientController = new PatientController();
    }

    @Test
    void testAddPatient() {
        PatientEntity patient = new PatientEntity();
        patient.setName("John Doe");
        patient.setDataNascimento("1990-01-01");
        patient.setCpf("12345678900");
        patient.setTelefone("123456789");
        patient.setEmail("john.doe@example.com");
        patient.setPlanoSaude("Health Plan A");

        patientController.addPatient(patient);

        List<PatientEntity> patients = patientController.listPatients();
        assertFalse(patients.isEmpty());
        assertEquals("John Doe", patients.get(0).getName());
    }

    @Test
    void testListPatients() {
        List<PatientEntity> patients = patientController.listPatients();
        assertNotNull(patients);
    }
}