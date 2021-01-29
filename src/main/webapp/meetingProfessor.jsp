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
    <img class="w3-image" src="RESOURCES/images/meeting_logo.png" alt="meeting" width="30%" height="100%">
</div>

  <div class="w3-row-padding">
  
	<table border="2">
				<tr>
					<td bgcolor="Gold"> <b> Parent ID </b> </td>
					<td bgcolor="Gold"> <b> Parent Surname </b> </td>
					<td bgcolor="Gold"> <b> Your ID </b> </td>
					<td bgcolor="Gold"> <b> Your Surname </b> </td>
					<td bgcolor="Gold"> <b> Date </b> </td>
					<td bgcolor="Gold"> <b> Message </b> </td>

				</tr>
				
				<%
					Integer intSessionId = Integer.parseInt((String)session.getAttribute("userId"));
					
					ManageMeetingControl meetingController = new ManageMeetingControl();
					List<MeetingBean> results = meetingController.getUserMeeting(intSessionId, UserType.PROFESSOR);
			
					for(int i=0 ; i<results.size() ; i++){
						
				%>
						<tr>
						<td>
				<%
						out.println(results.get(i).getParentId());
				%>
						</td>
						
						<td>
				<%
						out.println(results.get(i).getParentSurname());
				%>
						</td>
						<td>
				<%
						out.println(results.get(i).getProfessorId());
				%>
						</td>
						<td>
				<%
						out.println(results.get(i).getProfessorSurname());
				%>
						</td>
						<td>
				<%
						out.println(results.get(i).getDate());
				%>
						</td>
						
						<td>
				<%
						out.println(results.get(i).getMessage());
				%>
						</td>
						</tr>						
				<%
					}
				%>
				
		</table>
		
		<hr>
		
		<%
		RecoverUserInformation professorController = new RecoverUserInformation();
		List<UserBean> parentsId = professorController.getAllParent();
		%>
		
		<table border="2" >
		<td bgcolor="Gold"> <b> Parent ID </b> </td>
		<td bgcolor="Gold"> <b> Parent Surname </b> </td>
		<td bgcolor="Gold"> <b> Parent Name </b> </td>
		
		<%
		for(int i=0 ; i<parentsId.size() ; i++){
		%>
			<tr>
			<td>
		<%	out.println(parentsId.get(i).getId()); %>
			</td>
			<td>
		<%	out.println(parentsId.get(i).getSurname()); %>
			</td>
			<td>
		<%	out.println(parentsId.get(i).getName()); %>
			</td>			
			
			</tr>
		<%
		}
		%>
		</table>
		
		<hr>
		
		<form action="insertMeeting.jsp"> <table border="2" >
				<tr>
					<td bgcolor="Gold"> <b> ParentId </b> </td>
					<td bgcolor="Gold"> <b> Your ID </b> </td>
					<td bgcolor="Gold"> <b> Date </b> </td>
					<td bgcolor="Gold"> <b> Message </b> </td>
					<td bgcolor="Gold"> <b> Confirm? </b> </td>
					
				</tr>
				
				<tr>
				
					<td>
						
						<select name="SelectMeetingParentId" size="1">
						<%
							for(int i=0 ; i<parentsId.size() ; i++){
						%>
								<option>
								<% out.print(parentsId.get(i).getId()); %>
								</option>
						<%
							}
						%>
						</select> 
					</td>
				
					<td>
						<select name="SelectMeetingProfessorId" size="1">
						<option>
						<% out.print(intSessionId); %>
						</option>
						</select> 
					</td>
				
					
								
					
					<td>
						<input type="date" id="start" name="SelectMeetingDate" value="2020-09-30" min="2000-01-01" max="2099-12-31">
					</td>
					
					<td>
						<input type="text" name="SelectMeetingMessage"> 
					</td>
					
					<td>
						<select name="SelectMeetingConfirm" size="1">
						<option> yes </option>
						<option> no </option>
						</select>
					</td>
					
				</tr>
				
				</table>
				<input type="submit" value="Add" name="AddMeetingButton" style="border-radius: 250px; class="btn btn-outline-dark"> </input>
				</form>
		
		
    			<hr>
    			
    			
    			
    			<form action="removeMeeting.jsp"> <table border="2" >
    			
    			<tr>
					<td bgcolor="Gold"> <b> Parent ID / Your ID / Date </b> </td>
					
				</tr>
				
				<tr>
					<td>
					<select name="RemoveMeetingPk" size="1">
					<%
						for(int i=0 ; i<results.size() ; i++){
					%>
							<option>
							<% out.print(results.get(i).getParentId() + "," + results.get(i).getProfessorId() + "," + results.get(i).getDate()); %>
							</option>
					<%
						}
					%>
					</select> 
					</td>
				</tr>
				
    			</table> 
    			<input type="submit" value="Remove" name="RemoveMeetingButton" style="border-radius: 250px; class="btn btn-outline-dark"> </input>
    			</form>
    			
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