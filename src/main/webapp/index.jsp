<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, models.Student, dao.StudentDAO" %>
<%
  StudentDAO studentDAO = new StudentDAO();
  List<Student> students = studentDAO.getAllStudents();
%>
<!DOCTYPE html>
<html>
  <head>
    <title>Danh sách sinh viên</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
  </head>
  <body>
    <h2>Student List</h2>
    <table border="1">
      <tr>
        <th>Mã sinh viên</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Mã lớp</th>
        <th>Actions</th>
      </tr>
      <%
        for (Student student : students) {
      %>
      <tr>
        <td><%= student.getMasv() %></td>
        <td><%= student.getHoten() %></td>
        <td><%= student.getNgaysinh() %></td>
        <td><%= "M".equals(student.getGioitinh()) ? "Nam" : "Nữ" %></td>
        <td><%= student.getMalop() %></td>
        <td>
          <a href="DeleteServlet?masv=<%= student.getMasv() %> " class="button delete">Delete</a> |
          <a href="update.jsp?masv=<%= student.getMasv() %>" class="button update">Update</a>
        </td>
      </tr>
      <%
        }
      %>
    </table>
    <br>
    <a href="add.jsp" class="button add">Add</a> | <a href="FindServlet" class="button find">Find</a>
  </body>
</html>
