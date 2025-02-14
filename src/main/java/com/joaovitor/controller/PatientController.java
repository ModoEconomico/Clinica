package com.joaovitor.controller;

import java.util.ArrayList;
import java.util.List;
import com.joaovitor.entity.PatientEntity;

public class PatientController {
    private List<PatientEntity> patients = new ArrayList<>();

    public void addPatient(PatientEntity patient) {
        patients.add(patient);
    }

    public List<PatientEntity> listPatients() {
        return patients;
    }

    public void updatePatient(String cpf, PatientEntity updatedPatient) {
        for (PatientEntity patient : patients) {
            if (patient.getCpf().equals(cpf)) {
                patient.setName(updatedPatient.getName());
                patient.setDataNascimento(updatedPatient.getDataNascimento());
                patient.setTelefone(updatedPatient.getTelefone());
                patient.setEmail(updatedPatient.getEmail());
                patient.setPlanoSaude(updatedPatient.getPlanoSaude());
                break;
            }
        }
    }

    public void deletePatient(String cpf) {
        patients.removeIf(patient -> patient.getCpf().equals(cpf));
    }
}