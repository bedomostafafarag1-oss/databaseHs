/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalsystem;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class HospitalSystem {
    public static void main(String[] args) {
        // Initialize DB tables
        HospitalData.initializeDatabase();

        // Start GUI
        SwingUtilities.invokeLater(() -> {
            new HospitalGUI().setVisible(true);
        });
    }
}