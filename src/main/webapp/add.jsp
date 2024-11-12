<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Student</title>
  <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<h2>Add New Student</h2>
<form action="AddStudentServlet" method="post">
  Mã sinh viên: <input type="text" name="masv" required><br>
  Họ và tên: <input type="text" name="hoten" required><br>
  Ngày sinh: <input type="date" name="ngaysinh" required><br>
  Giới tính:
  <select name="gioitinh">
    <option value="M">Nam</option>
    <option value="F">Nữ</option>
  </select><br>
  Mã lớp: <input type="text" name="malop" required><br>
  <input type="submit" value="Submit" class="button">
</form>
</body>
</html>
