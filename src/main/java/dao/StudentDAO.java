package dao;

import models.Student;
import models.TopStudent;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Retrieve all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Sinhvien";

        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Failed to establish a connection to the database.");
            return students;  // Return an empty list to avoid further errors
        }

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String masv = resultSet.getString("Masv");
                String hoten = resultSet.getString("Hoten");
                Date ngaysinh = resultSet.getDate("Ngaysinh");
                String gioitinh = resultSet.getString("Gioitinh");
                String malop = resultSet.getString("Malop");

                Student student = new Student(masv, hoten, ngaysinh, gioitinh, malop);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return students;
    }


    // Add a new student
    public void addStudent(Student student) {
        String sql = "INSERT INTO Sinhvien (Masv, Hoten, Ngaysinh, Gioitinh, Malop) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getMasv());
            statement.setString(2, student.getHoten());
            statement.setDate(3, student.getNgaysinh());
            statement.setString(4, student.getGioitinh());
            statement.setString(5, student.getMalop());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(String masv) {
        Student student = null;
        String sql = "SELECT * FROM Sinhvien WHERE Masv = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, masv);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hoten = resultSet.getString("Hoten");
                java.sql.Date ngaysinh = resultSet.getDate("Ngaysinh");
                String gioitinh = resultSet.getString("Gioitinh");
                String malop = resultSet.getString("Malop");

                student = new Student(masv, hoten, ngaysinh, gioitinh, malop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    // Delete a student by Masv
    public void deleteStudent(String masv) {
        String sql = "DELETE FROM Sinhvien WHERE Masv = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, masv);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a student’s information
    public void updateStudent(Student student) {
        String sql = "UPDATE Sinhvien SET Hoten = ?, Ngaysinh = ?, Gioitinh = ?, Malop = ? WHERE Masv = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getHoten());
            statement.setDate(2, student.getNgaysinh());
            statement.setString(3, student.getGioitinh());
            statement.setString(4, student.getMalop());
            statement.setString(5, student.getMasv());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve students with a high score in “Trí tuệ nhân tạo” (TTNT)
    public List<TopStudent> getTopStudents(String mamon, double minScore) {
        List<TopStudent> students = new ArrayList<>();
        String sql = "SELECT S.Masv, S.Hoten, S.Ngaysinh, S.Gioitinh, S.Malop, " +
                "GREATEST(D.Diemlan1, D.Diemlan2) AS Diemcaonhat " +
                "FROM Sinhvien S " +
                "JOIN Diemthi D ON S.Masv = D.Masv " +
                "WHERE D.Mamon = ? AND (D.Diemlan1 >= ? OR D.Diemlan2 >= ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, mamon);
            statement.setDouble(2, minScore);
            statement.setDouble(3, minScore);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String masv = resultSet.getString("Masv");
                String hoten = resultSet.getString("Hoten");
                Date ngaysinh = resultSet.getDate("Ngaysinh");
                String gioitinh = resultSet.getString("Gioitinh");
                String malop = resultSet.getString("Malop");
                double diemcaonhat = resultSet.getDouble("Diemcaonhat");

                // Use the TopStudent constructor with diemcaonhat
                TopStudent student = new TopStudent(masv, hoten, ngaysinh, gioitinh, malop, diemcaonhat);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

}
