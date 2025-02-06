package com.joaovitor.entity;

import com.joaovitor.utils.UserTypeEnum;

public class DoctorEntity extends UserEntity{

    private String crm;
    private String specialty;

    public DoctorEntity() {
    }

    public DoctorEntity(String name, String email, String password, String crm, String specialty) {
        super(name, email, password, UserTypeEnum.DOCTOR);
        this.crm = crm;
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
