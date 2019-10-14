<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fo" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>

<body>
Welcome to the base

<table>
<fo:form action="login" method="Get">
<tr>
<td><input type= "submit" value="Login" />
</tr>
</fo:form>

<fo:form action="register" method="Get">
<tr>
<td><input type= "submit" value="Register" />
</tr>
</fo:form>


</table>

</body>
</html>