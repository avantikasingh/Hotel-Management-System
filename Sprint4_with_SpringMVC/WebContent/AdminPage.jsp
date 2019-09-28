<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fo" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>

<body>
Choose Your Options Admin

<table>
<fo:form action="addhotel" method="Get">
<tr>
<td><input type= "submit" value="Add Hotel" />
</tr>
</fo:form>

<fo:form action="addcity" method="Get">
<tr>
<td><input type= "submit" value="Add City" />
</tr>
</fo:form>

<fo:form action="addroom" method="Get">
<tr>
<td><input type= "submit" value="Add Room" />
</tr>
</fo:form>

<fo:form action="deletecity" method="GET">
<tr>
<td><input type= "submit" value="Delete City" />
</tr>
</fo:form>

<fo:form action="deletehotel" method="GET">
<tr>
<td><input type= "submit" value="Delete Hotel" />
</tr>
</fo:form>

<fo:form action="deleteroom" method="GET">
<tr>
<td><input type= "submit" value="Delete Room" />
<td><input type="reset" value = "Clear"> 
</tr>
</fo:form>

<fo:form action="updatehotel" method="GET">
<tr>
<td><input type= "submit" value="Update Hotel" />
</tr>
</fo:form>

<fo:form action="updateroom" method="GET">
<tr>
<td><input type= "submit" value="Update Room" />
</tr>

</fo:form>
</table>

</body>
</html>