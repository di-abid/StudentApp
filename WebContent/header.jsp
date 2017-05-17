<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="f" %>
 <%@ page isELIgnored="false" %> 
<div style="background:#76b852; color:white;display: block;">
	
	<table width="100%">
		<tr><td align="center">RYMEC Student Application</td></tr>
		<tr><td align="right">Welcome ${user.userId } </td></tr>
		<tr><td align="right">
			<div>
				<form action="logout.std">
					<input type="submit" value="Logout" class="semSubBtn"/>
				</form>
			</div>
		</td></tr>		
	</table>
	<table>
		<tr>
		
		<td>
		
		<input type="button"  onclick="location.href='home.std?user=${user.userId }'" value="Home" class="semSubBtn" ></td>
		<f:set var="userid" value="${user.userId }"></f:set>
		<f:if test="${userid == 'admin' }">
		<td><input type="button"  onclick="location.href='addStudent.std'" value="Add Student" class="semSubBtn" ></td>
		<td><input type="button"  onclick="location.href='updateStudent.std'" value="Update Student" class="semSubBtn" ></td>
		</f:if>
		<f:if test="${userid != 'admin' }">
		<td><input type="button" value="Get Curr Sem Subj" onclick="crunchifyAjax()" class="semSubBtn"/></td>
		</f:if>
		</tr>
	</table>
	
</div>
