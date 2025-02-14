package com.joaovitor.controller;

import com.joaovitor.entity.DoctorEntity;

import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    private List<DoctorEntity> doctors = new ArrayList<>();

    public void addDoctor(DoctorEntity doctor) {
        doctors.add(doctor);
    }

    public List<DoctorEntity> listDoctors() {
        return doctors;
    }

    public void updateDoctor(String crm, DoctorEntity updatedDoctor) {
        for (DoctorEntity doctor : doctors) {
            if (doctor.getCrm().equals(crm)) {
                doctor.setName(updatedDoctor.getName());
                doctor.setCrm(updatedDoctor.getCrm());
                doctor.setEmail(updatedDoctor.getEmail());
                doctor.setSpecialty(updatedDoctor.getSpecialty());
                break;
            }
        }
    }

    public void deleteDoctor(String crm) {
        doctors.removeIf(doctor -> doctor.getCrm().equals(crm));
    }
}