import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	
	public void createJugador(String pUsername, String pEmail, String pPassword) throws IOException{
		Jugador jugador = new Jugador(pUsername,pEmail,pPassword);
		
		try {
            FileWriter writer = new FileWriter("Jugadores.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Username= " + jugador.getUsername());
            bufferedWriter.newLine();
            bufferedWriter.write("Email= " + jugador.getEmail());
            bufferedWriter.newLine();
            bufferedWriter.write("Password= " + jugador.getPassword());
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            BufferedWriter out = new BufferedWriter(new FileWriter("Jugadores.txt"));
            createJugador(pUsername, pEmail, pPassword);
        }
	  
	}
	
	public boolean checkExists(String username){
		String line;
		
		try {
            BufferedReader bf = new BufferedReader(new FileReader("Jugadores.txt"));

            while (( line = bf.readLine()) != null){
                int indexfound = line.indexOf(username);

                if (indexfound > -1) {
                    return true;
                }
            }
            bf.close();
        }
        catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
        }
		return false;
	}
	
	public void filesDirection(){
		Properties prop = new Properties();
		OutputStream output  = null;

		try {
			output  = new FileOutputStream("filesDirections.properties");
			
			// set the properties value
			prop.setProperty("Archivo jugadores", "workspace" + "\\" + "proPatrones.");

			// save properties to project root folder
			prop.store(output , null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output  != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
}
