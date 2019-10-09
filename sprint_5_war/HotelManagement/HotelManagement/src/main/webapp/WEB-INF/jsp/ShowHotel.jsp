<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fo" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="showallhotel" method="post">
<table>
<tr>
<td>City Id
<td><input type = "number" name = "cityid">
</tr>
<tr>
<td><input type = "submit" value = "Search">

</tr>

</table>
</form>

<br><br>
<div>
<jsp:include page="ShowAllHotels.jsp"/>

</div>


</body>
</html>