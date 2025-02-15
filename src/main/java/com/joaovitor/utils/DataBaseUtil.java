package com.joaovitor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    private static final String URL = "jdbc:sqlite:consultas.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}