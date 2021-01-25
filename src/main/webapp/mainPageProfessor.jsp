<!DOCTYPE html>
<html>
<head>
<title>WeStudy - MainPage Professor</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">

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
  
      <a href="mainPageProfessor.jsp" class="w3-bar-item w3-button"> <b> <font color="gold"> Home </font> </b> </a>
      <a href="professorMaterial.html" class="w3-bar-item w3-button"> <b> Material </b> </a>
      <a href="questions.html" class="w3-bar-item w3-button"> <b> Question </b> </a>
      <a href="events.html" class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a href="meeting.html" class="w3-bar-item w3-button"> <b> Meeting </b> </a>
      <a href="yourPage.html" class="w3-bar-item w3-button"> <b> Profile </b> </a>
      <a href="logout.php" class="w3-bar-item w3-button"> <b> Logout</b> </a>
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
    <img class="w3-image" src="RESOURCES/images/classes_logo.png" alt="Your Classes" width="30%" height="100%">
</div>

  <div class="w3-row-padding">
  
  <jsp:useBean id="ClassCourseConverter" scope="request" class="logic.model.bean.ClassCourseConverter" />
  
  <form action="classes.jsp" class="form-signin" id="login" role="form" method="post">
				<input type="username" class="form-control" name="insertedClassCourseId" id="insertedClassCourseId" placeholder="ClassCourseId" style="-webkit-border-radius: 50px;-moz-border-radius: 50px; border-radius: 50px;" required autofocus>
				<button type="submit"  style="border-radius: 250px; class="btn btn-outline-dark"> Show Selected Class </button>
			</form>
 
	</h3>
      </div>
    </div>
    

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