<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
</head>
<body>
	<form:form action="updatehotelview" method="GET">
		<table>
			<tr>
				<td>Please enter City Id:</td>
				<td><input type="text" name="cityid" /></td>

			</tr>
			<tr>
				<td>Please enter Hotel Id:</td>
				<td><input type="text" name="hotelid" /></td>
				<td><input type="submit" value="Search">
			</tr>
		</table>
	</form:form>
	
	
	<h2>Update Hotels Details:</h2>
	<form:form action="updatehoteldata" method="POST"
		modelAttribute="hoteldata">
		<table>
			<tr>
				<td>Hotel Id</td>
				<td><form:input path="hotelId"
						value="${HotelData.hotelId}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Hotel Name</td>
				<td><form:input path="hotelName"
						value="${HotelData.hotelName}" /></td>
			</tr>
			<tr>
				<td>Hotel Address</td>
				<td><form:input path="hotelAddress"
						value="${HotelData.hotelAddress}" /></td>
			</tr>
			<tr>
				<td>Hotel Phone Number</td>
				<td><form:input path="hotelPhoneNumber"
						value="${HotelData.hotelPhoneNumber}" /></td>
			</tr>
			<tr>
				<td>Hotel Rating</td>
				<td><form:input path="hotelRating"
						value="${HotelData.hotelRating}" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Hotel"></input></td>
			</tr>
		</table>
	</form:form>

</body>
</html>