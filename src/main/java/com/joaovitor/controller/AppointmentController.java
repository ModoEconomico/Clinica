package com.joaovitor.controller;

import com.joaovitor.entity.AppointmentEntity;
import com.joaovitor.utils.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {

    public void addAppointment(AppointmentEntity appointment) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            
            String createTable = """
                CREATE TABLE IF NOT EXISTS appointments (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  doctorCrm TEXT NOT NULL,
                  doctorName TEXT,
                  patientCpf TEXT NOT NULL,
                  appointmentDate TEXT NOT NULL,
                  appointmentTime TEXT NOT NULL
                )
            """;
            conn.createStatement().execute(createTable);

            String sql = """
                INSERT INTO appointments
                (doctorCrm, doctorName, patientCpf, appointmentDate, appointmentTime)
                VALUES (?, ?, ?, ?, ?)
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, appointment.getDoctorCrm());
            stmt.setString(2, appointment.getDoctorName());
            stmt.setString(3, appointment.getPatientCpf());
            stmt.setString(4, appointment.getAppointmentDate());
            stmt.setString(5, appointment.getAppointmentTime());

            stmt.executeUpdate();
            System.out.println("Consulta inserida no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AppointmentEntity> listAppointments() {
        List<AppointmentEntity> appointments = new ArrayList<>();
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = "SELECT * FROM appointments";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AppointmentEntity app = new AppointmentEntity();
                app.setDoctorCrm(rs.getString("doctorCrm"));
                app.setDoctorName(rs.getString("doctorName"));
                app.setPatientCpf(rs.getString("patientCpf"));
                app.setAppointmentDate(rs.getString("appointmentDate"));
                app.setAppointmentTime(rs.getString("appointmentTime"));

                appointments.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    /**
     * UPDATE - Atualiza os dados de uma consulta identificada por (doctorCrm, appointmentDate, appointmentTime).
     * @param oldDoctorCrm       CRM do médico (valor antigo)
     * @param oldAppointmentDate Data da consulta (valor antigo)
     * @param oldAppointmentTime Horário da consulta (valor antigo)
     * @param updatedApp         Objeto com os novos valores
     */
    public void updateAppointment(String oldDoctorCrm, String oldAppointmentDate, String oldAppointmentTime,
                                  AppointmentEntity updatedApp) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = """
                UPDATE appointments
                SET doctorCrm = ?, doctorName = ?, patientCpf = ?, appointmentDate = ?, appointmentTime = ?
                WHERE doctorCrm = ? AND appointmentDate = ? AND appointmentTime = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Novos valores
            stmt.setString(1, updatedApp.getDoctorCrm());
            stmt.setString(2, updatedApp.getDoctorName());
            stmt.setString(3, updatedApp.getPatientCpf());
            stmt.setString(4, updatedApp.getAppointmentDate());
            stmt.setString(5, updatedApp.getAppointmentTime());
            stmt.setString(6, oldDoctorCrm);
            stmt.setString(7, oldAppointmentDate);
            stmt.setString(8, oldAppointmentTime);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Consulta atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma consulta encontrada com (CRM, Data, Hora) = (" +
                                   oldDoctorCrm + ", " + oldAppointmentDate + ", " + oldAppointmentTime + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(String doctorCrm, String appointmentDate, String appointmentTime) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = """
                DELETE FROM appointments
                WHERE doctorCrm = ? AND appointmentDate = ? AND appointmentTime = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, doctorCrm);
            stmt.setString(2, appointmentDate);
            stmt.setString(3, appointmentTime);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Consulta deletada com sucesso!");
            } else {
                System.out.println("Nenhuma consulta encontrada com (CRM, Data, Hora) = (" +
                                   doctorCrm + ", " + appointmentDate + ", " + appointmentTime + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
