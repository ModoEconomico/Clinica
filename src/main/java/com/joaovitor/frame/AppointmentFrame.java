package com.joaovitor.frame;

import javax.swing.*;
import java.awt.*;
import com.joaovitor.controller.AppointmentController;
import com.joaovitor.entity.AppointmentEntity;

public class AppointmentFrame extends JFrame {
    private AppointmentController appointmentController;

    public AppointmentFrame() {
        appointmentController = new AppointmentController();
        initUI();
    }

    private void initUI() {
        setTitle("Gerenciamento de Consultas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("CRM do Médico:"));
        JTextField doctorCrmField = new JTextField();
        inputPanel.add(doctorCrmField);

        inputPanel.add(new JLabel("Nome do Médico:"));
        JTextField doctorNameField = new JTextField();
        inputPanel.add(doctorNameField);

        inputPanel.add(new JLabel("CPF do Paciente:"));
        JTextField patientCpfField = new JTextField();
        inputPanel.add(patientCpfField);

        inputPanel.add(new JLabel("Data da Consulta:"));
        JTextField appointmentDateField = new JTextField();
        inputPanel.add(appointmentDateField);

        inputPanel.add(new JLabel("Hora da Consulta:"));
        JTextField appointmentTimeField = new JTextField();
        inputPanel.add(appointmentTimeField);

        panel.add(inputPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Adicionar Consulta");
        addButton.addActionListener(e -> {
            AppointmentEntity appointment = new AppointmentEntity();
            appointment.setDoctorCrm(doctorCrmField.getText());
            appointment.setDoctorName(doctorNameField.getText());
            appointment.setPatientCpf(patientCpfField.getText());
            appointment.setAppointmentDate(appointmentDateField.getText());
            appointment.setAppointmentTime(appointmentTimeField.getText());

            appointmentController.addAppointment(appointment);
            textArea.append("Consulta adicionada: " + appointment.getDoctorName() + " com " + appointment.getPatientCpf() + "\n");
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            SelectionFrame selectionFrame = new SelectionFrame();
            selectionFrame.setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(addButton, BorderLayout.CENTER);
        buttonPanel.add(backButton, BorderLayout.SOUTH);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AppointmentFrame ex = new AppointmentFrame();
            ex.setVisible(true);
        });
    }
}