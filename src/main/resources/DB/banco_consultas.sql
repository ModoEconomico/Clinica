-- Criando o banco de dados (caso ainda não exista)
PRAGMA foreign_keys = ON;

-- Criando a tabela de Pacientes
CREATE TABLE IF NOT EXISTS paciente (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        nome TEXT NOT NULL,
                                        data_nascimento TEXT NOT NULL,
                                        cpf TEXT UNIQUE NOT NULL,
                                        telefone TEXT,
                                        email TEXT,
                                        plano_saude TEXT
);

-- Criando a tabela de Doutores
CREATE TABLE IF NOT EXISTS doutor (
                                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                                      nome TEXT NOT NULL,
                                      crm TEXT UNIQUE NOT NULL,
                                      cpf TEXT UNIQUE NOT NULL,
                                      telefone TEXT,
                                      email TEXT,
                                      especialidade TEXT NOT NULL
);

-- Criando a tabela de Consultas
CREATE TABLE IF NOT EXISTS consulta (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        id_paciente INTEGER NOT NULL,
                                        id_doutor INTEGER NOT NULL,
                                        data TEXT NOT NULL,
                                        horario TEXT NOT NULL,
                                        status TEXT DEFAULT 'Pendente',
                                        FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    FOREIGN KEY (id_doutor) REFERENCES doutor(id),
    UNIQUE (id_doutor, data, horario)
    );

-- Mensagem de confirmação
SELECT 'Banco de dados "consultas.db" e tabelas criadas com sucesso!' AS Mensagem;
