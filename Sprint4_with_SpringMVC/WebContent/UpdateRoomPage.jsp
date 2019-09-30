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
	<form:form action="updateroomview" method="GET">
		<table>
			<tr>
				<td>Please enter City Id:</td>
				<td><input type="text" name="cityid" /></td>

			</tr>
			<tr>
				<td>Please enter Hotel Id:</td>
				<td><input type="text" name="hotelid" /></td>
			</tr>
			<tr>
				<td>Please enter room Id:</td>
				<td><input type="text" name="roomid" /></td>
				<td><input type="submit" value="Search">
			</tr>
		</table>
	</form:form>


	<h2>Update Hotels Details:</h2>
	<form:form action="updateroomdata" method="POST"
		modelAttribute="roomdata">
		<table>
			<tr>
				<td>Room Id</td>
				<td><form:input path="roomId" value="${RoomData.roomId}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td>Room Type</td>
				<td><form:input path="roomType" value="${RoomData.roomType}" /></td>
			</tr>

			<tr>
				<td>Room Rent</td>
				<td><form:input path="roomRent" value="${RoomData.roomRent}"/></td>
			</tr>
			<tr>
				<td>Room Number</td>
				<td><form:input path="roomNumber"
						value="${RoomData.roomNumber}" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Update Room"></input></td>
			</tr>
		</table>
	</form:form>

</body>
</html>