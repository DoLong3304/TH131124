<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Student, dao.StudentDAO" %>
<%
  String masv = request.getParameter("masv");
  StudentDAO studentDAO = new StudentDAO();
  Student student = studentDAO.getStudent(masv);
%>
<!DOCTYPE html>
<html>
<head>
  <title>Cập nhật thông tin</title>
  <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<h2>Cập nhật thông tin</h2>
<form action="UpdateStudentServlet" method="post">
  <input type="hidden" name="masv" value="<%= student.getMasv() %>">
  Họ và tên: <input type="text" name="hoten" value="<%= student.getHoten() %>" required><br>
  Ngày sinh: <input type="date" name="ngaysinh" value="<%= student.getNgaysinh() %>" required><br>
  Giới tính:
  <select name="gioitinh">
    <option value="M" <%= student.getGioitinh().equals("M") ? "selected" : "" %>>Nam</option>
    <option value="F" <%= student.getGioitinh().equals("F") ? "selected" : "" %>>Nữ</option>
  </select><br>
  Mã lớp: <input type="text" name="malop" value="<%= student.getMalop() %>" required><br>
  <input type="submit" value="Submit" class="button">
</form>
</body>
</html>
