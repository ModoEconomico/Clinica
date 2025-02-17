package com.joaovitor;

import com.joaovitor.GUI.SelectionFrame;
import com.joaovitor.utils.DataBaseUtil;
import com.joaovitor.config.SimpleHttpServer;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            if (conn != null) {
                System.out.println("Conectado ao banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                SimpleHttpServer server = new SimpleHttpServer();
                server.startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        
        java.awt.EventQueue.invokeLater(() -> {
            SelectionFrame selectionFrame = new SelectionFrame();
            selectionFrame.setVisible(true);
        });
    }
}