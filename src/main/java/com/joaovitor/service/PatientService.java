package com.joaovitor.service;

import java.util.ArrayList;
import java.util.List;

import com.joaovitor.entity.PatientEntity;

public class PatientService {
        private List<PatientEntity> patientEntitys = new ArrayList<>();
    
    public void adicionarPatientEntity(PatientEntity PatientEntity) {
        patientEntitys.add(PatientEntity);
    }
    
    public List<PatientEntity> listarPatientEntitys() {
        return patientEntitys;
    }
    
    public PatientEntity buscarPatientEntityPorCpf(String cpf) {
        return patientEntitys.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().orElse(null);
    }
    
    public boolean atualizarPatientEntity(String cpf, String nome, String telefone, String email, String planoSaude) {
        PatientEntity PatientEntity = buscarPatientEntityPorCpf(cpf);
        if (PatientEntity != null) {
            PatientEntity.setName(nome);
            PatientEntity.setTelefone(telefone);
            PatientEntity.setEmail(email);
            PatientEntity.setPlanoSaude(planoSaude);
            return true;
        }
        return false;
    }
    
    public boolean removerPatientEntity(String cpf) {
        return patientEntitys.removeIf(p -> p.getCpf().equals(cpf));
    }
}
