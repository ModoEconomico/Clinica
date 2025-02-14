package com.joaovitor.frame;

import javax.swing.*;
import java.awt.*;
import com.joaovitor.controller.PatientController;
import com.joaovitor.entity.PatientEntity;

public class PatientFrame extends JFrame {
    private PatientController patientController;

    public PatientFrame() {
        patientController = new PatientController();
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Gestão de Consultas Médicas");
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

        inputPanel.add(new JLabel("Data de Nascimento:"));
        JTextField birthDateField = new JTextField();
        inputPanel.add(birthDateField);

        inputPanel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        inputPanel.add(cpfField);

        inputPanel.add(new JLabel("Telefone:"));
        JTextField phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Plano de Saúde:"));
        JTextField healthPlanField = new JTextField();
        inputPanel.add(healthPlanField);

        panel.add(inputPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Adicionar Paciente");
        addButton.addActionListener(e -> {
            PatientEntity patient = new PatientEntity();
            patient.setName(nameField.getText());
            patient.setDataNascimento(birthDateField.getText());
            patient.setCpf(cpfField.getText());
            patient.setTelefone(phoneField.getText());
            patient.setEmail(emailField.getText());
            patient.setPlanoSaude(healthPlanField.getText());

            patientController.addPatient(patient);
            textArea.append("Paciente adicionado: " + patient.getName() + "\n");
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
            PatientFrame ex = new PatientFrame();
            ex.setVisible(true);
        });
    }
}