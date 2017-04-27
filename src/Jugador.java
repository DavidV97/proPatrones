
public class Jugador {
	private String username;
	private String email;
	private String password;
	
	public Jugador (String pUsername, String pEmail, String pPassword){
		setUsername(pUsername);
		setCorreo(pEmail);
		setPassword(pPassword);
	}

	private void setUsername(String pUsername) {
		this.username = pUsername;
	}
	
	private void setCorreo(String pEmail) {
		this.email = pEmail;
	}
	
	private void setPassword(String pPassword) {
		this.password = pPassword;
	}
	
	public String getUsername() {
		return username;
	}

	public String getCorreo() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	public String toString(){
		String result = "Username: " + this.username;
		result += "E-mail: " + this.email;
		result += "Password: " + this.password;
		return result;
	}

}
