<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="<c:url value="/resources/loginpage_style.css" />" rel="stylesheet">
</head>
<body>
<div class="login-page">
	<div class="form">
	<form action="login.std" method="post" class="login-form">
		<input type="text" id="usn" name="usn" placeholder="USN"/>		
		<input type="password" id="password" name="password" placeholder="password"/>
		<input type="submit" value="Login" class="submit-class"/>
	</form>
	<div id="errorMsgDiv" class="message">
		<h3>${ ErrorMsg}</h3>
	</div>
	</div>
</div>
</body>
</html>