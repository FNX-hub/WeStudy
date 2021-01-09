

<!DOCTYPE html>
<html>
<head>
<title> Login </title>



<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">
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
				
				<jsp:useBean id="LoginBean" scope="request" class="logic.control.LoginBean" />
				
				<% 
					if( logic.control.LoginBean.tryLogin(request.getParameter("insertedUsername") , request.getParameter("insertedPassword") ) == "Professor") 
					{
						out.println("Professor");
					}
					if( logic.control.LoginBean.tryLogin(request.getParameter("insertedUsername") , request.getParameter("insertedPassword") ) == "Student") 
					{
						out.println("Student");
					}
					if( logic.control.LoginBean.tryLogin(request.getParameter("insertedUsername") , request.getParameter("insertedPassword") ) == "Parent") 
					{
						out.println("Parent");
					}
					if( logic.control.LoginBean.tryLogin(request.getParameter("insertedUsername") , request.getParameter("insertedPassword") ) == "Error")
					{
						out.println("ERROR");
					}
				%>
				
				
				<% out.println( logic.control.LoginBean.nothing() ); %>
				

				
				<%! 
					public int somma (int primo, int secondo){
					return (primo + secondo); } 
				%>
				
				<%= somma (2,3)%>

				<button type="submit"  style="border-radius: 250px; class="btn btn-outline-dark"> Start </button>
		</div>
	</div>
</body>

</html>