<%@page import="com.student.pojo.SemesterSubjects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@ page isELIgnored="false" %> 
 <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Semester Subjects</title>
<style type="text/css">
	tr.even { background: #F8F9F9; }
	tr.odd { background: #EAFAF1; }
</style>
</head>
<body>
<div class="" style="width: auto; height:200px;overflow: auto; font: sans-serif; font-weight:normal; font-family:OpenSans;">
	<table width="100%"> 
		<!-- <tr><th colspan="3">Semester Subjects</th></tr> -->
		<tr style="background:#1ABC9C;color: white;">
		<td align="center">Sem</td>
		<td align="center">Branch</td>
		<td align="center">Subject</td></tr>
		 <c:forEach items="${SemSubjects}" var="student" varStatus="studentLoop">
		 <tr class="${studentLoop.index % 2 == 0 ? 'even' : 'odd'}">
		  <td align="center">${student.semNo}</td>
		  <td align="center">${student.branch}</td>
		  <td align="left"><a href="#" onclick="getSubjectTextbooks('${student.subjectCode}')">${student.subject}</a>
		  	<input type="hidden" id="subcode" name="subcode" value="${student.subjectCode}"/>
		  </td>
         </tr>
</c:forEach> 
		
	</table>
	</div>
</body>
</html>