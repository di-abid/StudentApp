<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%@ page isELIgnored="false" %> 
 <%@page import="com.student.dao.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<!-- <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script> -->
    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style type="text/css">

         .ui-widget-header,.ui-state-default, ui-button {
            background:#b9cd6d;
           border: 1px solid #b9cd6d;
            color: #FFFFFF;
            font-weight: bold;
         }
</style>
<script type="text/javascript">
    function crunchifyAjax() {
    	var currentSem = $('#currentSem').val();
		var branch = $('#branch').val();				
		var data = 'currentSem='
				+ encodeURIComponent(currentSem)
				+ '&branch='
				+ encodeURIComponent(branch);
		//alert(data);
        $.ajax({
            url : 'getSemSubjects.std',
            //type : GET,
            data : data,
            success : function(response) {
                $('#semSubjectsDiv').html(response);
            }
        });
    }
    
    function getSubjectTextbooks(subjectCode){
    	//var subjectCode = $('#subcode').val();			
		var data = 'subjectCode='
				+ encodeURIComponent(subjectCode);
		//alert(data);
        $.ajax({
            url : 'getSubTextBooks.std',
            //type : GET,
            data : data,
            success : function(response) {
                $('#subTextBookDiv').html(response);
            }
        });
    }
    
    function getBookDetails(){
    	 $.ajax({
             url : 'getBookDetails.std',
             //type : GET,
             success : function(response) {
            	// $("#bookDetailsDiv").load(response);
            	 
            	 $('#bookDetailsDiv').html(response);
                 $( "#bookDetailsDiv" ).dialog({
                	 title:'Book Details',
                	 width:'500px',
                	 height:'auto',
                	/*  buttons: {
                         OK: function() {$(this).dialog("close");}
                      }, */
                	 autoOpen: false,
                	 model:true});
                // $('#mainDiv').css('display','none');
                 $('#bookDetailsDiv').css('display','block');
                 $('#bookDetailsDiv').css('background-color','#1ABC9C');
                 $( "#bookDetailsDiv" ).dialog( 'open' );  
             }
    
         }); 
    	
    	 
    }
</script>
<link href="<c:url value="/resources/homepage_style.css" />" rel="stylesheet">
</head>
<% User userdto=(User)session.getAttribute("user"); 
   if(userdto == null){
	  request.getRequestDispatcher("/").forward(request, response);
   }
%>
     
<body style="background-image: url('/StudentApp/resources/bg_green.jpg');background-repeat: x;">
	<div style=""><%@ include file="header.jsp" %></div><br/>
	
	<div class="studentInfoDiv">
	<table width="100%">
		<tr>
				<td>Name : ${student.firstName} ${student.middleName } ${student.lastName } </td>
				<td>USN : ${user.userId}</td>
				<td>Branch : ${student.branch}</td>
				<td>Year/Sem : ${student.currentYear}/ ${student.currentSemester }</td>
				<td>Mobile : ${student.mobile}</td>
				<td>
				 <input type="hidden" id="currentSem" name="currentSem" value="${student.currentYear}"/>
				 <input type="hidden" id="branch" name="branch" value="${student.branch}"/>
				</td>
		</tr>
		</table>
	</div>
	<div id="mainDiv" style="display:block;">
	<table border="0">
			<!-- <tr>
			<td><input type="button" value="Get Sem Subjects" onclick="crunchifyAjax()" class="semSubBtn"/></td>
			</tr> -->
			<tr>
				<td valign="top">
					<div style="width: 350px; height:200px; overflow: auto; font: sans-serif; font-weight: normal;font-family:OpenSans;">
						<table width="100%"> 
						<tr><th colspan="3" style="background:#1ABC9C;color: white;">Alerts</th></tr>
						<tr><td>Pay your fees before end of this month.</td></tr>
						<tr><td>Register yourself in library to avail the text books.</td></tr>
						<tr><td>Exam time table will be out next week for this semester.</td></tr>
						<tr><td>Collect your ID Card from the administration office.</td></tr>
						</table>
					</div>
				</td>
				<td>
				<div id="semSubjectsDiv"  style="width: 350px; height:200px; overflow: auto;"></div>
				</td>
				<td>
				<div id="subTextBookDiv" style=""></div>
				</td>
			</tr>
	</table>
</div>
<div id="bookDetailsDiv" style="display:none;"></div>	
</body>
</html>