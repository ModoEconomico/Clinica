package com.joaovitor.controller;

import com.joaovitor.entity.AppointmentEntity;

import java.util.ArrayList;
import java.util.List;

public class AppointmentController {
    private List<AppointmentEntity> appointments = new ArrayList<>();

    public void addAppointment(AppointmentEntity appointment) {
        appointments.add(appointment);
    }

    public List<AppointmentEntity> listAppointmentsByDoctor(String crm) {
        List<AppointmentEntity> result = new ArrayList<>();
        for (AppointmentEntity appointment : appointments) {
            if (appointment.getDoctorCrm().equals(crm)) {
                result.add(appointment);
            }
        }
        return result;
    }

    public void updateAppointment(String patientCpf, AppointmentEntity updatedAppointment) {
        for (AppointmentEntity appointment : appointments) {
            if (appointment.getPatientCpf().equals(patientCpf)) {
                appointment.setDoctorCrm(updatedAppointment.getDoctorCrm());
                appointment.setDoctorName(updatedAppointment.getDoctorName());
                appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                break;
            }
        }
    }

    public void deleteAppointment(String patientCpf) {
        appointments.removeIf(appointment -> appointment.getPatientCpf().equals(patientCpf));
    }
}