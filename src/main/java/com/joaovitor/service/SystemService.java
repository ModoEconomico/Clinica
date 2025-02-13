/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.joaovitor.service;

import java.util.ArrayList;
import java.util.List;

import com.joaovitor.entity.DoctorEntity;
import com.joaovitor.entity.PatientEntity;
import com.joaovitor.entity.QueriesEntity;

/**
 *
 * @author joao
 */
public class SystemService {
         private List<PatientEntity> PatientEntitys = new ArrayList<>();
    private List<DoctorEntity> medicos = new ArrayList<>();
    private List<QueriesEntity> consultas = new ArrayList<>();

   

    public void listarPatientEntitys() {
        PatientEntitys.forEach(System.out::println);
    }
}
