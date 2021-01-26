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
			<form action="resumeLogin.jsp" class="form-signin" id="login" role="form" method="post">
				<h3 class="form-signin-heading"> 
					<img class="w3-image" src="RESOURCES/images/app_logo.png" alt="Immagine Header" width="60%" height="60%">  
				</h3>
				<input type="username" class="form-control" name="insertedUsername" id="insertedUsername" placeholder="Username" style="-webkit-border-radius: 50px;-moz-border-radius: 50px; border-radius: 50px;" required autofocus>
				<input type="password" class="form-control" name="insertedPassword" id="insertedPassword" placeholder="Password" style="border-radius: 50px;" required> <br> <br>
				<button type="submit"  style="border-radius: 250px; class="btn btn-outline-dark"> Login </button>
			</form>
		</div>
	</div>
</body>

</html>
