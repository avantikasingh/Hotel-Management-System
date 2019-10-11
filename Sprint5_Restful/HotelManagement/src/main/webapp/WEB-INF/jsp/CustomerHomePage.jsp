<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome!


<table>
<fo:form action="viewHotelsPage"  method="post" modelAttribute="Booking">
<tr>
<td>Enter CheckIn Date</td>
<td><input type="date" name="checkIn"/></td>
</tr>
<tr>
<td>Enter CheckOut Date</td>
<td><input type="date" name="checkOut"/></td>
</tr>
<tr>
<td>Select City </td>
<td>
<select name="cityname">
<f:forEach var="city" items="${cityList }">
<option>${city.cityName}</option>
</f:forEach>
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="View Hotels"/>
</td>
</tr>

</fo:form>

</table>



</body>
</html>
