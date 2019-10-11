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
<fo:form action="pagesubmitaddroompage" modelAttribute="room" method="POST" id="addroomform">
<tr>
<td>City Id</td>
<td><input type = "number" name = "cityid" id="form_city_id" required="" /> </td>
</tr> 
<tr>
<td>Hotel Id</td>
<td><input type = "number" name = "hotelid" id="form_hotel_id" required=""/> </td>
<td><span class="form_error" id="hotelid_error_message" style="color:red;"></span></td>
</tr> 
<tr>

<td>Room Type </td>
<td><fo:input path="roomType" /> </td>

</tr>
<tr>
<td>Room Rent</td>
<td><fo:input path="roomRent" id="form_room_rent" required=""/> </td>
<td><span class="form_error" id="roomrent_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td>Room Number</td>
<td><fo:input path="roomNumber" id="form_room_number" required="" /> </td>
<td><span class="form_error" id="roomnumber_error_message" style="color:red;"></span></td>
</tr>





<tr>
<td><input type= "submit" value="Add Room" />
</tr>

</fo:form>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">
$(function(){
$("#cityid_error_message").hide();
$("#hotelid_error_message").hide();
$("#roomrent_error_message").hide();
$("#roomnumber_error_message").hide();
var error_cityid=false;
var error_hotelid=false;
var error_roomrent=false;
var error_roomnumber=false;
$("#form_city_id").focusout(function(){
	check_cityid();
});
$("#form_hotel_id").focusout(function(){
	check_hotelid();
});
$("#form_room_rent").focusout(function(){
check_roomrent();
});
$("#form_room_number").focusout(function(){
check_roomnumber();
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
function check_roomrent()
{
var pattern=/^\d+(\.\d{1,2})?$/;
var roomrent=$("#form_room_rent").val();
if(pattern.test(roomrent) && roomrent!=='')
{
$("#roomrent_error_message").hide();
$("#form_room_rent").css("border-bottom","2px solid #34FA58");
}
else if(roomrent=='')
{
$("#roomrent_error_message").html("should not be empty");
$("#roomrent_error_message").show();
$("#form_room_rent").css("border-bottom","2px solid #F90A0A");
error_roomrent=true;
}
else
{
$("#roomrent_error_message").html("should contain only decimal values upto 2 digits");
$("#roomrent_error_message").show();
$("#form_room_rent").css("border-bottom","2px solid #F90A0A");
error_roomrent=true;

}
}
function check_roomnumber()
{
var roomnumber=$("#form_room_rent").val();
if(roomrent!=='')
{
$("#roomnumber_error_message").hide();
$("#form_room_number").css("border-bottom","2px solid #34FA58");
}
else(roomrent=='')
{
$("#roomnumber_error_message").html("should not be empty");
$("#roomnumber_error_message").show();
$("#form_room_number").css("border-bottom","2px solid #F90A0A");
error_roomnumber=true;
}
}
$("#addroomform").submit(function(){
error_cityid=false;
error_hotelid=false;
error_roomrent=false;
error_roomnumber=false;
check_cityid();
check_hotelid();
check_roomrent();
check_roomnumber();
if(error_cityid===false && error_hotelid===false && error_roomrent===false && error_roomnumber===false)
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
