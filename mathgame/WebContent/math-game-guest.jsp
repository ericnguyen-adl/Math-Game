<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math Game for Guest</title>
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
		
		<div>
			<button onclick = "reloadRegistration()"  id = "registrationPage">Go to Registration Page</button> 	
		</div>
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
		
		<div id = "gameOver"> 
			
		</div> 
			
		
	</div>
	<script type="text/javascript" src="js/mathsGameGuest.js">
</script>

</body>
</html>