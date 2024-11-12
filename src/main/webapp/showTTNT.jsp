<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, models.TopStudent" %>
<!DOCTYPE html>
<html>
<head>
    <title>Top Students in AI</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
    <h2>Danh sách sinh viên</h2>
    <h3>Có điểm "Trí tuệ nhân tạo" >= 8.5</h3>
    <table border="1">
        <tr>
            <th>Mã sinh viên</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Mã lớp</th>
            <th>Điểm</th>
        </tr>
        <%
            List<TopStudent> topStudents = (List<TopStudent>) request.getAttribute("topStudents");
            for (TopStudent student : topStudents) {
        %>
        <tr>
            <td><%= student.getMasv() %></td>
            <td><%= student.getHoten() %></td>
            <td><%= student.getNgaysinh() %></td>
            <td><%= student.getGioitinh() %></td>
            <td><%= student.getMalop() %></td>
            <td><%= student.getDiemcaonhat() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
