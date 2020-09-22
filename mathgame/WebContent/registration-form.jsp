<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link type="text/css" rel="stylesheet" href = "css/registrationForm.css">
</head>
<body>
<div id = "gameHeader">
	Welcome to Time Table Math Game for Kids! 
</div>
<div id = "fullForm">
	<form action = "PlayerControllerServlet" method = "POST" name = "userForm" onsubmit = "return validateForm()" >
		
		
		<fieldset>
			<legend class = "legend">Player details for Registration:</legend>
			
			<input type = "hidden" id = "controlServlet" name = "command" value = ""/>
			
			<div class = "textBlockAlign">
				User Name: <input type = "text" id = "userName" name="userName" class = "textBoxAlign" onfocus = "changeBgd(this)" onblur = "resetBgd(this)"/> <span class = "colorChange" id = "userNameError"> </span>
			</div>
			
			<div class = "textBlockAlign">
				First Name: <input type = "text" id = "firstName" name="firstName" class = "textBoxAlign" onfocus = "changeBgd(this)" onblur = "resetBgd(this)"/> <span class = "colorChange" id = "firstNameError"> </span>
			</div>
			<div class = "textBlockAlign">
				Last Name: <input type="text" class = "textBoxAlign" id = "lastName" name="lastName" onfocus = "changeBgd(this)" onblur= "resetBgd(this)"/> <span class = "colorChange" id = "lastNameError"> </span>
			</div>
			<div class = "textBlockAlign">
				Postcode: <input type="text" class = "textBoxAlign" id = "postCode" name="postCode" onfocus = "changeBgd(this)" onblur= "resetBgd(this)"/> <span class = "colorChange" id = "postCodeError"> </span>
			</div>
			<div class = "textBlockAlign">
				Email: <input type="text" class = "textBoxAlign" id = "email" name="email" onfocus = "changeBgd(this)" onblur = "resetBgd(this)"/> <span class = "colorChange" id = "emailError"> </span>
			</div>
			
			<div class = "textBlockAlign">
				Password: <input type = "password" id = "password" name="password" class = "textBoxAlign" onfocus = "changeBgd(this)" onblur = "resetBgd(this)"/> <span class = "colorChange" id = "passwordError"> </span>
			</div>
			
			<div class = "textBlockAlign">
				Re-enter password: <input type = "password" id = "reEnterPassword" class = "textBoxAlign" onfocus = "changeBgd(this)" onblur = "resetBgd(this)"/> <span class = "colorChange" id = "reEnterPasswordError"> </span>
			</div>			
		</fieldset>	
				
		<div class = "buttonAlign">			
			<input type = "submit" value = "Register as new player"/>
			<input type = "button" onclick = "logInToPlay()" value = "Already registered. Log in" />	
			<input type = "button" value = "Play as a guest" onclick = "playAsGuest()"/>	
								
		</div>		
		
		<div class = "buttonAlign">
			<input type = "button" onclick = "help()" value = "Help on registration"/>
		</div>
			
	</form>
	<div id = "thankyouMessages">
	</div>
</div>

<script  type="text/javascript" src="js/registrationForm.js">
</script>

</body>
</html>