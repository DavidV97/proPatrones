import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Properties;

public class Gestor {
	
	private static Gestor gestor = null;
	
	protected Gestor(){
		
	}
	
	public static Gestor getGestor(){
		if(gestor == null){
			gestor = new Gestor();
		}
		return gestor;
	}
	
	public void createJugador(String pUsername, String pEmail, String pPassword){
		Jugador jugador = new Jugador(pUsername,pEmail,pPassword);
		Properties prop = new Properties();
		OutputStream fileInfoGamer = null;

		try {

			fileInfoGamer = new FileOutputStream("Jugadores.properties");

			// set the properties value
			prop.setProperty("Username", jugador.getUsername());
			prop.setProperty("Email", jugador.getCorreo());
			prop.setProperty("Password", jugador.getPassword());

			// save properties to project root folder
			prop.store(fileInfoGamer, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (fileInfoGamer != null) {
				try {
					fileInfoGamer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	  
	}
	
	public boolean checkExists(){
		return true;
	}
	
}
