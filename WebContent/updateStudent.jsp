<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
<link href="<c:url value="/resources/homepage_style.css" />" rel="stylesheet">
</head>
<body style="background-image: url('/StudentApp/resources/bg_green.jpg');background-repeat: x;">
<div style="display:block;"><%@ include file="header.jsp" %></div>

<div>
	<table>
		<tr><td>
			<div id="wrapper">
		
		<fieldset>
                <legend>Update Student Details</legend>
          <form action="getStudentDetails.std" method="get">   
                <table>
                	<tr>
                	<td><input type="text" id="usn" name="usn" placeholder="Enter USN" style="width:250px;" value="${student.usn }"></td>
                	<td><input type="submit"  value="Get Student Details" style="width:250px;" class="semSubBtn"></td>
                	</tr>
                </table>
           </form>   
           <form action="saveStudent.std" method="post">
			<table>
				
				<tr>
					<!-- <td>Student USN:</td> -->
					<td></td>
					<!-- <td><input type="password" id="pw" name="password" placeholder="Password"></td> -->
					<td><input type="text" id="fn" name="firstName" placeholder="First Name" value="${student.firstName }"></td>
					<td><input type="text" id="mn" name="middleName" placeholder="Middle Name" value="${student.middleName }"></td>
					<td><input type="text" id="ln" name="lastName" placeholder="Last Name" value="${student.lastName}"></td>
				</tr>
				<tr>
					<!-- <td>Password</td> -->
					
					<td><input type="text" id="dob" name="dateOfBirth" placeholder="Date of Birth" value="${student.dateOfBirth }"></td>
					<td><input type="text" id="doj" name="dateOfJoin" placeholder="Date of Joining" value="${student.dateOfJoin}"></td>
					<td><input type="text" id="branch" name="branch" placeholder="Branch" value="${student.branch}"></td>
					<td><input type="text" id="mobile" name="mobile" placeholder="Mobile" value="${student.mobile}"></td>
				</tr>
				<tr>
					<!-- <td>Mobile</td> -->
					
					<td><input type="text" id="fatherName" name="fatherName" placeholder="Father Name" value="${student.fatherName }"></td>
					<td><input type="text" id="motherName" name="motherName" placeholder="Mother Name" value="${student.motherName }"></td>
					<td><input type="text" id="currentYear" name="currentYear" placeholder="Current Year" value="${student.currentYear }"></td>
					<td><input type="text" id="currentSemester" name="currentSemester" placeholder="Current Sem" value="${student.currentSemester}"></td>
				</tr>
				<tr>
					<!-- <td>Address</td> -->
					
					<td>
					<div class="small"><textarea rows="3" cols="20" name="address" placeholder="Address">
					${student.address}</textarea></div></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input type="submit" value="Update" class="semSubBtn"> </td>
					<td><input type="reset" value="Reset" class="semSubBtn"/></td>
				</tr>
				
			</table>
			</form>
			</fieldset>
		
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