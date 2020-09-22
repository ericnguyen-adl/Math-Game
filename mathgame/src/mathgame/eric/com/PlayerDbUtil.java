package mathgame.eric.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PlayerDbUtil {

	private DataSource dataSource;

	public PlayerDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void registerPlayer(Player player) throws Exception {
		// TODO Auto-generated method stub
		Connection myConn = null; 
		PreparedStatement myStmt = null;			
		
		try {
			// Set up the connection 
			myConn = dataSource.getConnection(); 
			
			// Create the sql command to insert 
			String insertSQL = "INSERT INTO user(UserName, FirstName, LastName, PostCode, Email, Password, DateOfRegistration)" + 
					"Values (?, ?, ?, ?, ?, ?, ?)"; 
			
			myStmt = myConn.prepareStatement(insertSQL);
			
			// Set param value for SQL command 
			myStmt.setString(1, player.getUserName());
			myStmt.setString(2, player.getFirstName());
			myStmt.setString(3, player.getLastName());
			myStmt.setString(4, player.getPostCode());
			myStmt.setString(5, player.getEmail());
			myStmt.setString(6, player.getPassword());
			myStmt.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
			// execute the sql command 
			myStmt.execute(); 	
			
		} 
		finally {			
			myConn.close(); 
		}
		
	}

	public boolean checkLogIn(String userName, String password) throws Exception{
		// TODO Auto-generated method stub
		boolean resultCheck = false; 
		Connection myConn = null; 
		Statement myStmt = null; 
		ResultSet myRs = null; 
		
		try {
			// Create the connection 
			myConn = dataSource.getConnection(); 
			
			// Create the sql command 
			String mySql = "SELECT * FROM user"; 
			myStmt = myConn.createStatement(); 
			
			myRs = myStmt.executeQuery(mySql); 			
			
			// Compare userName and password with database 
			while(myRs.next()) {
				String playerUserName = myRs.getString("userName"); 
				String playerPassword = myRs.getString("password"); 
				if(playerUserName.equals(userName) && playerPassword.equals(password)) {
					resultCheck = true; 
					break; 					
				}
			}
			return resultCheck;
		} 
		finally {
			myConn.close(); 
		}	
		
		
	}

	public void save(String currentUserName, String score) throws Exception {
		Connection myConn = null; 
		PreparedStatement myStmt = null;			
		
		try {
			// Set up the connection 
			myConn = dataSource.getConnection(); 
			
			// Create the sql command to insert 
			String insertSQL = "INSERT INTO score(UserName, Score, DateOfPlaying)" + 
					"Values (?, ?, ?)"; 
			
			myStmt = myConn.prepareStatement(insertSQL);
			
			// Set param value for SQL command 
			myStmt.setString(1, currentUserName);
			myStmt.setString(2, score);	
			
			java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
			myStmt.setTimestamp(3, sqlDate);
			
			// execute the sql command 
			myStmt.execute(); 				
		} 
		finally {			
			myConn.close(); 
		}
		
	}

	public List<PlayerScore> listPlayerScore(String userName) throws Exception {
		// TODO Auto-generated method stub
		List<PlayerScore> scores = new ArrayList<>(); 
		Connection myConn = null; 
		PreparedStatement myStmt = null;
		ResultSet myRs = null; 
		
		try {
			// Get Connection
			myConn = dataSource.getConnection(); 
			
			// Create sql command 
			String sql = "SELECT * FROM score WHERE UserName = ?" ; 
			myStmt = myConn.prepareStatement(sql); 
			
			myStmt.setString(1, userName);
			
			// Execute the sql
			myRs = myStmt.executeQuery(); 
			
			// Add to array List
			while (myRs.next()) {
				String currentUserName = myRs.getString("UserName"); 
				int score = myRs.getInt("Score"); 
				String dateOfPlaying = myRs.getString("DateOfPlaying"); 
				
				PlayerScore playerScore = new PlayerScore(currentUserName, score, dateOfPlaying); 
				
				scores.add(playerScore); 				
				
			}
			
			return scores;
			
		} finally {			
			myConn.close(); 
		}		
		 
	}

	public List<PlayerScore> listHighScores() throws Exception {
		// TODO Auto-generated method stub
		List<PlayerScore> highScores = new ArrayList<>(); 
		Connection myConn = null; 
		Statement myStmt = null;
		ResultSet myRs = null; 
		
		try {
			// Get Connection
			myConn = dataSource.getConnection(); 
			
			// Create sql command 
			String sql = "SELECT * FROM score ORDER BY score DESC LIMIT 10" ; 
			myStmt = myConn.createStatement(); 
			
						
			// Execute the sql
			myRs = myStmt.executeQuery(sql); 
			
			// Add to array List
			while (myRs.next()) {
				String currentUserName = myRs.getString("UserName"); 
				int score = myRs.getInt("Score"); 
				String dateOfPlaying = myRs.getString("DateOfPlaying"); 
				
				PlayerScore playerScore = new PlayerScore(currentUserName, score, dateOfPlaying); 
				
				highScores.add(playerScore); 				
				
			}
			
			return highScores;
			
		} finally {			
			myConn.close(); 
		}
	}

	public boolean checkUserName(String userName) throws Exception {
		boolean resultCheck = false; 
		Connection myConn = null; 
		Statement myStmt = null; 
		ResultSet myRs = null; 
		
		try {
			// Create the connection 
			myConn = dataSource.getConnection(); 
			
			// Create the sql command 
			String mySql = "SELECT * FROM user"; 
			myStmt = myConn.createStatement(); 
			
			myRs = myStmt.executeQuery(mySql); 			
			
			// Compare userName and password with database 
			while(myRs.next()) {
				String playerUserName = myRs.getString("userName"); 
				
				if(playerUserName.equals(userName)) {
					resultCheck = true; 
					break; 					
				}
			}
			return resultCheck;
		} 
		finally {
			myConn.close(); 
		}
	} 		
	
}
