package com.joaovitor.frame;

import javax.swing.*;
import java.awt.*;

public class SelectionFrame extends JFrame {

    public SelectionFrame() {
        initUI();
    }

    private void initUI() {
        setTitle("Seleção de Gerenciamento");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton patientButton = new JButton("Gerenciamento de Pacientes");
        patientButton.addActionListener(e -> {
            PatientFrame mainFrame = new PatientFrame();
            mainFrame.setVisible(true);
        });

        JButton doctorButton = new JButton("Gerenciamento de Médicos");
        doctorButton.addActionListener(e -> {
            DoctorFrame doctorFrame = new DoctorFrame();
            doctorFrame.setVisible(true);
        });

        JButton appointmentButton = new JButton("Gerenciamento de Consultas");
        appointmentButton.addActionListener(e -> {
            AppointmentFrame appointmentFrame = new AppointmentFrame();
            appointmentFrame.setVisible(true);
        });

        panel.add(patientButton);
        panel.add(doctorButton);
        panel.add(appointmentButton);

        add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SelectionFrame ex = new SelectionFrame();
            ex.setVisible(true);
        });
    }
}