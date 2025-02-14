package com.joaovitor.controllerTests;

import com.joaovitor.controller.DoctorController;
import com.joaovitor.entity.DoctorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorControllerTest {
    private DoctorController doctorController;

    @BeforeEach
    void setUp() {
        doctorController = new DoctorController();
    }

    @Test
    void testAddDoctor() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName("Dr. Smith");
        doctor.setCrm("CRM12345");
        doctor.setCrm("98765432100");
        doctor.setEmail("dr.smith@example.com");
        doctor.setSpecialty("Cardiology");

        doctorController.addDoctor(doctor);

        List<DoctorEntity> doctors = doctorController.listDoctors();
        assertFalse(doctors.isEmpty());
        assertEquals("Dr. Smith", doctors.get(0).getName());
    }

    @Test
    void testListDoctors() {
        List<DoctorEntity> doctors = doctorController.listDoctors();
        assertNotNull(doctors);
    }
}