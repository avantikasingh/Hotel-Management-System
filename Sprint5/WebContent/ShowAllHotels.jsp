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
<th>Hotel ID</th>
<th>Hotel Name</th>
<th>Hotel Address</th>
<th>Hotel Phone Number</th>
<th>Hotel Rating</th>

</tr> 
<a:forEach var = "pro" items="${data}">
<tr>

<td>${pro.hotelId}</td>
<td>${pro.hotelName}</td>
<td>${pro.hotelAddress}</td>
<td>${pro.hotelPhoneNumber}</td>
<td>${pro.hotelRating}</td>

</tr>
</a:forEach>
</table>

</body>
</html>