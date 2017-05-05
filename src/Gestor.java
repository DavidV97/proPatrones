import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

//import com.sun.org.apache.bcel.internal.generic.POP;

import ComunicacionManager.ComunicationManager;
import Enum.TiposPiezas;
import Enum.tiposDeJuego;
import Juegos.Ajedrez;
import Juegos.Tablero;
import PiezasDeJuego.Pieza;

public class Gestor {
	
	private static Gestor gestor = null;
	private Tablero tablero;
	private Ajedrez ajedrez = new Ajedrez();
	protected Gestor(){
		
	}
	
	public static Gestor getGestor(){
		if(gestor == null){
			gestor = new Gestor();
			filesDirection();
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
	
	public static void filesDirection(){
		Properties prop = new Properties();
		OutputStream output  = null;

		try {
			output  = new FileOutputStream("filesDirections.properties");
			
			// set the properties value
			prop.setProperty("workspace proPatrones Jugadores.txt", " Archivo de Jugadores");

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
	public void enviarJuego(tiposDeJuego tipoJuego){
		this.tablero = new Tablero(tipoJuego);
	}

	public String[][] obtenerMatriz(){
		return this.tablero.dibujarTablero();
	}

	public void moverPiezas(int posActX, int posAct, int posMovX, int posAMov){
		Pieza pieza;
		String[][] matriz = obtenerMatriz();
		int columnaAct = 0;
		int columnaAMover = 0;
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[x].length; y++) {
				if(matriz[x][y] != null){
					if(posActX == x && posAct == y ){
							columnaAct = x;
					}
					if(posMovX == x && posAMov == y){
						columnaAMover = x;
					}
				}
			}
		}
		ajedrez.moverPieza(posActX, posAct, posMovX, posAMov);
	}
}
