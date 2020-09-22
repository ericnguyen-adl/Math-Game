package mathgame.eric.com;

public class PlayerScore {
	private String userName; 
	private int score; 
	private String dateOfPlaying;
	public PlayerScore(String userName, int score, String dateOfPlaying) {
		super();
		this.userName = userName;
		this.score = score;
		this.dateOfPlaying = dateOfPlaying;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDateOfPlaying() {
		return dateOfPlaying;
	}
	public void setDateOfPlaying(String dateOfPlaying) {
		this.dateOfPlaying = dateOfPlaying;
	}
	@Override
	public String toString() {
		return "PlayerScore [userName=" + userName + ", score=" + score + ", dateOfPlaying=" + dateOfPlaying + "]";
	} 
	
	

}
