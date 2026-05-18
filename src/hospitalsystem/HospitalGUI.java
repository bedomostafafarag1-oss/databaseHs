/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

import javax.swing.*;
import java.awt.*;

public class HospitalGUI extends JFrame {

    public HospitalGUI() {
        setTitle("Hospital Management System - Full Detail Edition");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar mb = new JMenuBar();
        setupFullMenu(mb, "Doctor");
        setupFullMenu(mb, "Nurse");
        setupFullMenu(mb, "Patient");
        setupFullMenu(mb, "Appointment");
        setupFullMenu(mb, "Department");

        setJMenuBar(mb);
        
        JLabel welcome = new JLabel("Hospital Management Dashboard", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcome, BorderLayout.CENTER);
    }

    private void setupFullMenu(JMenuBar mb, String type) {
        JMenu menu = new JMenu(type);
        JMenuItem add = new JMenuItem("Add " + type);
        JMenuItem rem = new JMenuItem("Remove " + type);
        JMenuItem sch = new JMenuItem("Search " + type);
        JMenuItem all = new JMenuItem("Display All");

        menu.add(add); menu.add(rem); menu.add(sch); menu.add(all);
        mb.add(menu);

        add.addActionListener(e -> handleAdd(type));
        
        rem.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter ID (or Name for Dept) to remove:");
            if (input == null || input.isEmpty()) return;
            try {
                if (type.equals("Doctor")) new DoctorDAO().remove(Integer.parseInt(input));
                else if (type.equals("Nurse")) new NurseDAO().remove(Integer.parseInt(input));
                else if (type.equals("Patient")) new PatientDAO().remove(Integer.parseInt(input));
                else if (type.equals("Appointment")) new AppointmentDAO().remove(Integer.parseInt(input));
                else new DepartmentDAO().remove(input);
                JOptionPane.showMessageDialog(this, type + " removed successfully.");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error processing removal."); }
        });

        sch.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter ID (or Name for Dept) to search:");
            if (input == null || input.isEmpty()) return;
            String res = "";
            try {
                if (type.equals("Doctor")) res = new DoctorDAO().search(Integer.parseInt(input));
                else if (type.equals("Nurse")) res = new NurseDAO().search(Integer.parseInt(input));
                else if (type.equals("Patient")) res = new PatientDAO().search(Integer.parseInt(input));
                else if (type.equals("Appointment")) res = new AppointmentDAO().search(Integer.parseInt(input));
                else res = new DepartmentDAO().search(input);
                JOptionPane.showMessageDialog(this, res);
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error processing search."); }
        });

        all.addActionListener(e -> {
            String res = "";
            if (type.equals("Doctor")) res = new DoctorDAO().getAll();
            else if (type.equals("Nurse")) res = new NurseDAO().getAll();
            else if (type.equals("Patient")) res = new PatientDAO().getAll();
            else if (type.equals("Appointment")) res = new AppointmentDAO().getAll();
            else res = new DepartmentDAO().getAll();
            
            showDetailedScroll(res, type);
        });
    }

    private void handleAdd(String type) {
        try {
            if (type.equals("Department")) {
                new DepartmentDAO().add(JOptionPane.showInputDialog("Department Name:"));
            } else if (type.equals("Appointment")) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Appt ID:"));
                int p = Integer.parseInt(JOptionPane.showInputDialog("Patient ID:"));
                int d = Integer.parseInt(JOptionPane.showInputDialog("Doctor ID:"));
                String dt = JOptionPane.showInputDialog("Date (DD/MM/YYYY):");
                String tm = JOptionPane.showInputDialog("Time:");
                new AppointmentDAO().add(id, p, d, dt, tm);
            } else {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
                String n = JOptionPane.showInputDialog("Name:");
                String g = JOptionPane.showInputDialog("Gender:");
                int a = Integer.parseInt(JOptionPane.showInputDialog("Age:"));

                if (type.equals("Doctor")) {
                    String s = JOptionPane.showInputDialog("Specialization:");
                    double sal = Double.parseDouble(JOptionPane.showInputDialog("Salary:"));
                    String l = JOptionPane.showInputDialog("Job Level:");
                    new DoctorDAO().add(new Doctor(id, n, g, a, s, sal, l));
                } else if (type.equals("Nurse")) {
                    String sh = JOptionPane.showInputDialog("Shift:");
                    int ex = Integer.parseInt(JOptionPane.showInputDialog("Years Experience:"));
                    new NurseDAO().add(new Nurse(id, n, g, a, sh, ex));
                } else if (type.equals("Patient")) {
                    String ds = JOptionPane.showInputDialog("Disease:");
                    String bl = JOptionPane.showInputDialog("Blood Type:");
                    String al = JOptionPane.showInputDialog("Allergies:");
                    String dia = JOptionPane.showInputDialog("Diagnosis:");
                    MedicalRecord mr = new MedicalRecord(bl, al, dia);
                    new PatientDAO().add(new Patient(id, n, g, a, ds, mr));
                }
            }
            JOptionPane.showMessageDialog(this, "Record saved successfully!");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error: Invalid Input."); }
    }

    private void showDetailedScroll(String data, String title) {
        JTextArea area = new JTextArea(data);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(600, 450));
        JOptionPane.showMessageDialog(this, scroll, title + " Records", JOptionPane.PLAIN_MESSAGE);
    }
}