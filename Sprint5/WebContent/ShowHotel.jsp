<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="show" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">

<head>
<title>Hotel Bookings</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<body>

	<!-- Body -->
	<div class="container center">
		<ul class="collection with-header">
			<li class="collection-header"><h4>Hotels</h4></li>
			<show:forEach var="pro" items="${data}">
				<li class="collection-item">
					<div class="row">
						Hotel Id: ${pro.hotelId} <br>
						Hotel Name: ${pro.hotelName}<br>
						Hotel Address: ${pro.hotelAddress}<br>
						Hotel Phone Number: ${pro.hotelPhoneNumber}<br>
						Hotel Rating: ${pro.hotelRating}<br>

					</div>
				</li>
			</show:forEach>
		</ul>
	</div>
	<!-- Body -->

</body>

</html>
