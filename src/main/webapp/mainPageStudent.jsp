<!DOCTYPE html>
<html>
<head>
<title>WeStudy - MainPage Student Homeworks</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">


<%@ page import = "logic.model.bean.*" %>
<%@ page import = "logic.view.boundary.*" %>
<%@ page import = "java.util.List" %>

<script>
function ShowHide(id){
 if(document.getElementById){
  var el=document.getElementById(id);
  el.style.display = (el.style.display=="block") ? "none" : "block";
 }
}
</script>

</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-wide w3-padding w3-card-2">
  
    <div class="w3-right w3-hide-small">
  
      <a href="mainPageStudent.jsp" class="w3-bar-item w3-button"> <b> <b> <font color="gold"> Home </font></b> </a>
      <a href="studentMaterial.html" class="w3-bar-item w3-button"> <b> Material </b> </a>
      <a href="questions.html" class="w3-bar-item w3-button"> <b> Question </b> </a>
      <a href="events.html" class="w3-bar-item w3-button"> <b> Events </b> </a>
      <a href="yourPage.html" class="w3-bar-item w3-button"> <b> Profile </b> </a>
      <a href="logout.php" class="w3-bar-item w3-button"> <b> Logout</b> </a>
      
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
    <!-- <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Materie</h3> -->
    <img class="w3-image" src="RESOURCES/images/grades_logo.png" alt="Your Grades" width="30%" height="100%">
    
    
    
    <table border="2">
				<tr>
					<td bgcolor="Gold"> <b> placeholder </b> </td>
					<td bgcolor="Gold"> <b> placeholder </b> </td>
					<td bgcolor="Gold"> <b> placeholder </b> </td>
					<td bgcolor="Gold"> <b> placeholder </b> </td>
					<td bgcolor="Gold"> <b> placeholder </b> </td>		
				</tr>
				
				
				<%
				
				
					ViewStudentCareerStudent gradesBoundary = new ViewStudentCareerStudent();
					UserBean student = new UserBean(1);
					List<String> yourGrades = gradesBoundary.viewExtendedCareer(student);
				
					out.println("ID DELLO STUDENT HARDCODED PER ADESSO");				
					
					for(int i=0 ; i<yourGrades.size() ; i++){
						
				%>
						<tr>
						<td>
				<%
						out.println(yourGrades.get(i));
						i++;
				%>
						</td>
						<td>
				<%
						out.println(yourGrades.get(i));
						i++;
				%>
						</td>
						<td>
				<%
						out.println(yourGrades.get(i));
						i++;
				%>
						</td>
						<td>
				<%
						out.println(yourGrades.get(i));
						i++;
				%>
						</td>
						<td>
				<%
						out.println(yourGrades.get(i));
				%>
						</td>
						</tr>						
				<%
					}
				%>
				
			</table>
    
</div>

  <div class="w3-row-padding">
  
    QUI VISUALIZZIAMO GLI HOMEWORK DELLO STUDENTE

    <hr> 
  		<div class="w3-display-middle w3-margin-top w3-center">  </div>
        
</header>
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
  <!-- Project Section -->
  <table border="3" align="center">
        <tr>
        <td>
        	<table align="center">
            <tr>
            

            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Lunedi <hr> <a href=”#” onclick="ShowHide('hidden1');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Martedi <hr> <a href=”#” onclick="ShowHide('hidden2');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Mercoledi <hr> <a href=”#” onclick="ShowHide('hidden3');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Giovedi <hr> <a href=”#” onclick="ShowHide('hidden4');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Venerdi <hr> <a href=”#” onclick="ShowHide('hidden5');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            <td>
        	<div class="trani-polaroid">
        	<div class="trani-container">
            <img class="w3-image"  align="center"  src="RESOURCES/images/background_index_books.jpg" alt="Immagine Background Libri" width="130" height="200"> <br>
            </div>
            <h3> Sabato <hr> <a href=”#” onclick="ShowHide('hidden6');return(false)">Show More</a> </h3>
            </div>
            </td>
            
            </tr>
            </table>
            <table>
            <tr>
            <td> 
            <div id="hidden1" class="trani-div2"> 
L'Esclusa <br> 
“L’esclusa” è il primo romanzo pirandelliano. 
            </div> </td>
            <td> <div id="hidden2" class="trani-div2"> Il fu Mattia Pascal <br> 
entusiasmante che lo attende a casa.
            </div></td>
            <td> <div id="hidden3" class="trani-div2"> L'Umorismo <br> 
            Saggio che illustra la concezione Pirandelliana di umorismo, in particolare di come esso sia differente dal semplice brano comico.
            </div></td>
            <td> <div id="hidden4" class="trani-div2"> Cosi è (se vi pare) <br> 
            Opera teatrale ispirata alla novella di Pirandello: la signora Frola e il signor Ponza, suo genero. <br>
<strong> "Io sono colei che mi si crede" </strong> , non svelando a nessuno la sua vera identità.
            </div></td>
            <td> <div id="hidden5" class="trani-div2"> Novelle per un anno <br> 
            Raccolta di novelle (per un totale di 225) scritte da Pirandello. <br>
            Prevalentemente presentano tutte queste caratteristiche:
            <ul>
            <li> definiscono la vita come caotica e imprevedibile </li>
            <li> personaggi grotteschi e comici </li>
            <li> narrazione prevalentemente discorsiva </li>
            </ul>
            </div></td>
            <td> <div id="hidden6" class="trani-div2"> Sei personaggi in cerca d'autore <br> 
            Opera teatrale. <br>
            Su un palcoscenico una compagnia di attori prova la commedia 'Il giuoco delle parti' di Pirandello. <br>
            </div></td>
            <td> <div id="hidden7" class="trani-div2"> Uno, nessuno e centomila <br> 
            Romanzo. <br>
Inizialmente Vitangelo Moscarda (Gengé per gli amici) ci viene presentato come un uomo del tutto comune e normale, 
senza nessun tipo di angoscia né di tipo esistenziale né materiale: conduce una vita agiata e priva di problemi 
grazie alla banca (e alla connessa attività di usuraio) ereditata dal padre. 
            </div></td>
            </tr>
            </table>
            
            
        </td>
        </tr>
        </table>
  <div class="w3-container w3-padding-32" id="projects">
    <!-- <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16"> Learn More </h3> -->
  </div>
</div>
<div class="w3-row-padding">
    <div class="w3-col l3 m6 w3-margin-bottom">
    </div>
</div>

    
  </div>
<!-- End page content -->
</div>
<!-- Footer -->
<footer class="w3-center w3-black w3-padding-16">
  <p> Created by Adriano Trani & Simone Grillo</p>
</footer>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->
</body>
</html>