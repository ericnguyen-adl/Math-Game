package mathgame.eric.com;

public class Player {
	
	private String userName; 
	private String firstName; 
	private String lastName; 
	private String postCode; 
	private String email; 
	private String password;
	
	public Player(String userName, String firstName, String lastName, String postCode, String email, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postCode = postCode;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Player [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", postCode="
				+ postCode + ", email=" + email + ", password=" + password + "]";
	} 
	

}
