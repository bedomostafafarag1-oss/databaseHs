/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;


import java.sql.*;
import javax.swing.JOptionPane;

public class HospitalData {
    private static final String URL = "jdbc:sqlite:hospital.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) { System.out.println("Connection Error: " + e.getMessage()); }
        return conn;
    }

    public static void initializeDatabase() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS doctors (id INTEGER PRIMARY KEY, name TEXT, gender TEXT, age INTEGER, specialization TEXT, salary REAL, jobLevel TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS nurses (id INTEGER PRIMARY KEY, name TEXT, gender TEXT, age INTEGER, shift TEXT, experience INTEGER)");
            stmt.execute("CREATE TABLE IF NOT EXISTS patients (id INTEGER PRIMARY KEY, name TEXT, gender TEXT, age INTEGER, disease TEXT, bloodType TEXT, allergies TEXT, diagnosis TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS appointments (id INTEGER PRIMARY KEY, pId INTEGER, dId INTEGER, date TEXT, time TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS departments (name TEXT PRIMARY KEY)");
        } catch (SQLException e) { System.out.println("DB Init Error: " + e.getMessage()); }
    }
}

// --- DOCTOR DAO ---
class DoctorDAO {
    public void add(Doctor d) {
        String sql = "INSERT INTO doctors VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, d.getId()); pstmt.setString(2, d.getName()); pstmt.setString(3, d.getGender());
            pstmt.setInt(4, d.getAge()); pstmt.setString(5, d.getSpecialization());
            pstmt.setDouble(6, d.getSalary()); pstmt.setString(7, d.getJobLevel());
            pstmt.executeUpdate();
        } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Save Error: " + e.getMessage()); }
    }
    public void remove(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM doctors WHERE id=?")) {
            pstmt.setInt(1, id); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public String search(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM doctors WHERE id=?")) {
            pstmt.setInt(1, id); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return "ID: " + rs.getInt("id") + "\nName: " + rs.getString("name") + "\nSpec: " + rs.getString("specialization") + "\nSalary: " + rs.getDouble("salary");
        } catch (SQLException e) { }
        return "Doctor Not Found";
    }
    public String getAll() {
        StringBuilder sb = new StringBuilder("********** ALL DOCTORS **********\n\n");
        try (Connection conn = HospitalData.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM doctors")) {
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id")).append("\nName: ").append(rs.getString("name"))
                  .append("\nGender: ").append(rs.getString("gender")).append("\nAge: ").append(rs.getInt("age"))
                  .append("\nSpec: ").append(rs.getString("specialization")).append("\nLevel: ").append(rs.getString("jobLevel"))
                  .append("\nSalary: $").append(rs.getDouble("salary")).append("\n----------------------\n");
            }
        } catch (SQLException e) { }
        return sb.toString();
    }
}

// --- NURSE DAO ---
class NurseDAO {
    public void add(Nurse n) {
        String sql = "INSERT INTO nurses VALUES(?,?,?,?,?,?)";
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, n.getId()); pstmt.setString(2, n.getName()); pstmt.setString(3, n.getGender());
            pstmt.setInt(4, n.getAge()); pstmt.setString(5, n.getShift()); pstmt.setInt(6, n.getYearsOfExperience());
            pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public void remove(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM nurses WHERE id=?")) {
            pstmt.setInt(1, id); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public String search(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM nurses WHERE id=?")) {
            pstmt.setInt(1, id); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return "Nurse: " + rs.getString("name") + "\nShift: " + rs.getString("shift");
        } catch (SQLException e) { }
        return "Nurse Not Found";
    }
    public String getAll() {
        StringBuilder sb = new StringBuilder("********** ALL NURSES **********\n\n");
        try (Connection conn = HospitalData.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM nurses")) {
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id")).append("\nName: ").append(rs.getString("name"))
                  .append("\nGender: ").append(rs.getString("gender")).append("\nAge: ").append(rs.getInt("age"))
                  .append("\nShift: ").append(rs.getString("shift")).append("\nExp: ").append(rs.getInt("experience"))
                  .append("\n----------------------\n");
            }
        } catch (SQLException e) { }
        return sb.toString();
    }
}

// --- PATIENT DAO ---
class PatientDAO {
    public void add(Patient p) {
        String sql = "INSERT INTO patients VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, p.getId()); pstmt.setString(2, p.getName()); pstmt.setString(3, p.getGender());
            pstmt.setInt(4, p.getAge()); pstmt.setString(5, p.getDisease());
            pstmt.setString(6, p.getMedicalRecord().getBloodType());
            pstmt.setString(7, p.getMedicalRecord().getAllergies());
            pstmt.setString(8, p.getMedicalRecord().getDiagnosis());
            pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public void remove(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM patients WHERE id=?")) {
            pstmt.setInt(1, id); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public String search(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patients WHERE id=?")) {
            pstmt.setInt(1, id); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return "Patient: " + rs.getString("name") + "\nBlood: " + rs.getString("bloodType");
        } catch (SQLException e) { }
        return "Patient Not Found";
    }
    public String getAll() {
        StringBuilder sb = new StringBuilder("********** ALL PATIENTS **********\n\n");
        try (Connection conn = HospitalData.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM patients")) {
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id")).append("\nName: ").append(rs.getString("name"))
                  .append("\nGender: ").append(rs.getString("gender")).append("\nAge: ").append(rs.getInt("age"))
                  .append("\nDisease: ").append(rs.getString("disease")).append("\nBlood: ").append(rs.getString("bloodType"))
                  .append("\nAllergies: ").append(rs.getString("allergies")).append("\nDiagnosis: ").append(rs.getString("diagnosis"))
                  .append("\n----------------------\n");
            }
        } catch (SQLException e) { }
        return sb.toString();
    }
}

// --- APPOINTMENT DAO ---
class AppointmentDAO {
    public void add(int id, int pId, int dId, String date, String time) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO appointments VALUES(?,?,?,?,?)")) {
            pstmt.setInt(1, id); pstmt.setInt(2, pId); pstmt.setInt(3, dId);
            pstmt.setString(4, date); pstmt.setString(5, time);
            pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public void remove(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM appointments WHERE id=?")) {
            pstmt.setInt(1, id); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public String search(int id) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM appointments WHERE id=?")) {
            pstmt.setInt(1, id); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return "Appt ID: " + rs.getInt("id") + "\nDate: " + rs.getString("date") + "\nTime: " + rs.getString("time");
        } catch (SQLException e) { }
        return "Appointment Not Found";
    }
    public String getAll() {
        StringBuilder sb = new StringBuilder("********** ALL APPOINTMENTS **********\n\n");
        try (Connection conn = HospitalData.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM appointments")) {
            while (rs.next()) {
                sb.append("Appt ID: ").append(rs.getInt("id")).append("\nPatient ID: ").append(rs.getInt("pId"))
                  .append("\nDoctor ID: ").append(rs.getInt("dId")).append("\nDate: ").append(rs.getString("date"))
                  .append("\nTime: ").append(rs.getString("time")).append("\n----------------------\n");
            }
        } catch (SQLException e) { }
        return sb.toString();
    }
}

// --- DEPARTMENT DAO ---
class DepartmentDAO {
    public void add(String name) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO departments VALUES(?)")) {
            pstmt.setString(1, name); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public void remove(String name) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM departments WHERE name=?")) {
            pstmt.setString(1, name); pstmt.executeUpdate();
        } catch (SQLException e) { }
    }
    public String search(String name) {
        try (Connection conn = HospitalData.connect(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments WHERE name=?")) {
            pstmt.setString(1, name); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return "Found Department: " + rs.getString("name");
        } catch (SQLException e) { }
        return "Department Not Found";
    }
    public String getAll() {
        StringBuilder sb = new StringBuilder("********** DEPARTMENTS **********\n\n");
        try (Connection conn = HospitalData.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM departments")) {
            while (rs.next()) sb.append("- ").append(rs.getString("name")).append("\n");
        } catch (SQLException e) { }
        return sb.toString();
    }
}