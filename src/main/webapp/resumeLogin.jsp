

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


</head>

<body background="RESOURCES/images/background_index_books.jpg" style="opacity:1.5" >
	<div class="w3-display-middle w3-margin-top w3-center"> 
		<div class="trani-container">			
				<h3 class="form-signin-heading"> 
					<img class="w3-image" src="RESOURCES/images/app_logo.png" alt="Immagine Header" width="60%" height="60%">  
				</h3>
				
				<% 
					out.println("Username: ");
					out.println(request.getParameter("insertedUsername"));
					out.println("Password: ");
					out.println(request.getParameter("insertedPassword"));
					out.println("Role: ");
				%>
				
				
				<% 
					String loginResult = logic.control.LoginControl.tryLogin(request.getParameter("insertedUsername") , request.getParameter("insertedPassword") );				 
					if(loginResult == "Professor")
					{
						out.println("Professor");
				%>
						<a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult == "Student") 
					{
						out.println("Student");
				%>
						<a href="mainPageStudent.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult == "Parent") 
					{
						out.println("Parent");
				%>						
						<a href="mainPageParent.jsp" class="w3-bar-item w3-button"> <b> Click Here to Start </b> </a>
				<%
					}
					if( loginResult == "NoUser")
					{
						out.println("ERROR: User not found");
				%>
					<a href="index.jsp" class="w3-bar-item w3-button"> <b> Click Here to retry to Login </b> </a>
				<%
					}
					if( loginResult == "WrongPassword")
					{
						out.println("ERROR: Incorrect password");
				%>
					<a href="index.jsp" class="w3-bar-item w3-button"> <b> Click Here to retry to Login </b> </a>
				<%
					}
				%>
		</div>
	</div>
</body>

</html>