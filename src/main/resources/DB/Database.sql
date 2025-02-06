CREATE DATABASE Clinica

CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('PACIENTE', 'MEDICO', 'ADMINISTRADOR') NOT NULL
)

CREATE TABLE Paciente (
    id INT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    rg VARCHAR(9) NOT NULL,
    data_nascimento DATE NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
)

CREATE TABLE Medico (
    id INT PRIMARY KEY,
    crm VARCHAR(7) NOT NULL,
    especialidade VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
)

CREATE TABLE Administrador (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuario(id)
)

CREATE TABLE Consulta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    FOREIGN KEY (medico_id) REFERENCES Medico(id),
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id)
)
