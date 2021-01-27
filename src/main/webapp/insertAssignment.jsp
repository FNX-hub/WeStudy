<!DOCTYPE html>
<html>
<head>
<title> Resume Insert Assignment </title>
	

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "logic.control.*" %>"
<%@ page import = "java.sql.Date" %>"
<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.text.SimpleDateFormat" %>"


</head>


<body background="RESOURCES/images/background_index_books.jpg" style="opacity:1.5" >
	<div class="w3-display-middle w3-margin-top w3-center"> 
		<div class="trani-container">			
				<h3 class="form-signin-heading"> 
					<img class="w3-image" src="RESOURCES/images/app_logo.png" alt="Immagine Header" width="60%" height="60%">  
				</h3>
				
					<table border = "2" >
					<tr>
					<td>
				<% 
					out.println("Type: ");
					out.println(request.getParameter("SelectAssignmentType"));
				%>
					</td>
					<td>
				<%
					out.println("Description: ");
					out.println(request.getParameter("SelectAssignmentDescription"));
				%>
					</td>
					</tr>
				
				<tr>
					<td>
				<% 
					out.println("Deadline: ");
					out.println(request.getParameter("SelectAssignmentDeadline"));
				%>
					</td>
					
					<td>
					
					<%
						String useCaseResult;
						
						String type = request.getParameter("SelectAssignmentType");
						String description = request.getParameter("SelectAssignmentDescription");
						String strDeadline = request.getParameter("SelectAssignmentDeadline");
						LocalDate deadline = LocalDate.parse(strDeadline);
						
						
						Integer courseId = Integer.parseInt(request.getParameter("SelectAssignmentCourse"));
						
						try{
						
							AssignmentBean assignmentBean = new AssignmentBean(type,description,deadline);
							ClassCourseBean courseBean = new ClassCourseBean(courseId);
							ManageClassAssignment controller = new ManageClassAssignment();
							controller.createAssignment(assignmentBean, courseBean);
							useCaseResult = "Assignment created with success";
						}
						catch(WrongDeclarationCustomException e){
							useCaseResult = "ERROR: deadline can not be before today date";
						}
						catch(NullPointerException e){
							useCaseResult = "ERROR: internal error";
						}
						
						
						out.println(useCaseResult);
					%>
					
					</td>
					
					</tr>
					
				
				
					<tr>
					<td>
					<a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Click Here to return to mainPage </b> </a>
					</td>
					
					
					
					
					
					</tr>
					</table>
		</div>
	</div>
</body>

</html>