package com.joaovitor;

import

import com.joaovitor.controller.PatientController;
import com.joaovitor.service.AuthService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthService authService = new AuthService();
        if (authService.authenticate()) {
            PatientController pacienteController = new PatientController();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Create Paciente");
                System.out.println("2. List All Pacientes");
                System.out.println("3. Update Paciente");
                System.out.println("4. Delete Paciente");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        pacienteController.create();
                        break;
                    case 2:
                        pacienteController.listAll();
                        break;
                    case 3:
                        pacienteController.update();
                        break;
                    case 4:
                        pacienteController.delete();
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        } else {
            System.out.println("Authentication failed.");
        }
    }
}