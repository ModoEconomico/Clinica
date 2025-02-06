package com.joaovitor.entity;

import com.joaovitor.utils.UserTypeEnum;

public class PatientEntity extends UserEntity{

    private String cpf;
    private String rg;
    private String address;
    private String phone;

    public PatientEntity() {
    }

    public PatientEntity(String name, String email, String password, String cpf, String rg, String address, String phone) {
        super(name, email, password , UserTypeEnum.PATIENT);
        this.cpf = cpf;
        this.rg = rg;
        this.address = address;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
