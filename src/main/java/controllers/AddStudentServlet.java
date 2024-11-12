package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import models.Student;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String masv = request.getParameter("masv");
        String hoten = request.getParameter("hoten");
        Date ngaysinh = Date.valueOf(request.getParameter("ngaysinh"));
        String gioitinh = request.getParameter("gioitinh");
        String malop = request.getParameter("malop");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(new Student(masv, hoten, ngaysinh, gioitinh, malop));

        response.sendRedirect("index.jsp");
    }
}
