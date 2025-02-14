package com.joaovitor.controllerTests;

import com.joaovitor.controller.AppointmentController;
import com.joaovitor.entity.AppointmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentControllerTest {
    private AppointmentController appointmentController;

    @BeforeEach
    void setUp() {
        appointmentController = new AppointmentController();
    }

    @Test
    void testAddAppointment() {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setDoctorCrm("CRM12345");
        appointment.setDoctorName("Dr. Smith");
        appointment.setPatientCpf("12345678900");
        appointment.setAppointmentDate("2023-10-10");
        appointment.setAppointmentTime("10:00");

        appointmentController.addAppointment(appointment);

        List<AppointmentEntity> appointments = appointmentController.listAppointmentsByDoctor("CRM12345");
        assertFalse(appointments.isEmpty());
        assertEquals("Dr. Smith", appointments.get(0).getDoctorName());
    }

    @Test
    void testListAppointments() {
        List<AppointmentEntity> appointments = appointmentController.listAppointmentsByDoctor("CRM12345");
        assertNotNull(appointments);
    }
}