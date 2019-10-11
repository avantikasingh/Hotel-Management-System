<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "a" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>Room ID</th>
<th>Room Type</th>
<th>Room Rent</th>
<th>Room Number</th>
</tr> 
<a:forEach var = "pro" items="${data}">
<tr>

<td>${pro.roomId}</td>
<td>${pro.roomType}</td>
<td>${pro.roomRent}</td>
<td>${pro.roomNumber}</td>
</tr>
</a:forEach>
</table>

</body>
</html>