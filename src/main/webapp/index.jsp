<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<title> Login </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/stile.css">
<style>

.tranibutton {
  display: inline-block;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  height: 54px;
  position: relative;
  cursor: pointer;
  top: 0;
  left: 0;
  padding: 10px 20px;
  border: 0 none rgb(177,106,2);
  border-bottom: 4px solid rgb(177,106,2);
  -webkit-border-radius: 7px 7px 9px 9px;
  border-radius: 7px 7px 9px 9px;
  font: normal normal bold 24px/40px "Averia Sans Libre", Helvetica, sans-serif;
  color: rgb(255, 255, 255);
  text-align: center;
  text-transform: uppercase;
  -o-text-overflow: clip;
  text-overflow: clip;
  white-space: nowrap;
  background: -webkit-linear-gradient(-90deg, rgb(0,0,0) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  background: -moz-linear-gradient(180deg, rgb(253,218,134) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  background: linear-gradient(180deg, rgb(253,218,134) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  -webkit-background-origin: padding-box;
  background-origin: padding-box;
  -webkit-background-clip: border-box;
  background-clip: border-box;
  -webkit-background-size: auto auto;
  background-size: auto auto;
  -webkit-box-shadow: 0 -1px 1px 0 rgba(255,255,255,0.701961) inset, 0 1px 1px 0 rgb(177,106,2) ;
  box-shadow: 0 -1px 1px 0 rgba(255,255,255,0.701961) inset, 0 1px 1px 0 rgb(177,106,2) ;
  text-shadow: 0 1px 1px rgba(0,0,0,0.498039) ;
}

.tranibutton:hover {
  background: rgb(225, 157, 60);
  -webkit-transition: all 100ms cubic-bezier(0.42, 0, 0.58, 1);
  -moz-transition: all 100ms cubic-bezier(0.42, 0, 0.58, 1);
  -o-transition: all 100ms cubic-bezier(0.42, 0, 0.58, 1);
  transition: all 100ms cubic-bezier(0.42, 0, 0.58, 1);
}

.tranibutton:active {
  height: 50px;
  margin: 4px 0 0;
  border: none;
  -webkit-border-radius: 7px;
  border-radius: 7px;
  background: -webkit-linear-gradient(-90deg, rgb(253,218,134) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  background: -moz-linear-gradient(180deg, rgb(253,218,134) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  background: linear-gradient(180deg, rgb(253,218,134) 0, rgb(225,157,60) 100%), rgb(253, 218, 134);
  -webkit-background-origin: padding-box;
  background-origin: padding-box;
  -webkit-background-clip: border-box;
  background-clip: border-box;
  -webkit-background-size: auto auto;
  background-size: auto auto;
  -webkit-transition: all 30ms cubic-bezier(0.42, 0, 0.58, 1);
  -moz-transition: all 30ms cubic-bezier(0.42, 0, 0.58, 1);
  -o-transition: all 30ms cubic-bezier(0.42, 0, 0.58, 1);
  transition: all 30ms cubic-bezier(0.42, 0, 0.58, 1);
}

.trani-container {
border-radius: 10px;
margin-top: 25px;
margin-bottom: 25px;
/* margin: auto;*/
background-color:#FFFFFF;
/*border: 10px outset rgb(255,215,0); questo è buono*/
border: 3px    solid    rgb(0,0,0);
box-shadow:  10px  10px 5px #dedede, 
              -10px -10px 5px #dedede,
               10px -10px 5px #dedede,
              -10px  10px 5px #dedede;
overflow:auto;
}

</style>
</head>
<body background="RESOURCES/images/background_index_books.jpg" style="opacity:1.5" >
<!-- Header -->
<!-- <header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home"> -->
   <!-- <img class="w3-image" src="RESOURCES/images/Pergamena.png" alt="Immagine Header"  width="100%" height="100%"> -->
   <div class="w3-display-middle w3-margin-top w3-center"> 
    <div class="trani-container"> 
	<!-- <div class="row"> -->
    	<!-- <div class="trani-container" id="formContainer" > -->
          <form action="mainPage.html" class="form-signin" id="login" role="form" method="post">
            <h3 class="form-signin-heading"> 
            <img class="w3-image" src="RESOURCES/images/app_logo.png" alt="Immagine Header" width="60%" height="60%">  
            </h3>
            <input type="username" class="form-control" name="loginUser" id="loginUser" placeholder="Username" style="-webkit-border-radius: 50px;-moz-border-radius: 50px; border-radius: 50px;" required autofocus>
            <input type="password" class="form-control" name="loginPass" id="loginPass" placeholder="Password" style="border-radius: 50px;" required> <br> <br>
      <!--      <button class="tranibutton" type="submit" style="border-radius: 50px;"> Login </button> -->


		<button type="submit"  style="border-radius: 250px; class="btn btn-outline-dark"> Login </button>

          </form>
        </div> <!-- /container -->
        </div>
<!-- </div> -->
<!-- </div> -->
<!-- </header> -->
</body>
</html>
