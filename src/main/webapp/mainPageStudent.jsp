<!DOCTYPE html>
<html>
<head>
<title>WeStudy - MainPage Student</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">


<%@ page import = "logic.model.bean.*" %>
<%@ page import = "logic.control.*" %>
<%@ page import = "java.util.List" %>

<script>
function ShowHide(id){
 if(document.getElementById){
  var el=document.getElementById(id);
  el.style.display = (el.style.display=="block") ? "none" : "block";
 }
}
</script>

</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-wide w3-padding w3-card-2">
  
    <div class="w3-right w3-hide-small">
  
      <a href="mainPageStudent.jsp" class="w3-bar-item w3-button"> <b> <b> <font color="gold"> Home </font></b> </a>
      <a class="w3-bar-item w3-button"> <b> Material </b> </a>
      <a class="w3-bar-item w3-button"> <b> Question </b> </a>
      <a class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a class="w3-bar-item w3-button"> <b> Profile </b> </a>
      <a href="logout.jsp" class="w3-bar-item w3-button"> <b> Logout</b> </a>
      <%
      		String sessionId = (String)session.getAttribute("userId");
      		String sessionRole = (String)session.getAttribute("userRole");  
			out.println("USER: " + sessionId + " " + sessionRole);
	  %>
      
    </div>
  </div>
</div>
<!-- Header -->

<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
    </h1>
  </div>
</header>
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
  <!-- Project Section -->

<hr>
<hr>
<hr>
	
<div class="w3-container w3-padding-32" id="projects">
    <img class="w3-image" src="RESOURCES/images/grades_logo.png" alt="Your Grades" width="30%" height="100%">
    
    
    
    <table border="2">
				<tr>
					<td bgcolor="Gold"> <b> Course </b> </td>
					<td bgcolor="Gold"> <b> Grade </b> </td>
					<td bgcolor="Gold"> <b> Type </b> </td>
					<td bgcolor="Gold"> <b> Description </b> </td>
					<td bgcolor="Gold"> <b> Date </b> </td>		
				</tr>
				
				
				<%
					String strSessionId = (String)session.getAttribute("userId");
					Integer intSessionId = Integer.parseInt(strSessionId);
					UserBean studentBean = new UserBean(intSessionId);
					
					ViewStudentCareer gradeController = new ViewStudentCareer();
					List<ExtendedGrade> grades = gradeController.getExtendedStudentCareer(studentBean);
					
					for(int i=0 ; i<grades.size() ; i++){
					
				%>
				<tr>
				
				<td>
				<%
					out.println(grades.get(i).getCoursename());
				%>
				</td>
				
				<td>
				<%
					out.println(grades.get(i).getMark());
				%>
				</td>
				
				<td>
				<%
					out.println(grades.get(i).getType());
				%>
				</td>
				
				<td>
				<%
					out.println(grades.get(i).getDescription());
				%>
				</td>
				
				<td>
				<%
					out.println(grades.get(i).getDatabaseDate());
				%>
				</td>
				
				
				</tr>
				<%
					}
				%>
				
			</table>
    
</div>

  <div class="w3-row-padding">
  

    <hr> 
  		<div class="w3-display-middle w3-margin-top w3-center">  
  		</div>
        
</header>
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
  <!-- Project Section -->
  
  
  <img class="w3-image" src="RESOURCES/images/classRegisterAssignment_logo.png" alt="Your Assignment"  width="30%" height="100%">
  
  <table border="2">
				<tr>
					<td bgcolor="Gold"> <b> Course </b> </td>
					<td bgcolor="Gold"> <b> Type </b> </td>
					<td bgcolor="Gold"> <b> Description </b> </td>
					<td bgcolor="Gold"> <b> Creation Date </b> </td>
					<td bgcolor="Gold"> <b> Deadline Date </b> </td>		
				</tr>
				
				<%
					ViewAssignment assignmentController = new ViewAssignment();
					List<ExtendedAssignment> assignments =  assignmentController.viewAssignmentStudent(studentBean);
					
					
					
						for(int i=0 ; i<assignments.size() ; i++){
					
				%>
				<tr>
				
				<td>
				<%
						out.println(assignments.get(i).getCourseName());
				%>
				</td>
				
				
				<td>
				<%
						out.println(assignments.get(i).getType());
				%>
				</td>
				
				<td>
				<%
						out.println(assignments.get(i).getDescription());
				%>
				</td>
				
				<td>
				<%
						out.println(assignments.get(i).getCreationDate());
				%>
				</td>
				
				
				<td>
				<%
						out.println(assignments.get(i).getDeadlineDate());
				%>
				</td>
				
				
				</tr>
				<%
						}
					
				%>
				
			</table>
				
				
			</table>
  
  <div class="w3-container w3-padding-32" id="projects">
    <!-- <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16"> Learn More </h3> -->
  </div>
</div>
<div class="w3-row-padding">
    <div class="w3-col l3 m6 w3-margin-bottom">
    </div>
</div>

    
  </div>
<!-- End page content -->
</div>
<!-- Footer -->
<footer class="w3-center w3-black w3-padding-16">
  <p> Created by Adriano Trani & Simone Grillo</p>
</footer>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->
</body>
</html>