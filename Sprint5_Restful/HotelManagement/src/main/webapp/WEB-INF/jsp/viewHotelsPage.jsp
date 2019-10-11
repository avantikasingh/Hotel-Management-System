<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style type="text/css">
body {
	background-color: #eeeeee;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

a {
	color: #212121;
}

.brand-logo {
	margin-left: 20px;
}

.card {
	margin-top: 10vh;
}

.input-field {
	margin-top: -5px;
}
</style>
</head>
<body>

	<!-- Header -->
	<nav>
		<div class="nav-wrapper grey darken-4">
			<a href="#" class="brand-logo"> <i class="large material-icons">hotel</i>Hotel
				Management System
			</a>
			
		</div>
	</nav>
	<!-- Header -->



	<script>
		
	</script>
	<fo:form action="BookingPage" method="post" >
		<table>
			<tr>
				<th>CheckIn Date</th>
				<td><input type="text" name="checkin" />${checkin}</td>
			</tr>
			<tr>
				<th>CheckOut Date</th>
				<td><input type="text" name="checkout" />${checkout}</td>
			</tr>
		</table>
		<table>
			<tr>
				<th>HOTEL ID</th>
				<th>HOTEL NAME</th>
				<th>HOTEL ADDRESS</th>
				<th>HOTEL RATING</th>
				<th>ROOM ID</th>
				<th>ROOM TYPE</th>
				<th>ROOM RENT</th>

			</tr>
			<f:forEach items="${AvailableRooms}" var="entry">
				<f:forEach items="${entry.value}" var="room">

					<tr>
						<td>${entry.key.hotelId}</td>
						<td>${entry.key.hotelName}</td>
						<td>${entry.key.hotelAddress}</td>
						<td>${entry.key.hotelRating}</td>
						<td>${room.roomId}</td>
						<td>${room.roomType}</td>
						<td>${room.roomRent}</td>

					</tr>
				</f:forEach>
			</f:forEach>
		</table>
		<br>
		<table>

			<tr>
				<th>Enter Details for Booking</th>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="cityName" />${cityName}</td>
			</tr>
			<tr>
				<td>Enter Hotel ID</td>
				<td><input type="text" name="hotelid" /></td>
			</tr>
			<tr>
				<td>Enter Room ID</td>
				<td><input type="text" name="roomid" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Make Booking" /></td>
			</tr>

		</table>
	</fo:form>

</body>
</html>