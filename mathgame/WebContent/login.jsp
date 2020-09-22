<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math Game Log in</title>
<link type="text/css" rel="stylesheet" href="css/registrationForm.css">
</head>
<body>
<div id = "gameHeader">
	Welcome to Time Table Math Game for Kids! 
</div>

	<div id="fullForm">
		<form action="PlayerControllerServlet" method="POST" name="userForm">

			<fieldset>
				<legend class="legend">Log In:</legend>

				<input type="hidden" id="controlServlet" name="command"
					value="LOG_IN" />

				<div class="textBlockAlign">
					User Name: <input type="text" id="userName" name="userName"
						class="textBoxAlign" onfocus="changeBgd(this)"
						onblur="resetBgd(this)" /> <span class="colorChange"
						id="userNameError"> </span>
				</div>

				<div class="textBlockAlign">
					Password: <input type="password" id="password" name="password"
						class="textBoxAlign" onfocus="changeBgd(this)"
						onblur="resetBgd(this)" /> <span class="colorChange"
						id="passwordError"> </span>
				</div>

			</fieldset>

			<div class="buttonAlign">
				<input type="button" onclick="reloadRegistration()"
					value="Go to Registration Page" /> <input type="submit"
					value="Log in to Math Game" />

			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/registrationForm.js">
</script>

</body>
</html>