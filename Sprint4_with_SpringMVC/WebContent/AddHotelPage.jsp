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
Enter Hotel Details

<table>
<fo:form action="pagesubmitaddhotelpage" modelAttribute="hotel" method="POST">
<tr>


<td>City Id</td>
<td><input type = "number" name = "cityid" /> </td>
</tr> 
<tr>
<td>Hotel Name </td>
<td><fo:input path="hotelName" /> </td>

</tr>
<tr>
<td>Hotel Address</td>
<td><fo:input path="hotelPhoneNumber" /> </td>
</tr>
<tr>
<td>Hotel Phone Number</td>
<td><fo:input path="hotelAddress" /> </td>

</tr>

<tr>
<td>Hotel Rating</td>
<td><fo:input path="hotelRating" /> </td>

</tr>



<tr>
<td><input type= "submit" value="Add Hotel" />
</tr>

</fo:form>
</table>
</body>
