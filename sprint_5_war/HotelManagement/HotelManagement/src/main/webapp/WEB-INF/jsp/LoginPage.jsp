<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>


</head>
<body>


	<div class="container">
		<form id="userform" class="col s6" action="/admin/login" method="post">


			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Username" type="text" name="username"
						required="required"> <label for="username">Username</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Password" type="password" name="password"
						required="required"> <label for="password">Password</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input type="submit" class="waves-effect waves-light btn"
						value="LOGIN"><br>
							  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
				</div>
			</div>
		</form>
		${errormessage }
	</div>

	
</body>
</html>