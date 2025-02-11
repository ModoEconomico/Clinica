/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.joaovitor.entity;

/**
 *
 * @author joao
 */
public class QueriesEntity {
    private String idConsulta;
    private String crmMedico;
    private String nomeMedico;
    private String data;
    private String horario;
    private String cpfPaciente;
    private boolean confirmada;

    public QueriesEntity(String crmMedico, String nomeMedico, String data, String horario, String cpfPaciente) {
        this.crmMedico = crmMedico;
        this.nomeMedico = nomeMedico;
        this.data = data;
        this.horario = horario;
        this.cpfPaciente = cpfPaciente;
        this.confirmada = false;
        this.idConsulta = crmMedico + "-" + data + "-" + horario + "-" + cpfPaciente;
    }

    public String getIdConsulta() { return idConsulta; }
    public boolean isConfirmada() { return confirmada; }
    public void confirmar() { this.confirmada = true; }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta='" + idConsulta + '\'' +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", confirmada=" + confirmada +
                '}';
    }

}
