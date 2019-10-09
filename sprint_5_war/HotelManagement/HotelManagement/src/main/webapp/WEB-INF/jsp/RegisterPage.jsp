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
		<fo:form action="registerpage" modelAttribute="customer" method="POST">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>Email Id</td>
				<td><input type="text" name="emailId" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="userMobile" /></td>
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
</body>