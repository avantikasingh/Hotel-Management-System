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
<form action="showallroom" method="post" id="showroomform">
<table>
<tr>
<td>City Id
<td><input type = "number" name = "cityid" id="form_city_id" required=""></td>
<td><span class="form_error" id="cityid_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td>Hotel Id
<td><input type = "number" name = "hotelid" id="form_hotel_id" required="">
<td><span class="form_error" id="hotelid_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td><input type = "submit" value = "Search">

</tr>

</table>
</form>

<br><br>
<div>
<jsp:include page="ShowAllRooms.jsp"/>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">
$(function(){
$("#cityid_error_message").hide();
$("#hotelid_error_message").hide();
var error_cityid=false;
var error_hotelid=false;
$("#form_city_id").focusout(function(){
check_cityid();
});
$("#form_hotel_id").focusout(function(){
	check_hotelid();
});
function check_cityid()
{
var pattern=/^[0-9]*$/;
var cityid=$("#form_city_id").val();
if(pattern.test(cityid) && cityid!=='')
{
$("#cityid_error_message").hide();
$("#form_city_id").css("border-bottom","2px solid #34FA58");
}
else if(cityid=='')
{
$("#cityid_error_message").html("should not be empty");
$("#cityid_error_message").show();
$("#form_city_id").css("border-bottom","2px solid #F90A0A");
error_cityid=true;
}
else
{
$("#cityid_error_message").html("should contain only numeric vaues");
$("#cityid_error_message").show();
$("#form_city_id").css("border-bottom","2px solid #F90A0A");
error_cityid=true;

}
}
function check_hotelid()
{
var pattern=/^[0-9]*$/;
var hotelid=$("#form_hotel_id").val();
if(pattern.test(hotelid) && hotelid!=='')
{
$("#hotelid_error_message").hide();
$("#form_hotel_id").css("border-bottom","2px solid #34FA58");
}
else if(hotelid=='')
{
$("#hotelid_error_message").html("should not be empty");
$("#hotelid_error_message").show();
$("#form_hotel_id").css("border-bottom","2px solid #F90A0A");
error_hotelid=true;
}
else
{
$("#hotelid_error_message").html("should contain only numeric vaues");
$("#hotelid_error_message").show();
$("#form_hotel_id").css("border-bottom","2px solid #F90A0A");
error_hotelid=true;

}
}
$("#showroomform").submit(function(){
error_cityid=false;
error_hotelid=false;
check_cityid();
if(error_cityid===false && error_hotelid===false)
{
//alert("Added center successfully");
return true;
}
else
{
// alert("Please fill the form correctly");
return false;
}

});
});

</script>
</html>