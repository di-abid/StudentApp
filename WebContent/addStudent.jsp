<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<link href="<c:url value="/resources/homepage_style.css" />" rel="stylesheet">
</head>
<body style="background-image: url('/StudentApp/resources/bg_green.jpg');background-repeat: x;">
<div style="display:block;"><%@ include file="header.jsp" %></div>

<div>
	<table>
		<tr><td>
			<div id="wrapper">
		<form action="saveStudent.std" method="post">
		<fieldset>
                <legend>Student Registration Form</legend>
			<table>
				<tr>
					<!-- <td>Student USN:</td> -->
					<td><input type="text" id="usn" name="usn" placeholder="Student USN"></td>
					<td><input type="password" id="pw" name="password" placeholder="Password"></td>
					<td><input type="text" id="fn" name="firstName" placeholder="First Name"></td>
					<td><input type="text" id="mn" name="middleName" placeholder="Middle Name"></td>
				</tr>
				<tr>
					<!-- <td>Password</td> -->
					<td><input type="text" id="ln" name="lastName" placeholder="Last Name"></td>
					<td><input type="text" id="dob" name="dateOfBirth" placeholder="Date of Birth"></td>
					<td><input type="text" id="doj" name="dateOfJoin" placeholder="Date of Joining"></td>
					<td><input type="text" id="branch" name="branch" placeholder="Branch"></td>
				</tr>
				<tr>
					<!-- <td>Mobile</td> -->
					<td><input type="text" id="mobile" name="mobile" placeholder="Mobile"></td>
					<td><input type="text" id="fatherName" name="fatherName" placeholder="Father Name"></td>
					<td><input type="text" id="motherName" name="motherName" placeholder="Mother Name"></td>
					<td><input type="text" id="currentYear" name="currentYear" placeholder="Current Year"></td>
				</tr>
				<tr>
					<!-- <td>Address</td> -->
					<td><input type="text" id="currentSemester" name="currentSemester" placeholder="Current Sem"></td>
					<td>
					<div class="small"><textarea rows="3" cols="20" name="address" placeholder="Address"></textarea></div></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input type="submit" value="Save"> </td>
					<td><input type="reset" value="Reset"/></td>
				</tr>
			</table>
			</fieldset>
		</form>
	</div>

	</table>
</div>
<div>
	<form:errors path="student.*"/>
</div>
<div>
	<h3>${StatusMessage}</h3>
</div>
		
</body>
</html>