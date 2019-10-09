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
Enter Room Details

<table>
<fo:form action="pagesubmitaddroompage" modelAttribute="room" method="POST">
<tr>
<td>City Id</td>
<td><input type = "number" name = "cityid" /> </td>
</tr> 
<tr>
<td>Hotel Id</td>
<td><input type = "number" name = "hotelid" /> </td>
</tr> 
<tr>

<td>Room Type </td>
<td><fo:input path="roomType" /> </td>

</tr>
<tr>
<td>Room Rent</td>
<td><fo:input path="roomRent" /> </td>
</tr>
<tr>
<td>Room Number</td>
<td><fo:input path="roomNumber" /> </td>

</tr>





<tr>
<td><input type= "submit" value="Add Room" />
</tr>

</fo:form>
</table>
</body>
