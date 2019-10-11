<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="deletecitydata" method="post" id="deletecityform">
<table>
<tr>
<td>City Id
<td><input type = "number" name = "cityid" id="form_city_id" required="">
<td><span class="form_error" id="cityid_error_message" style="color:red;"></span></td>
</tr>
<tr>
<td><input type = "submit" value = "delete">

</tr>

</table>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>


<script type="text/javascript">
$(function(){
$("#cityid_error_message").hide();
var error_cityid=false;
$("#form_city_id").focusout(function(){
check_cityid();
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
$("#deletecityform").submit(function(){
error_cityid=false;
check_cityid();
if(error_cityid===false)
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