<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math Game</title>
<link type="text/css" rel="stylesheet" href = "css/mathsGame.css">
</head>
<body>
<div id = "gameHeader">
	Welcome to Time Table Math Game for Kids! 
</div>
<div id = "container"> 
		<div id = "score">
			Score: <span id = "scorevalue">0</span>
		</div> 
		
		<div id = "welcome">
			Welcome, ${USER_NAME}.
		</div>
		
		<form action="PlayerControllerServlet" method = "POST">		
			<input type = "hidden" name = "command" value = "MY_SCORE"/>			
			<input type = "submit" id = "myScoreButton" value = "My Scores"/>
			<input type = "hidden" id = "currentUserName" name = "currentUserName" value = "${USER_NAME}">	
		</form>
		
		<form action="PlayerControllerServlet" method = "POST">		
			<input type = "hidden" name = "command" value = "HIGH_SCORE"/>			
			<input type = "submit" id = "highScoreButton" value = "High Scores"/>	
			<input type = "hidden" id = "currentUserName" name = "currentUserName" value = "${USER_NAME}">
		</form>
		
		<form action="PlayerControllerServlet" method = "POST">		
			<input type = "hidden" name = "command" value = "LOG_OUT"/>			
			<input type = "submit" id = "logOutButton" value = "Log out"/>	
		</form>
		
		<div id = "correct"> 
			Correct
		</div> 
		
		<div id = "wrong"> 
			Try again
		</div>
		
		<div id = "question">
		
		</div>
		
		<div id = "instruction">
			Click on the correct answer: 		
		</div>
		
		<div id = "choices">
			<div id = "box1" class = "box"> 
			</div>
			
			<div id = "box2" class = "box"> 
			</div>
			
			<div id = "box3" class = "box"> 
			</div>
			
			<div id = "box4" class = "box"> 
			
			</div>
		</div>
		
		
		<div id = "startreset"> 
			Start Game
		</div> 
		
		<div id = "timeremaining"> 
			Time Remaining: <span id = "timeremainingvalue"> 30 </span> sec
		</div> 
		
		<form action="PlayerControllerServlet" method = "POST" name = "saveForm" onsubmit = "save()">		
			<input type = "hidden" id = "saveValue" name = "command" value = "SAVE"/>			
			<input type = "submit" id = "saveButton" value = "Save Game"/>
			<input type = "hidden" id = "currentScore" name = "currentScore" value = ""/>
			<input type = "hidden" id = "currentUserName" name = "currentUserName" value = "${USER_NAME}">		
		</form>		
		<div id = "gameOver">			
		</div> 		
	</div>
	<script  type="text/javascript" src="js/mathsGame.js">
</script>

</body>
</html>