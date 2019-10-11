<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Enter Details
	<table>
		<fo:form id="registerform" action="registerpage" modelAttribute="customer" method="POST">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" id="form_login_username" required=""/></td>
				<td><span class="form_error" id="username_error_message" style="color:red;"></span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="form_login_password"/></td>
				<td><span class="form_error" id="password_error_message" style="color:red;"></span></td>
			</tr>

			<!-- id="form_login_email" -->
			<tr>
				<td>Email Id</td>
				<td><input type="text" name="emailId" /></td>
				<!-- <td><span class="form_error" id="email_error_message" style="color:red;"></span></td> -->
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="userMobile" id="form_hotel_phone"/></td>
				<td><span class="form_error" id="hotelphone_error_message" style="color:red;"></span></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><fo:radiobutton path="gender" value="male" />Male
				<td><fo:radiobutton path="gender" value="female" />Female
			</tr>
			<tr>
				<td>Adhaar Number</td>
				<td><input type="text" name="aadharNumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register" />
			</tr>

		</fo:form>
	</table>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>

<!-- $("#email_error_message").hide();
 var error_email=false;
 $("#form_login_email").focusout(function(){
	check_email();
});

function check_email()
{	
var pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
var email=$("#form_login_email").val();
if(pattern.test(email) && cityid!=='')
{
$("#email_error_message").hide();
$("#form_login_email").css("border-bottom","2px solid #34FA58");
}
else if(email=='')
{
$("#email_error_message").html("should not be empty");
$("#email_error_message").show();
$("#form_login_email").css("border-bottom","2px solid #F90A0A");
error_email=true;
}
else
{
$("#email_error_message").html("Enter a valid email");
$("#email_error_message").show();
$("#form_login_email").css("border-bottom","2px solid #F90A0A");
error_email=true;
}
}
 
 -->


<script type="text/javascript">
$(function(){
$("#username_error_message").hide();
$("#password_error_message").hide();
$("#hotelphone_error_message").hide();
var error_username=false;
var error_password=false;
var error_hotelphone=false;
$("#form_login_username").focusout(function(){
check_username();
});
$("#form_login_password").focusout(function(){
check_password();
});
$("#form_hotel_phone").focusout(function(){
	check_hotelphone();
});
function check_username()
{	
var pattern=/^[0-9]*$/;
var cityid=$("#form_login_username").val();
var textbox = document.getElementById("form_login_username");
if(pattern.test(cityid) && cityid!=='' && textbox.value.length <= 10 && textbox.value.length >= 5)
{
$("#username_error_message").hide();
$("#form_login_username").css("border-bottom","2px solid #34FA58");
}
else if(cityid=='')
{
$("#username_error_message").html("should not be empty");
$("#username_error_message").show();
$("#form_login_username").css("border-bottom","2px solid #F90A0A");
error_username=true;
}
else if(textbox.value.length > 10 || textbox.value.length < 5){
	$("#username_error_message").html("should be between 5 and 10 characters");
	$("#username_error_message").show();
	$("#form_login_username").css("border-bottom","2px solid #F90A0A");
	error_username=true;
}
else
{
$("#username_error_message").html("should contain only numeric vaues");
$("#username_error_message").show();
$("#form_login_username").css("border-bottom","2px solid #F90A0A");
error_username=true;

}
}
function check_password()
{
var pattern=/^[A-Za-z]*$/;
var hotelname=$("#form_login_password").val();
var textbox = document.getElementById("form_login_password");
if(pattern.test(hotelname) && hotelname!=='')
{
$("#password_error_message").hide();
$("#form_login_password").css("border-bottom","2px solid #34FA58");
}
else if(hotelname=='')
{
$("#password_error_message").html("should not be empty");
$("#password_error_message").show();
$("#form_login_password").css("border-bottom","2px solid #F90A0A");
error_password=true;
}
else if(textbox.value.length > 10 || textbox.value.length < 5){
	$("#password_error_message").html("should be between 5 and 10 characters");
	$("#password_error_message").show();
	$("#form_login_password").css("border-bottom","2px solid #F90A0A");
	error_username=true;
}
else
{
$("#password_error_message").html("should contain string");
$("#password_error_message").show();
$("#form_login_password").css("border-bottom","2px solid #F90A0A");
error_password=true;

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
$("#registerform").submit(function(){
error_username=false;
error_password=false;
error_hotelphone=false;
check_username();
check_password();
check_hotelphone();
if(error_username===false && error_password===false && error_hotelphone===false)
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