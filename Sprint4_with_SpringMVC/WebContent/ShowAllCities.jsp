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
<th>City ID</th>
<th>City Name</th>

</tr> 
<a:forEach var = "pro" items="${data}">
<tr>
<td>${pro.cityId}</td>
<td>${pro.cityName}</td>

</tr>
</a:forEach>
</table>

</body>
</html>