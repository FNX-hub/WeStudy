<!DOCTYPE html>
<html>
<head>
<title>WeStudy - Meeting Professor</title>

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
<body >
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-wide w3-padding w3-card-2">  
    <!-- Float links to the right. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
  
      <a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b>  Home  </b> </a>
      <a class="w3-bar-item w3-button"> <b> Material </b> </a>
      <a class="w3-bar-item w3-button"> <b> Question </b> </a>
      <a class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a href="meetingProfessor.jsp" class="w3-bar-item w3-button"> <b> <font color="gold"> Meeting </font> </b> </a>
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
    	<img class="w3-image" src="RESOURCES/images/classes_logo.png" alt="Your Classes" width="30%" height="100%">
    	
    	
    	
			 <table border="2">
				<tr>
					<td bgcolor="Gold"> <b> Id </b> </td>
					<td bgcolor="Gold"> <b> CourseName </b> </td>
							
				</tr>
				
				<%
				
					Integer intSessionId = Integer.parseInt((String)session.getAttribute("userId"));
					UserBean professor = new UserBean(intSessionId);
					
					RecoverClassCourseInformation controller = new RecoverClassCourseInformation();
					List<ClassCourseBean> results = controller.getAllCourses(professor);					
					
					for(int i=0 ; i<results.size() ; i++){
						
				%>
						<tr>
						<td>
				<%
						out.println(results.get(i).getCourseId());
				%>
						</td>
						<td>
				<%
						out.println(results.get(i).getSubject());
				%>
						</td>
						</tr>						
				<%
					}
				%>
				
			</table>
			
			<hr>
			
			
			<form action="classes.jsp" class="form-signin" id="classChoice" role="form" method="post">
			
				<select name="insertedClassCourseId" size="1">
						
			<%
				for(int i=0 ; i<results.size() ; i++){
			%>
					
						<option>
							<%
								out.println(results.get(i).getCourseId());
							%>
						</option>
			<%
				}
			%>
				</select> 
			
				
				<button type="submit"  style="border-radius: 250px; class="btn btn-outline-dark"> Show Selected Class </button>
			</form> 
    	
	</div>

  <div class="w3-row-padding">
  
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