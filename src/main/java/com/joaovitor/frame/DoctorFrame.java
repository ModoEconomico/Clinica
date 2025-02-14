package com.joaovitor.frame;

import javax.swing.*;
import java.awt.*;
import com.joaovitor.controller.DoctorController;
import com.joaovitor.entity.DoctorEntity;

public class DoctorFrame extends JFrame {
    private DoctorController doctorController;

    public DoctorFrame() {
        doctorController = new DoctorController();
        initUI();
    }

    private void initUI() {
        setTitle("Gerenciamento de Médicos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Nome:"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("CRM:"));
        JTextField crmField = new JTextField();
        inputPanel.add(crmField);

        inputPanel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        inputPanel.add(cpfField);

        inputPanel.add(new JLabel("Telefone:"));
        JTextField phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Especialidade:"));
        JTextField specialtyField = new JTextField();
        inputPanel.add(specialtyField);

        panel.add(inputPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Adicionar Médico");
        addButton.addActionListener(e -> {
            DoctorEntity doctor = new DoctorEntity();
            doctor.setName(nameField.getText());
            doctor.setCrm(crmField.getText());
            doctor.setCrm(cpfField.getText());
            doctor.setEmail(emailField.getText());
            doctor.setSpecialty(specialtyField.getText());

            doctorController.addDoctor(doctor);
            textArea.append("Médico adicionado: " + doctor.getName() + "\n");
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
            DoctorFrame ex = new DoctorFrame();
            ex.setVisible(true);
        });
    }
}