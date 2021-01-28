<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "logic.control.*" %>
<%@ page import = "java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<title>WeStudy - Dynamic Classes Professor</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">
<style>

</style>

<script> 
function apri(url) { 
    newin = window.open(url,'titolo','scrollbars=no,resizable=yes, width=800,height=500,status=no,location=no,toolbar=no');
} 
</script>

</head>
<body >
<!-- Navbar (sit on top) -->

<div class="w3-top">
  <div class="w3-bar w3-black w3-wide w3-padding w3-card-2">  
    <!-- Float links to the right. Hide them on small screens -->
     <div class="w3-right w3-hide-small"> 
  
      <a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Home </b> </a>
      <a class="w3-bar-item w3-button"> <b> Material </b> </a>
      <a class="w3-bar-item w3-button"> <b> Question </b> </a>
      <a class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a href="meetingProfessor.jsp" class="w3-bar-item w3-button"> <b> Meeting </b> </a>
      <a class="w3-bar-item w3-button"> <b> Profile </b> </a>
      <a href="logout.jsp" class="w3-bar-item w3-button"> <b> Logout</b> </a>
      <% 
      		String sessionId = (String)session.getAttribute("userId");
			out.println("USER ID: " + sessionId);
	  %>
      
      
    </div>
  </div>
</div>



<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
  <!-- Project Section -->

<hr>
<hr>
<hr>
	


	<div class="w3-row-padding">  <!-- RIGA 0-->
	<img class="w3-image" src="RESOURCES/images/register_logo.png" alt="CLASS REGISTER" width="60%" height="100%">
	</div> <!-- FINE RIGA 0-->
				


	<div class="w3-row-padding">  <!-- RIGA 2-->

		<div class="w3-col l3 m6 w3-margin-bottom">
			 <div class="w3-display-container">
				
				
				
				
				<table padding = "10" > <!-- TABELLA COLOSSALE 1  -->
				
				<tr> <!-- TABELLA COLOSSALE 1  -->
				<td> <!-- TABELLA COLOSSALE 1  -->
				<img class="w3-image" src="RESOURCES/images/classRegisterGrades_logo.png" alt="Grades" width="60%" height="100%">
				</td> <!-- TABELLA 1 COLOSSALE CHE CONTIENE TUTTO -->
				<td> <!-- TABELLA 1 COLOSSALE -->
				<img class="w3-image" src="RESOURCES/images/classRegisterAssignment_logo.png" alt="Assignment" width="100%" height="100%">
				</td> <!-- TABELLA COLOSSALE 1  -->
				</tr> <!-- TABELLA COLOSSALE 1  -->
				
				<tr> <!-- TABELLA  COLOSSALE 1 -->
				<td> <!-- TABELLA  COLOSSALE 1 -->
				
				<%
					ClassCourseBean courseBean = new ClassCourseBean(Integer.parseInt((String)request.getParameter("insertedClassCourseId")));
					
					
					ManageStudentCareer gradeController = new ManageStudentCareer();
					List<ExtendedGrade> courseGrades =  gradeController.viewClassCourseGrades(courseBean);
					
				%>
				
				
				
				
				
				<table border="2" >
				<tr>
				<td bgcolor="Gold"> <b> Student Id </b> </td>
				<td bgcolor="Gold"> <b> Name </b> </td>
				<td bgcolor="Gold"> <b> Surname </b> </td>
				<td bgcolor="Gold"> <b> Grade </b> </td>
				<td bgcolor="Gold"> <b> Type </b> </td>
				<td bgcolor="Gold"> <b> Short description </b> </td>
				<td bgcolor="Gold"> <b> Received in</b> </td>
				</tr>
				
				<%
					
					for(int i=0 ; i<courseGrades.size() ; i++) {
				%>
					<tr>
					<td>
				<%
						out.print(courseGrades.get(i).getStudentId());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getStudentName());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getStudentSurname());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getMark());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getType());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getDescription());
				%>
					</td>
					<td>
				<%
						out.print(courseGrades.get(i).getDatabaseDate());
				%>
					</td>
					</tr>	
				<%
					}
				%>
				
				</table>
				
				
				
				</td> <!-- TABELLA COLOSSALE 1 -->
				
				<td> <!-- TABELLA COLOSSALE 1  -->
				
				<%
					ManageClassAssignment assignmentController = new ManageClassAssignment();
					List<ExtendedAssignment> courseAssignment = assignmentController.viewClassAssignment(courseBean);
				%>
				
				
				<table border="2" >
				<tr>
				<td bgcolor="Gold"> <b> Type </b> </td>
				<td bgcolor="Gold"> <b> Short Description </b> </td>
				<td bgcolor="Gold"> <b> Creation Date </b> </td>
				<td bgcolor="Gold"> <b> Event Date </b> </td>
				</tr>
				
				<%
					
					for(int i=0 ; i<courseAssignment.size() ; i++) {
				%>
					<tr>
					<td>
				<%
						out.print(courseAssignment.get(i).getType());
				%>
					</td>
					<td>
				<%
						out.print(courseAssignment.get(i).getDescription());
				%>
					</td>
					<td>
				<%
						out.print(courseAssignment.get(i).getCreationDate());
				%>
					</td>
					<td>
				<%
						out.print(courseAssignment.get(i).getDeadlineDate());
				%>
					</td>
					</tr>	
				<%
					}
				%>
				
				</table>
				
				
				
				
				</td> <!-- TABELLA COLOSSALE 1  -->
				</tr> <!-- TABELLA COLOSSALE 1  -->
				
				</table>
				
				<hr>
				<hr>
				<hr>
				
				<table padding = "10" > <!-- TABELLA COLOSSALE 2-->
				
				<tr> <!-- TABELLA COLOSSALE 2  -->
				
				
				<td> <!-- TABELLA COLOSSALE 2  -->
				
						<%
							RecoverClassCourseInformation studentsController = new RecoverClassCourseInformation();
							List<StudentBean> students = studentsController.viewClassCourseStudents(courseBean);
						%>
				
						<table  border="2" >
						
						<tr>
							<td bgcolor="Gold"> <b> Student Id </b> </td>
							<td bgcolor="Gold"> <b> Name </b> </td>
							<td bgcolor="Gold"> <b> Surname </b> </td>
							</tr>
						
						<% 
							for(int i=0 ; i<students.size() ; i++)
							{
						%>
						
						<tr>
						
						<td>
						<%
							out.print(students.get(i).getId());	
						%>
						</td>
						
						<td>
						<%
							out.print(students.get(i).getName());	
						%>
						</td>
						
						<td>
						<%
							out.print(students.get(i).getSurname());	
						%>
						</td>
						
						</tr>
						<%
							}
						%>
						</table>
				
				</td> <!-- TABELLA COLOSSALE 2  -->
				</tr> <!-- TABELLA COLOSSALE 2  -->
				</table> <!-- TABELLA COLOSSALE 2  -->
				
				
				<hr>
				<hr>
				<hr>
				
				<table padding = "10"> <!-- TABELLA COLOSSALE 3 -->
				<tr> <!-- TABELLA COLOSSALE 3 -->
				<td> <!-- TABELLA COLOSSALE 3 -->
				
				<!-- FORM GRADE -->
				
					<form action="insertGrade.jsp"> <table border="2" >
					
					<tr>
						<td bgcolor="Gold"> <b> Course </b> </td>
						<td bgcolor="Gold"> <b> Student </b> </td>
						<td bgcolor="Gold"> <b> Grade </b> </td>
						<td bgcolor="Gold"> <b> Type </b> </td>
						<td bgcolor="Gold"> <b> Description </b> </td>
					</tr>
				
					<tr>
					
						<td>
							<select name="SelectGradeCourse" size="1">
							<option>
							<%
								out.print(courseBean.getCourseId());
							%>
							</option>
							</select> 
						</td>
					
						<td> 
							<select name="SelectGradeStudent" size="1">
													
							
							<%							
								for(int i=0 ; i<students.size() ; i++){
							%>
								<option>
							<%
								out.print(students.get(i).getId());
							%>
								</option>
							<%
								out.print(students.get(i).getName());
								out.print(students.get(i).getSurname());
								}
							%>

							</select> 
						</td>

						<td> 
							<select name="SelectGrade" size="1">
							<option>0</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							</select> 
						</td>

						<td> 
							<select name="SelectGradeType" size="1">
							<option>WRITTEN</option>
							<option>ORAL</option>
							<option>PROJECT</option>
							</select> 
						</td>
						
						
						<td>
							<input type="text" name="SelectGradeDescription"> 
						</td>
						
						<!-- <input name="SelectCourse"> -->
						
						
						
				</tr>
				
				</table>
				<input type="submit" value="add" name="AddGradeButton" style="border-radius: 250px; class="btn btn-outline-dark">  </input>
				</form>
				
				
				
				</td> <!-- TABELLA COLOSSALE 3  -->
				
				<td> <!-- TABELLA COLOSSALE 3 -->
				
				<!-- FORM ASSIGNMENT -->
				
				<form action="insertAssignment.jsp"> <table border="2" >
				<tr>
					<td bgcolor="Gold"> <b> Course </b> </td>
					<td bgcolor="Gold"> <b> Type </b> </td>
					<td bgcolor="Gold"> <b> Description </b> </td>
					<td bgcolor="Gold"> <b> Deadline date </b> </td>
				</tr>
				
				<tr>
					<td>
						<select name="SelectAssignmentCourse" size="1">
						<option>
						<% out.print(courseBean.getCourseId()); %>
						</option>
						</select> 
					</td>
				
					<td> 
						<select name="SelectAssignmentType" size="1">
						<option>WRITTEN</option>
						<option>ORAL</option>
						<option>PROJECT</option>
						</select> 
					</td>				
				
					<td> 
						<input type="text" name="SelectAssignmentDescription"> 
					</td>
					
					<td>
						<input type="date" id="start" name="SelectAssignmentDeadline" value="2020-09-30" min="2000-01-01" max="2099-12-31">
					</td>
					
				</tr>
				
				</table>
				<input type="submit"  value="add" name="AddAssignmentButton" style="border-radius: 250px; class="btn btn-outline-dark"> </input>
				</form>
				
				
				</td> <!-- TABELLA COLOSSALE 3  -->
				</tr> <!-- TABELLA COLOSSALE 3  -->
				</table> <!-- TABELLA COLOSSALE 3  -->
				
				
				<hr>
				<hr>
				<hr>
				
				</form>
				
			 </div> 
		</div>

	</div> <!-- FINE RIGA 2 -->  


<!-- End page content -->

</div>   <!-- chiusura del div principale dopo header -->

<!-- Footer -->

<footer class="w3-center w3-black w3-padding-16">
  <p> Created by Adriano Trani & Simone Grillo</p>
</footer>

</body>
</html>