package com.joaovitor.controller;

import java.util.ArrayList;
import java.util.List;

import com.joaovitor.entity.PatientEntity;

public class PatientController {
    private List<PatientEntity> pacientes = new ArrayList<>();
    
    public void adicionarPaciente(PatientEntity paciente) {
        pacientes.add(paciente);
    }
    
    public List<PatientEntity> listarPacientes() {
        return pacientes;
    }
}

