<!DOCTYPE html>
<html>
<head>
<title> Resume Insert Meeting </title>
	

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "logic.control.*" %>
<%@ page import = "java.sql.Date" %>
<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.ArrayList" %> 

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
					out.println("Parent Id: ");
					out.println(request.getParameter("SelectMeetingParentId"));
					out.println("Professor Id: ");
					out.println(request.getParameter("SelectMeetingProfessorId"));
				%>
					</td>
					<td>
				<%
					
					out.println("Message: ");
					out.println(request.getParameter("SelectMeetingMessage"));
				%>
					</td>
					</tr>
				
				<tr>
					<td>
				<% 
					out.println("Date: ");
					out.println(request.getParameter("SelectMeetingDate"));
				%>
					</td>
					
					<td>
					
					<%
						String useCaseResult;
						
						Integer parentId = Integer.parseInt(request.getParameter("SelectMeetingParentId"));
						Integer professorId = Integer.parseInt(request.getParameter("SelectMeetingProfessorId"));
						String strDate = request.getParameter("SelectMeetingDate");
						LocalDate date = LocalDate.parse(strDate);
						String message = request.getParameter("SelectMeetingMessage");
						String confirm = request.getParameter("SelectMeetingConfirm");
						
						
						
						try{
						
							MeetingBean bean = new MeetingBean(parentId,professorId,date,message);
							ManageMeetingControl control = new ManageMeetingControl();
							List<MeetingBean> meetingList = control.getUserMeeting(bean.getParentId(), UserType.PARENT);
							for(MeetingBean meeting : meetingList) {
								if(meeting.getParentId().equals(bean.getParentId()) && meeting.getDate().equals(bean.getDate()) && meeting.getProfessorId().equals(bean.getProfessorId())) {
									throw new WrongDeclarationCustomException("duplicate meeting");
								}
							}
							control.newMeeting(bean);
							if(confirm.equals("yes")) {
								bean.setConfirmed(true);
								useCaseResult = "Meeting created with success";
							}
							else {
								useCaseResult = "Error: Meeting not confirmed";
							}

						}
						catch(WrongDeclarationCustomException e){
							useCaseResult = "ERROR: you can not book a meeting for a past date or an already existing meeting";
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
					
					<%
      					String sessionRole = (String)session.getAttribute("userRole");  
						if(sessionRole.equals("Professor")){
					%>
						<a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Click Here to return to mainPage </b> </a>
					<%		
						}
						if(sessionRole.equals("Parent")){
					%>
						<a href="mainPageParent.jsp" class="w3-bar-item w3-button"> <b> Click Here to return to mainPage </b> </a>
					<%	
						}
					%>
					
					
					</td>
					
					
					
					
					
					</tr>
					</table>
		</div>
	</div>
</body>

</html>