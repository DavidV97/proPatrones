
public class Jugador {
	private String username;
	private String email;
	private String password;
	
	public Jugador (String pUsername, String pEmail, String pPassword){
		setUsername(pUsername);
		setEmail(pEmail);
		setPassword(pPassword);
	}

	private void setUsername(String pUsername) {
		this.username = pUsername;
	}
	
	private void setEmail(String pEmail) {
		this.email = pEmail;
	}
	
	private void setPassword(String pPassword) {
		this.password = pPassword;
	}
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	public String toString(){
		String result = "Username: " + getUsername();
		result += "E-mail: " + getEmail();
		result += "Password: " + getPassword();
		return result;
	}

}
