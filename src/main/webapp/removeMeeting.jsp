<!DOCTYPE html>
<html>
<head>
<title> Resume Insert Meeting </title>
	

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "logic.control.*" %>"
<%@ page import = "java.sql.Date" %>"
<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.text.SimpleDateFormat" %>"
<%@ page import = "java.util.StringTokenizer" %>"

</head>



<%
String useCaseResult;
						
String allParam = request.getParameter("RemoveMeetingPk");
StringTokenizer tokenizer = new StringTokenizer(allParam, ",");
						
Integer parentId = Integer.parseInt(tokenizer.nextToken());
Integer professorId = Integer.parseInt(tokenizer.nextToken());
String strDate = tokenizer.nextToken();
LocalDate date = LocalDate.parse(strDate);

%>

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
					out.println(parentId);
					
				%>
					</td>
					<td>
				<%
					
					out.println("Professor Id: ");
					out.println(professorId);
				%>
					</td>
					</tr>
				
				<tr>
					<td>
				<% 
					out.println("Date: ");
					out.println(date);
				%>
					</td>
					
					<td>
					
					<%
						
						try{							
							//Rimuovi dal database un meeting con queste PK
							MeetingBean bean = new MeetingBean(parentId,professorId,date,"");
							ManageMeetingControl controller = new ManageMeetingControl();
							controller.deleteMeeting(bean);
							useCaseResult = "Delete request sent";
						}
						catch(NullPointerException e){
							useCaseResult = "ERROR: internal error";
						}
						catch(WrongDeclarationCustomException e){
							useCaseResult = "ERROR: you can not remove a past meeting";
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