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
<body>
Enter Trainee Details

<table>
<fo:form action="pagesubmit" modelAttribute="trainee" method="POST">
<tr>
<td>Trainee Id </td>
<td><fo:input path="traineeId" /> </td>
<td><span><fo:errors path = "traineeId"></fo:errors></span></td>
</tr>

<tr>
<td>Trainee Name </td>
<td><fo:input path="traineeName" /> </td>
<td><span><fo:errors path = "traineeName"></fo:errors></span></td>
</tr>





<tr>
<td>Location  </td>
<td><fo:radiobutton path="traineeLocation" value = "Pune" />Pune
<td><fo:radiobutton path="traineeLocation" value = "Mumbai" />Mumbai 
<td><fo:radiobutton path="traineeLocation" value = "Banglore" />Bangalore
<td><fo:radiobutton path="traineeLocation" value = "Chennai" />Chennai
</tr>

<tr>
<td>Trainee Domain </td>
<td><fo:select path="traineeDomain" items="${dataitem}"  /> 
</tr>

<tr>
<td><input type= "submit" value="Add Trainee" />
<td><input type="reset" value = "Clear"> 
</tr>

</fo:form>
</table>
</body>
