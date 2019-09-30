<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="deleteroomdata" method="post">
<table>
<tr>
<td>City Id
<td><input type = "number" name = "cityid">
</tr>

<tr>
<td>Hotel Id
<td><input type = "number" name = "hotelid">
</tr>

<tr>
<td>Room Id
<td><input type = "number" name = "roomid">
</tr>
<tr>
<td><input type = "submit" value = "delete">

</tr>

</table>
</form>


</body>
</html>