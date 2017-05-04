import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Enum.TiposPiezas;
import Enum.tiposDeJuego;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static Gestor gestor = Gestor.getGestor();

	public static void main(String[] args) throws IOException {
		menu();
	}

	static String readInput() throws java.io.IOException {
		String input;

		input = in.readLine();
		out.println();

		return input;
	}

	static void showMenu() {
		out.println();

		out.println("    -- MENÚ PRINCIPAL --    ");
		out.println("1. Crear jugador ");
		out.println("2. Escoger tipo de juego  ");
		out.println("3. ImprimirTablero ");
		out.println("4. Mover Piezas ");
		out.println("0. Salir ");
	}


	static void menu() throws java.io.IOException {

		boolean exit = false;
		String option;		

		while (!exit) {

			showMenu();
			option = readInput();
			
			switch(option){			

			case "1":
				createJugador();
				break;
			case "2":
				out.println("1- Ajedrez\n 2- Damas\n 3- Go  ");
				String tipoJuego = readInput();
				escogerJuego(tipoJuego);
				break;
			case "3":
				imprimirTablero();
				break;
			case "4":
				moverPiezas();
				break;
			case "0":
				exit = true;
				out.println("-- Hasta pronto --");
				break;
			default:
				out.println("-- Opcion invalida --");
				break;
			}
		}
	}

	static void createJugador() throws IOException {
		String pUsername, pEmail, pPassword;

		pUsername = getUsername();
		pEmail = getEmail();
		pPassword = getPassword();

		gestor.createJugador(pUsername, pEmail, pPassword);
		
		out.println("Jugador creado de manera exitosa");
	}

	static String getUsername() throws IOException {
		String username = "";
		
		out.println("Nombre de usuario: ");
		username = readInput();

		if(gestor.checkExists(username)){
			out.println("El usuario digitado ya existe.");
			getUsername();
		}
		return username;
	}

	static String getEmail() throws IOException {
		String email = "";
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather;

		out.println("E-mail: ");
		email = readInput();
		mather = pattern.matcher(email);
		
		if(!mather.find()){
			out.println("El formato del correo digitado es ivalido.");
			getEmail();
		}
		return email;
	}

	static String getPassword() throws IOException {
		String password = "";

		out.println("Contraseña: ");
		password = readInput();

			if(password.length() < 6){
				out.println("La contraseña debe tener minimo 6 caracteres.");
				getPassword();
			}
		return password;
	}

	public static void escogerJuego(String tipoJuego) {
		switch (tipoJuego) {
		case "1":
			gestor.enviarJuego(tiposDeJuego.ajedrez);
			break;
		case "2":
			gestor.enviarJuego(tiposDeJuego.damas);
			break;
		case "3":
			gestor.enviarJuego(tiposDeJuego.go);
			break;

		default:
			System.out.println("Opcion invalida");
			break;

		}
	}

	public static void imprimirTablero() {
		String[][] matriz = gestor.obtenerMatriz();
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[x].length; y++) {
				
				if (matriz[x][y] == null) {
					System.out.print("[  ]");
				} else {
					System.out.print(matriz[x][y]);
				}
				
			}
			if(x != 8){
				System.out.println(x);
			}
			
			//System.out.println(((6<=7)?x+" ":"")); 
			//System.out.println(" ");
			
		}
		
	}
	public static void moverPiezas() throws IOException{
		String salir = "";
		
	
		while(salir != "E"){
			imprimirTablero();
			System.out.println("Ingrese la posicion actual de la pieza y la coordenada a la cual quiere mover la pieza: ");
			String posicion = readInput();
			String[] posiciones = posicion.split(","); 
			String letraTablero = posiciones[0].substring(0,1).toUpperCase();
			int posActX = verificarLetra(letraTablero);
			String prueba;
			char posicionActual = posiciones[0].charAt(1);
			prueba =  String.valueOf(posicionActual);
			int posAct = Integer.valueOf(prueba);
			String letraTableroAMover = posiciones[1].substring(0,1).toUpperCase();
			int posMovX = verificarLetra(letraTableroAMover);
			char posicionAMover = posiciones[1].charAt(1);
			prueba = String.valueOf(posicionAMover);
			int posAMov = Integer.valueOf(prueba);
			gestor.moverPiezas(posActX,posAct,posMovX,posAMov);
			
		}
	
	}
	public static int  verificarLetra(String letraTablero){
		
		switch (letraTablero) {
        case "A": return 0;
        case "B": return 1;
        case "C": return 2;
        case "D": return 3;
        case "E": return 4;
        case "F": return 5;
        case "G": return 6;
        case "H": return 7;
        default: System.out.print("Coordenada de letra incorrecta");
                 break;
		}
		return 0;
	
	}
}
