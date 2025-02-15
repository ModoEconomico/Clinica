package com.joaovitor;

import com.joaovitor.GUI.SelectionFrame;
import com.joaovitor.utils.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DataBaseUtil.getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            SelectionFrame selectionFrame = new SelectionFrame();
            selectionFrame.setVisible(true);
        });
    }
}