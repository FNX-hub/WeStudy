<!DOCTYPE html>
<html>
<head>
<title> Resume Insert Grade </title>
	

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "logic.control.*" %>"

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
					out.println("StudentID: ");
					out.println(request.getParameter("SelectGradeStudent"));
				%>
					</td>
					<td>
				<%
					out.println("Grade: ");
					out.println(request.getParameter("SelectGrade"));
				%>
					</td>
					</tr>
				
				<tr>
					<td>
				<% 
					out.println("Type: ");
					out.println(request.getParameter("SelectGradeType"));
				%>
					</td>
					<td>
				<%
					out.println("Description: ");
					out.println(request.getParameter("SelectGradeDescription"));
				%>
					</td>
					</tr>
				
				
					<tr>
					<td>
					<a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Click Here to return to mainPage </b> </a>
					</td>
					
					
					<td>
					
					<%
						String useCaseResult;
						
						try{
							Integer studentId = Integer.parseInt(request.getParameter("SelectGradeStudent"));
							Integer grade = Integer.parseInt(request.getParameter("SelectGrade"));
							String description = request.getParameter("SelectGradeDescription");
							Integer intClassCourse = Integer.parseInt(request.getParameter("SelectGradeCourse"));
							String type = request.getParameter("SelectGradeType");
							
							
							GradeBean gradeBean = new GradeBean(studentId, grade, description, intClassCourse , type);
							
							ManageStudentCareer controller = new ManageStudentCareer();
							controller.addGrade(gradeBean);
							
							useCaseResult = "Assignment added with success";
						}
						catch(WrongDeclarationCustomException e){
							useCaseResult = "ERROR: invalid parameters";
						}
						
						out.println(useCaseResult);
					%>
					
					</td>
					
					</tr>
					</table>
		</div>
	</div>
</body>

</html>