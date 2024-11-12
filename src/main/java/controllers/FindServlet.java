package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import models.TopStudent;

import java.io.IOException;
import java.util.List;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        List<TopStudent> topStudents = studentDAO.getTopStudents("TTNT", 8.5);
        request.setAttribute("topStudents", topStudents);
        request.getRequestDispatcher("showTTNT.jsp").forward(request, response);
    }
}
