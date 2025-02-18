package com.joaovitor.controller;

import com.joaovitor.entity.PatientEntity;
import com.joaovitor.utils.DataBaseUtil;
import com.joaovitor.utils.UserTypeEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientController {

    public void addPatient(PatientEntity patient) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            
            String createTable = """
                CREATE TABLE IF NOT EXISTS patients (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  name TEXT NOT NULL,
                  email TEXT NOT NULL,
                  password TEXT NOT NULL,
                  userType TEXT NOT NULL,
                  dataNascimento TEXT,
                  cpf TEXT UNIQUE NOT NULL,
                  telefone TEXT,
                  planoSaude TEXT
                )
            """;
            conn.createStatement().execute(createTable);
            
            String sql = """
                INSERT INTO patients
                (name, email, password, userType, dataNascimento, cpf, telefone, planoSaude)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getEmail());
            stmt.setString(3, patient.getPassword());       
            stmt.setString(4, patient.getUserType().name());
            stmt.setString(5, patient.getDataNascimento());
            stmt.setString(6, patient.getCpf());
            stmt.setString(7, patient.getTelefone());
            stmt.setString(8, patient.getPlanoSaude());

            stmt.executeUpdate();
            System.out.println("Paciente inserido no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<PatientEntity> listPatients() {
        List<PatientEntity> patients = new ArrayList<>();
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = "SELECT * FROM patients";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PatientEntity p = new PatientEntity();                
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                
                String userTypeStr = rs.getString("userType");
                if (userTypeStr != null) {
                    p.setUserType(UserTypeEnum.valueOf(userTypeStr));
                }
                p.setDataNascimento(rs.getString("dataNascimento"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setPlanoSaude(rs.getString("planoSaude"));

                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
    
    public void updatePatient(String cpf, PatientEntity updatedPatient) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = """
                UPDATE patients
                SET name = ?, email = ?, password = ?, userType = ?,
                    dataNascimento = ?, telefone = ?, planoSaude = ?
                WHERE cpf = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, updatedPatient.getName());
            stmt.setString(2, updatedPatient.getEmail());
            stmt.setString(3, updatedPatient.getPassword());
            stmt.setString(4, updatedPatient.getUserType().name());
            stmt.setString(5, updatedPatient.getDataNascimento());
            stmt.setString(6, updatedPatient.getTelefone());
            stmt.setString(7, updatedPatient.getPlanoSaude());
            stmt.setString(8, cpf);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Paciente atualizado com sucesso!");
            } else {
                System.out.println("Nenhum paciente encontrado com CPF " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public void deletePatient(String cpf) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            String sql = "DELETE FROM patients WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Paciente deletado com sucesso!");
            } else {
                System.out.println("Nenhum paciente encontrado com CPF " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/* jOÃO, COMENTEI PARA NÃO PERDER MAS ESSA LISTA NÃO É NECESSÁRIA
VISTO QUE ESTOU IMPLEMENTANDO O BANCO
package com.joaovitor.controller;

import java.util.ArrayList;
import java.util.List;
import com.joaovitor.entity.PatientEntity;

public class PatientController {
    private List<PatientEntity> patients = new ArrayList<>();

    public void addPatient(PatientEntity patient) {
        patients.add(patient);
    }

    public List<PatientEntity> listPatients() {
        return patients;
    }

    public void updatePatient(String cpf, PatientEntity updatedPatient) {
        for (PatientEntity patient : patients) {
            if (patient.getCpf().equals(cpf)) {
                patient.setName(updatedPatient.getName());
                patient.setDataNascimento(updatedPatient.getDataNascimento());
                patient.setTelefone(updatedPatient.getTelefone());
                patient.setEmail(updatedPatient.getEmail());
                patient.setPlanoSaude(updatedPatient.getPlanoSaude());
                break;
            }
        }
    }

    public void deletePatient(String cpf) {
        patients.removeIf(patient -> patient.getCpf().equals(cpf));
    }
} */
