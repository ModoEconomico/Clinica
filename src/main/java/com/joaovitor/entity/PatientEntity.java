package com.joaovitor.entity;

import com.joaovitor.utils.UserTypeEnum;

public class PatientEntity extends UserEntity{
    private static int contador = 1;

    private String dataNascimento;
    private String cpf;
    private String telefone;
    private String planoSaude;

    public PatientEntity() {
    }

    public PatientEntity(String name, String email, String password, String dataNascimento, String cpf, String telefone, String planoSaude) {
        super(name, email, password, UserTypeEnum.PATIENT);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.planoSaude = planoSaude;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        PatientEntity.contador = contador;
    }

    @Override
    public String toString() {
        return "PatientEntity [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + getEmail() + ", name=" + getName() + ", password=" + getPassword() + ", planoSaude=" + planoSaude + ", telefone=" + telefone + "]";
    }

    public static void incrementarContador() {
        contador++;
    }

    public static void decrementarContador() {
        contador--;
    }

    public static void zerarContador() {
        contador = 1;
    }

    

    
}
