<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@ page isELIgnored="false" %> 
 <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	tr.even { background: #F8F9F9; }
	tr.odd { background: #EAFAF1; }
</style>
</head>
<body>

<div style="width: 450px; height:200px;overflow: auto; font: sans-serif; font-weight: normarl;font-family:OpenSans;">
	<table width="100%" border="0"> 
	
		<!-- <tr><th colspan="3">Prescribed Text Books</th></tr> -->
		<tr style="background:#1ABC9C; color: white;">
		<td align="center">ISBN</td>
		<td align="center">Book Name</td>
		<td align="center">Book Author</td></tr>
		 <c:forEach items="${subjectTextBooks}" var="book" varStatus="loop">
		 <tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
		  <td align="center">${book.isbn}</td>
		  <td align="left">${book.bookName}</td>
		  <td align="left">${book.bookAuthor}
		  <a href="#" onclick="getBookDetails()">click</a>
		  	<input type="hidden" id="subCode" name="subCode" value="${book.subCode}"/>
		  </td>
         </tr>
</c:forEach> 
		
	</table>
	</div>
	
</body>
</html>