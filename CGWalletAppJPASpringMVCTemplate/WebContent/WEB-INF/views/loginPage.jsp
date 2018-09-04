<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to Login Page!</h1>
		<div align="left">

			<table>

				<form:form action="getCustomer" method="post"
					modelAttribute="customer">

					<tr>
						<td>Mobile Number:</td>
						<td><form:input path="mobileNo" size="30" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit"></td>
					</tr>


				</form:form>

			</table>

		</div>

	</div>
</body>
</html>