<!DOCTYPE html>
<html>
<head>
<title> Resume Login </title>



<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

<%@ page import = "logic.model.bean.*" %>
<%@ page import = "logic.view.boundary.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "logic.control.LoginControl" %>


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
					out.println("Username: ");
					out.println(request.getParameter("insertedUsername"));
				%>
					</td>
					</tr>
					<tr>
					<td>
				<%
					out.println("Role: ");
				%>
				
				<% 
					LoginControl controller = new LoginControl();
					LoginBean bean = new LoginBean(Integer.parseInt(request.getParameter("insertedUsername")),request.getParameter("insertedPassword"));
					String loginResult = controller.verifyUserWeb(bean);
					
					session.setAttribute("userId", request.getParameter("insertedUsername"));
					
					if(loginResult.equals("Professor"))
					{
						out.println(loginResult);
						String sessionId = (String)session.getAttribute("userId");  
						out.println("SESSION: " + sessionId);
				%>
						<a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult.equals("Student")) 
					{
						out.println(loginResult);
				%>
						<a href="mainPageStudent.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult.equals("Parent")) 
					{
						out.println(loginResult);
				%>						
						<a href="mainPageParent.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult.equals("ERROR"))
					{
						out.println("ERROR: uncorrected id/password");
					}
				%>
					</td>
					</tr>
					<tr>
					<td>
					<a href="index.jsp" class="w3-bar-item w3-button"> <b> Click Here to retry to Login </b> </a>
					</td>
					</tr>
					</table>
		</div>
	</div>
</body>

</html>