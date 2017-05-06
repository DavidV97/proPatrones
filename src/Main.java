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
		out.println("5. Seleccionar jugadores para el juego");
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
				Jugar();
				break;
			case "5":
				selecJugadores();
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

	public static boolean validateGame() throws IOException{
		boolean validation = false;
		if(gestor.getQuanJug() >= 2){
			if(gestor.haveSelecJug()){
				validation = true;
			}else{
				out.println("Debe de seleccionar 2 jugadores para jugar.");
			}
		}else{
			out.println("Debe de crear almenos 2 jugadores para jugar.");
		}
		return validation;
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
		out.println("Jugador: " + gestor.getJugAct2());
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
		out.println("");
		out.println("Jugador: " + gestor.getJugAct1());

	}
	public static void Jugar() throws IOException{
		String salir = "";
		int aux = 1;

		if(validateGame() && gestor.checkTipJuego()){
			while(salir != "E"){
				imprimirTablero();
				System.out.println("");
				System.out.println("Turno de: " + getJugTurno(aux));
				System.out.println("Ingrese la posicion actual de la pieza y la coordenada a la cual quiere mover la pieza: ");
				String posicion = readInput();
				if(!posicion.toUpperCase().equals("E")){
					moverPiezas(posicion);
				}else{
					salir = "E";
					out.println("Saliendo de la partida...");
				}
				aux += 1;
			}
		}else{
			out.println("Debe seleccionar el tipo de juego para jugar");
		}
	}

	public static void moverPiezas(String posicion) throws IOException{
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
	public static String getJugTurno(int aux){
		if((aux & 1) == 0){
			return gestor.getJugAct2();
		}else{
			return gestor.getJugAct1();
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