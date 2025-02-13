package com.joaovitor.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = "jdbc:sqlite:/home/joao/snap/dbeaver-ce/352/.local/share/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db"; // Nome do banco atualizado

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL);
            System.out.println(
                "Conectado ao banco de dados 'consultas' com sucesso!"
            );
            return conexao;
        } catch (SQLException e) {
            System.err.println(
                "Erro ao conectar ao banco de dados: " + e.getMessage()
            );
            return null;
        }
    }

    public static void main(String[] args) {
        conectar(); // Testando a conexão
    }
}
