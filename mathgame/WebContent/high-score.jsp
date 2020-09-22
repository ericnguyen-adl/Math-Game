<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top 10 High Scores</title>
<link type="text/css" rel="stylesheet" href = "css/mathsGame.css">
</head>
<body>
<h2 id = "highScoreMessage"> List 10 Highest Scores from all players: </h2>

<div id = "listHighScores">
	<table id = "myHighScoresTable"> 
		<tr>
			<th>UserName</th>
			<th>Score</th>
			<th>DateOfPlaying</th>		
		</tr>
		
		<c:forEach var="tempScore" items = "${HIGH_SCORE_LIST}">
		<tr>
			<td>${tempScore.userName}</td>
			<td>${tempScore.score}</td>
			<td>${tempScore.dateOfPlaying}</td>		
		</tr>		
		</c:forEach>	
	</table>
</div>
	
<div id="reloadForm">
	<form action="PlayerControllerServlet" method = "POST">		
			<input type = "hidden" name = "command" value = "RELOAD"/>			
			<input type = "submit" id = "reloadButton" value = "Return to my Math Game"/>
			<input type = "hidden" id = "currentUserName" name = "currentUserName" value = "${USER_NAME}">	
		</form>
</div>


</body>
</html>