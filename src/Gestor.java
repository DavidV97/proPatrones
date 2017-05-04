import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.POP;

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
		ajedrez.moverPieza(columnaAct, posAct, columnaAMover, posAMov);
	}
}
