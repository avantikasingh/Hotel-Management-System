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
Enter City Details

<table>
<fo:form action="pagesubmitaddcitypage" modelAttribute="city" method="POST">
<tr>
<td>City Name </td>
<td><fo:input path="cityName"  /> </td>
</tr>

<tr>
<td><input type= "submit" value="Add City" />
</tr>

</fo:form>
</table>
</body>
</html>