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

<<<<<<< HEAD
		out.println("    -- MENÚ PRINCIPAL --    ");
		out.println("1. Crear jugador ");
		out.println("2. Escoger tipo de juego  ");
		out.println("3. ImprimirTablero ");
		out.println("4. Mover Piezas ");
		out.println("5. Seleccionar jugadores para el juego");
		out.println("0. Salir ");
=======
		out.println("    -- MENï¿½ PRINCIPAL --    ");
		out.println("1.Crear jugador ");
		out.println("2.Escoger tipo de juego  ");
		out.println("3. imprimirTablero ");
		out.println("4. mover Piezas ");
>>>>>>> 2baac8260d6b867489cc1fe49d1ac415bb949f34
	}


	static void menu() throws java.io.IOException {

		boolean exit = false;
		String option;

		while (!exit) {

			showMenu();
			option = readInput();

			if (option.equals("1")) {
				createJugador();
			} else if (option.equals("2")) {
				out.println("1- Ajedrez\n 2- Damas\n 3- Go  ");
				String tipoJuego = readInput();
				escogerJuego(tipoJuego);

			} else if (option.equals("3")) {
				imprimirTablero();

			} else if (option.equals("4")) {
				moverPiezas();
<<<<<<< HEAD
				break;
			case "5":
				selecJugadores();
				break;
			case "0":
=======


			} else if (option.equals("0")) {
>>>>>>> 2baac8260d6b867489cc1fe49d1ac415bb949f34
				exit = true;
				out.println("-- Hasta pronto --");

			} else {
				out.println("-- Opcion invalida --");
				out.println();
			}
		}
	}

	static void createJugador() throws IOException {
		String pUsername, pEmail, pPassword;

		pUsername = getUsername();
		pEmail = getEmail();
		pPassword = getPassword();

		gestor.createJugador(pUsername, pEmail, pPassword);
	}

	static String getUsername() throws IOException {
<<<<<<< HEAD
		String username = ""; 
		
		out.println("Nombre de usuario: ");
		username = readInput();
=======
		String username = "";
		boolean reprobate = true;
>>>>>>> 2baac8260d6b867489cc1fe49d1ac415bb949f34

		while (reprobate) {
			out.println("Nombre de usuario: ");
			username = readInput();
			if (username != null && username != "" && gestor.checkExists(username)) {
				reprobate = false;
			}
		}
		return username;
	}

	static String getEmail() throws IOException {
		String email = "";
		boolean reprobate = true;
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather;

		while (reprobate) {
			out.println("E-mail: ");
			email = readInput();
			mather = pattern.matcher(email);
			if (email != null && email != "" && mather.find()) {
				reprobate = false;
			}
		}
		return email;
	}

	static String getPassword() throws IOException {
		String password = "";
		boolean reprobate = true;

		while (reprobate) {
			out.println("Contraseï¿½a: ");
			password = readInput();
			if (password != null && password != "") {
				reprobate = false;
			}
		}
		return password;
	}
	
	static void selecJugadores() throws IOException{
		String username1,username2;
		
		if(gestor.getQuanJug() > 0){
			out.println(gestor.getDBJugadores());
			out.println("Digite el nombre de usuario del jugador 1");
			username1 = readInput();
			out.println("Digite el nombre de usuario del jugador 2");
			username2 = readInput();
			if(gestor.checkExists(username1)){
				if(gestor.checkExists(username2)){
					gestor.setJugador(username1,username2);
					out.println("Jugadores seleccionados de manera exitosa.");
				}else{
					out.println("El nombre del jugador 2 no existe, intente otra vez.");
					selecJugadores();
				}
			}else{
				out.println("El nombre del jugador 1 no existe, intente otra vez.");
				selecJugadores();
			}
		}else{
			out.println("Primero debe de crear jugadores.");
		}
	}
	
//	static String getJugSelect() throws IOException{
//		String jugSelect;
//		out.println("1- Jugador\n 2- Jugador\n");
//		out.println("1- Jugador\n 2- Jugador\n");
//		String option = readInput();		
//			
//		switch(option){			
//
//		case "1":
//			jugSelect = "jug1";
//			break;
//		case "2":
//			jugSelect = "jug2";
//			break;
//		default:
//			out.println("-- Opcion invalida --");
//			break;
//		}
//		
//		return jugSelect;
//	}

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
			String letraTablero = posiciones[1].substring(0,1).toUpperCase();
			int posActY = verificarLetra(letraTablero);
			String prueba;
			char posicionActual = posiciones[0].charAt(1);
			prueba =  String.valueOf(posicionActual);
			int posActX = Integer.valueOf(prueba);
			String letraTableroAMover = posiciones[1].substring(0,1).toUpperCase();
			int posMovY = verificarLetra(letraTableroAMover);
			char posicionAMover = posiciones[1].charAt(1);
			prueba = String.valueOf(posicionAMover);
			int posAMovX = Integer.valueOf(prueba);
			out.println(posActX+"-"+posActY+"-"+posAMovX+"-"+posMovY);
			gestor.moverPiezas(posActX,posActY,posAMovX,posMovY);
			
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
