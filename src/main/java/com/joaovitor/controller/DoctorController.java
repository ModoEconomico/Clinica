package com.joaovitor.controller;

import com.joaovitor.entity.DoctorEntity;
import com.joaovitor.utils.DataBaseUtil;
import com.joaovitor.utils.UserTypeEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {

    public void addDoctor(DoctorEntity doctor) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            
            String createTable = """
                CREATE TABLE IF NOT EXISTS doctors (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  name TEXT NOT NULL,
                  email TEXT NOT NULL,
                  password TEXT NOT NULL,
                  userType TEXT NOT NULL,
                  crm TEXT UNIQUE NOT NULL,
                  specialty TEXT
                )
            """;
            conn.createStatement().execute(createTable);

            // Monta o comando INSERT
            String sql = """
                INSERT INTO doctors
                (name, email, password, userType, crm, specialty)
                VALUES (?, ?, ?, ?, ?, ?)
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getEmail());
            stmt.setString(3, doctor.getPassword());
            // Salva o enum como texto (por exemplo, "DOCTOR")
            stmt.setString(4, doctor.getUserType().name());
            stmt.setString(5, doctor.getCrm());
            stmt.setString(6, doctor.getSpecialty());

            stmt.executeUpdate();
            System.out.println("Médico inserido no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DoctorEntity> listDoctors() {
        List<DoctorEntity> doctors = new ArrayList<>();
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = "SELECT * FROM doctors";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DoctorEntity d = new DoctorEntity();
                
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                d.setPassword(rs.getString("password"));

                String userTypeStr = rs.getString("userType");
                if (userTypeStr != null) {
                    d.setUserType(UserTypeEnum.valueOf(userTypeStr));
                }

                d.setCrm(rs.getString("crm"));
                d.setSpecialty(rs.getString("specialty"));

                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public void updateDoctor(String crm, DoctorEntity updatedDoctor) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = """
                UPDATE doctors
                SET name = ?, email = ?, password = ?, userType = ?,
                    specialty = ?
                WHERE crm = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, updatedDoctor.getName());
            stmt.setString(2, updatedDoctor.getEmail());
            stmt.setString(3, updatedDoctor.getPassword());
            stmt.setString(4, updatedDoctor.getUserType().name());
            stmt.setString(5, updatedDoctor.getSpecialty());
            stmt.setString(6, crm);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Médico atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Nenhum médico encontrado com CRM " + crm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(String crm) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = "DELETE FROM doctors WHERE crm = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, crm);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Médico deletado com sucesso!");
            } else {
                System.out.println("Nenhum médico encontrado com CRM " + crm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
