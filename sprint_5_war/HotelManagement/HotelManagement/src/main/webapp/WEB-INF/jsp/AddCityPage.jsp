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
Enter City Details

<table>
<fo:form id="addcityform" action="pagesubmitaddcitypage" modelAttribute="city" method="POST">
<tr>
<td>City Name </td>
<td><fo:input path="cityName" id="form_city_name" required="" /> </td>
<td><span class="form_error" id="cityname_error_message" style="color:red;"></span></td>
</tr>

<tr>
<td><input type= "submit" value="Add City" id="submit" />
</tr>

</fo:form>

</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>


<script type="text/javascript">

$(function(){
	$("#cityname_error_message").hide();
	var error_cityname=false;
	$("#form_city_name").focusout(function(){
	check_cityname();
	});
	function check_cityname()
	{
	var pattern=/^[A-Za-z]*$/;
	var cityname=$("#form_city_name").val();
	if(pattern.test(cityname) && cityname!=='')
	{
	$("#cityname_error_message").hide();
	$("#form_city_name").css("border-bottom","2px solid #34FA58");
	}
	else if(cityname=='')
	{
	$("#cityname_error_message").html("should not be empty");
	$("#cityname_error_message").show();
	$("#form_city_name").css("border-bottom","2px solid #F90A0A");
	error_cityname=true;
	}
	else
	{
	$("#cityname_error_message").html("should contain alphabets only");
	$("#cityname_error_message").show();
	$("#form_city_name").css("border-bottom","2px solid #F90A0A");
	error_cityname=true;

	}
	}
	$("#addcityform").submit(function(){
	error_cityname=false;
	check_cityname();
	if(error_cityname===false)
	{
	//alert("Added city successfully");
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
