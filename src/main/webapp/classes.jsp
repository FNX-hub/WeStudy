<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<title>WeStudy - Dynamic Classes Professor</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="RESOURCES/css/stile.css">
<style>

</style>

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
  
      <a href="mainPageProfessor.html" class="w3-bar-item w3-button"> <b> Home </b> </a>
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
<!-- UN INUTILE E INVISIBILE HEADER -->
</header>


<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
  <!-- Project Section -->

<hr>
<hr>
<hr>
	
	<!--
	<div class="w3-container w3-padding-32" id="projects">
    		<img class="w3-image" src="RESOURCES/images/classManager_logo.png" alt="Class Manager" width="50%" height="100%">
	</div>
	-->

	<div class="w3-row-padding">  <!-- RIGA 0-->
	<img class="w3-image" src="RESOURCES/images/register_logo.png" alt="CLASS REGISTER" width="60%" height="100%">
	</div> <!-- FINE RIGA 0-->
				
	<div class="w3-row-padding">  <!-- RIGA 1-->

		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<img class="w3-image" src="RESOURCES/images/classRegisterAbsences_logo.png" alt="Absences" width="60%" height="100%">
				<form> <table border="2" >
				<tr>
					<td bgcolor="Gold"> <b> #Num </b> </td>
					<td bgcolor="Gold"> <b> Name </b> </td>
					<td bgcolor="Gold"> <b> Surname </b> </td>
					<td bgcolor="Gold"> <b> Absence </b> </td>
				</tr>
				
				<tr>
					<td> SONO </td>
					<td> RIGA </td>
					<td> CREATA </td>
					<td> <input name="CheckboxC" type="checkbox"> (creato dinamicamente)</td>
				</tr>

				<tr>
					<td> SONO </td>
					<td> RIGA </td>
					<td> CREATA </td>
					<td> <input name="CheckboxC" type="checkbox"> (creato dinamicamente)</td>
				</tr>
				<tr>
					<td> SONO </td>
					<td> RIGA </td>
					<td> CREATA </td>
					<td> <input name="CheckboxC" type="checkbox"> (creato dinamicamente)</td>
				</tr>
				
				</table>
				<button> Send </button> 
				</form>
			</div>
		</div>

	</div> <!-- FINE RIGA 1 -->



	<div class="w3-row-padding">  <!-- RIGA 2-->

		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<img class="w3-image" src="RESOURCES/images/classRegisterGrades_logo.png" alt="Grades" width="60%" height="100%">
				<form> <table border="2" >
				<tr>
					<td bgcolor="Gold"> <b> Student </b> </td>
					<td bgcolor="Gold"> <b> Subject </b> </td>
					<td bgcolor="Gold"> <b> Grade </b> </td>
					<td bgcolor="Gold"> <b> Type </b> </td>
					<td bgcolor="Gold"> <b> Date </b> </td>
				</tr>
				
				<tr>
					<td> 
						<select name="SelectStudent" size="1">
						<option>DINAMICAMENTE</option>
						<option>dinamicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						<option>DINAmicamente</option>
						</select> 
					</td>

					<td> 
						<select name="SelectSubject" size="1">
						<option>DINAMICAMENTE</option>
						<option>dinamicamente</option>
						<option>DINAmicamente</option>
						</select> 
					</td>

					<td> 
						<select name="SelectGrade" size="1">
						<option>0</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						</select> 
					</td>

					<td> 
						<select name="SelectTestType" size="1">
						<option>Written Test</option>
						<option>Oral Test</option>
						<option>Project</option>
						</select> 
					</td>
					<td>
						<input type="date" id="start" name="trip-start" value="2020-09-30" min="2000-01-01" max="2030-12-31">
					</td>
					
				</tr>
				
				</table>
				<button> Send </button> 
				</form>
			</div>
		</div>

	</div> <!-- FINE RIGA 2 -->  


<!-- End page content -->

</div>   <!-- chiusura del div principale dopo header -->

<!-- Footer -->

<footer class="w3-center w3-black w3-padding-16">
  <p> Created by Adriano Trani & Simone Grillo</p>
</footer>

</body>
</html>