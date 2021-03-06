<!DOCTYPE html>
<html>
<head>
<title>WeStudy - Children </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">


<%@ page import = "logic.model.bean.*" %>
<%@ page import = "logic.control.*" %>
<%@ page import = "java.util.List" %>


<script> 
function apri(url) { 
    newin = window.open(url,'titolo','scrollbars=no,resizable=yes, width=800,height=500,status=no,location=no,toolbar=no');
} 
</script>

</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-wide w3-padding w3-card-2">

    <div class="w3-right w3-hide-small">
  
      <a href="mainPageParent.jsp" class="w3-bar-item w3-button"> <b> <font color="gold"> Home </font> </b> </a>
      <a class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a href="meetingParent.jsp" class="w3-bar-item w3-button"> <b> Meeting </b> </a>
      <a class="w3-bar-item w3-button"> <b> Profile </b> </a>
      <a href="logout.jsp" class="w3-bar-item w3-button"> <b> Logout</b> </a>
      <%
      		String sessionId = (String)session.getAttribute("userId");    
			out.println("USER ID: " + sessionId);
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
    <!-- <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Materie</h3> -->
    
</div>

  <div class="w3-row-padding">
  
  <img class="w3-image" src="RESOURCES/images/classRegisterGrades_logo.png" alt="Grade" width="30%" height="100%">
    
    
    
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
  
    
    </div>
    
    
  </div>
<!-- End page content -->
</div>
<!-- Footer -->
<footer class="w3-center w3-black w3-padding-16">
  <p> Created by Adriano Trani & Simone Grillo</p>
</footer>
</body>
</html>