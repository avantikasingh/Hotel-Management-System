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
Enter User Name

<table>
<fo:form action="loginpage"  method="POST">
<tr>
<td>User Name
<td><input type = "text" name = "username">
</tr>
<tr>
<td>Password
<td><input type = "password" name = "password">
</tr>
<tr>
<td><input type= "submit" value="Login" />
</tr>
</fo:form>
</table>



</body>
</html>






