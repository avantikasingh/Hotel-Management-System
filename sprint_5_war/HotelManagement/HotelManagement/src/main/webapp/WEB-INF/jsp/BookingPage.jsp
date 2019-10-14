<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <style type="text/css">
    body{
  background-color: #eeeeee;
}
footer{
  position: absolute;
  bottom: 0;
  width: 100%;
}
a{
  color: #212121;
}
.brand-logo{
  margin-left: 20px;
}
.card{
  margin-top: 10vh;
}
.input-field{
	margin-top: -5px;
}
  </style>
</head>
<body>

<!-- Header -->
	<nav>
		<div class="nav-wrapper grey darken-4">
			<a href="#" class="brand-logo">
				<i class="large material-icons">hotel</i>Hotel Management System
			</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#">Log In</a></li>
				<li><a href="#">Sign Up</a></li>
			</ul>
		</div>
	</nav>
	<!-- Header -->
	
Booking Details

<table>

<tr>
<th>Booking Id</th>
<td>${booking.bookingId }</td>
</tr>



<tr>
<th>Check-In Date</th>
<td>${booking.checkIn }</td>
</tr>

<tr>
<th>Check-Out Date</th>
<td>${booking.checkOut }</td>
</tr>


<tr>
<th>City</th>
<td>${booking.cityName }</td>
</tr>

<tr>
<th>Hotel</th>
<td>${booking.hotelName }</td>
</tr>

<tr>
<th>Hotel Address</th>
<td>${booking.hotelAddress }</td>
</tr>

<tr>
<th>Hotel Contact No</th>
<td>${booking.hotelPhoneno }</td>
</tr>
<tr>
<th>Hotel Rating</th>
<td>${booking.hotelRating }</td>
</tr>
</table>

</body>
</html>