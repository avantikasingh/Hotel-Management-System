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
<fo:form id="addhotelform" action="pagesubmitaddhotelpage" modelAttribute="hotel" method="POST">
<tr>


<td>City Id</td>
<td><input id="form_city_id" type = "number" name = "cityid" required=""/> </td>
<td><span class="form_error" id="cityid_error_message" style="color:red;"></span></td>
</tr> 
<tr>
<td>Hotel Name </td>
<td><fo:input path="hotelName" id="form_hotel_name" required=""/>
<td><span class="form_error" id="hotelname_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td>Hotel Address</td>
<td><fo:input path="hotelAddress" id="form_hotel_address" required=""/> </td>
<td><span class="form_error" id="hoteladdress_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td>Hotel Phone Number</td>
<td><fo:input path="hotelPhoneNumber" id="form_hotel_phone" required=""/> </td>
<td><span class="form_error" id="hotelphone_error_message" style="color:red;"></span></td>
</tr>

<tr>
<td>Hotel Rating</td>
<td><fo:input path="hotelRating" id="form_hotel_rating" required="" /> </td>
<td><span class="form_error" id="hotelrating_error_message" style="color:red;"></span></td>

</tr>



<tr>
<td><input type= "submit" value="Add Hotel" />
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
$("#hotelname_error_message").hide();
$("#hoteladdress_error_message").hide();
$("#hotelphone_error_message").hide();
$("#hotelrating_error_message").hide();
var error_cityid=false;
var error_hotelname=false;
var error_hoteladdress=false;
var error_hotelphone=false;
var error_hotelrating=false;
$("#form_city_id").focusout(function(){
check_cityid();
});
$("#form_hotel_name").focusout(function(){
check_hotelname();
});
$("#form_hotel_phone").focusout(function(){
	check_hotelphone();
});
$("#form_hotel_rating").focusout(function(){
	check_hotelrating();
});
$("#form_hotel_address").focusout(function(){
	check_hoteladdress();
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
function check_hotelname()
{
var pattern=/^[A-Za-z]*$/;
var hotelname=$("#form_hotel_name").val();
if(pattern.test(hotelname) && hotelname!=='')
{
$("#hotelname_error_message").hide();
$("#form_hotel_name").css("border-bottom","2px solid #34FA58");
}
else if(hotelname=='')
{
$("#hotelname_error_message").html("should not be empty");
$("#hotelname_error_message").show();
$("#form_hotel_name").css("border-bottom","2px solid #F90A0A");
error_hotelname=true;
}
else
{
$("#hotelname_error_message").html("should contain string");
$("#hotelname_error_message").show();
$("#form_hotel_name").css("border-bottom","2px solid #F90A0A");
error_hotelname=true;

}
}
function check_hotelphone()
{
var pattern=/^[0]?[789]\d{9}$/;
var hotelphone=$("#form_hotel_phone").val();
if(pattern.test(hotelphone) && hotelphone!=='')
{
$("#hotelphone_error_message").hide();
$("#form_hotel_phone").css("border-bottom","2px solid #34FA58");
}
else if(hotelphone=='')
{
$("#hotelphone_error_message").html("should not be empty");
$("#hotelphone_error_message").show();
$("#form_hotel_phone").css("border-bottom","2px solid #F90A0A");
error_hotelphone=true;
}
else
{
$("#hotelphone_error_message").html("should contain only numeric vaues");
$("#hotelphone_error_message").show();
$("#form_hotel_phone").css("border-bottom","2px solid #F90A0A");
error_hotelphone=true;

}
}
function check_hotelrating()
{
var pattern=/^\d+(\.\d{1,2})?$/;
var hotelrating=$("#form_hotel_rating").val();
if(pattern.test(hotelrating) && hotelrating!=='' && hotelrating<5)
{
$("#hotelrating_error_message").hide();
$("#form_hotel_rating").css("border-bottom","2px solid #34FA58");
}
else if(hotelrating=='')
{
$("#hotelrating_error_message").html("should not be empty");
$("#hotelrating_error_message").show();
$("#form_hotel_rating").css("border-bottom","2px solid #F90A0A");
error_hotelrating=true;
}
else
{
$("#hotelrating_error_message").html("should contain only decimal values upto 2 digits less than 5");
$("#hotelrating_error_message").show();
$("#form_hotel_rating").css("border-bottom","2px solid #F90A0A");
error_hotelrating=true;

}
}
function check_hoteladdress()
{
var hoteladdress=$("#form_hotel_address").val();
if(hoteladdress!=='')
{
$("#hoteladdress_error_message").hide();
$("#form_hotel_address").css("border-bottom","2px solid #34FA58");
}
else
{
$("#hoteladdress_error_message").html("should not be empty");
$("#hoteladdress_error_message").show();
$("#form_hotel_address").css("border-bottom","2px solid #F90A0A");
error_hoteladdress=true;
}
}
$("#addhotelform").submit(function(){
error_cityid=false;
error_hotelname=false;
error_hoteladdress=false;
error_hotelphone=false;
error_hotelrating=false;
check_cityid();
check_hotelname();
check_hoteladdress();
check_hotelphone();
check_hotelrating()
if(error_cityid===false && error_hotelname===false && error_hoteladdress===false && error_hotelphone===false && error_hotelrating=false)
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
