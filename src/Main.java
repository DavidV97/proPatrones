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
    
    static String readInput()throws java.io.IOException{
		String input;
		
		input = in.readLine(); 
		out.println();

		return input;
	}
    
    static void showMenu(){
		out.println();
		out.println("    -- MENÚ PRINCIPAL --    ");
		out.println("1.Crear jugador ");
		out.println("2.Escoger tipo de juego\n 1- Ajedrez\n 2- Damas\n 3- Go  ");
		out.println("3.  ");
		out.println("0. Salir. ");
		out.println();
		out.print("Seleccione una opcion: ");
	}
    
    static void menu()throws java.io.IOException{
    	
    	boolean exit = false;
    	String option;
    	
    	while(!exit){
    		
    		showMenu();
    		option = readInput();
    		
    		if(option.equals("1")){
    			createJugador();
        	}else if(option.equals("2")){
        		String tipoJuego = readInput();
        		escogerJuego(tipoJuego);
        		
        	}else if(option.equals("3")){
        		
        		
        	}else if(option.equals("0")){
        		exit = true;
        		out.println("-- Hasta pronto --");
        		
        	}else{
        		out.println("-- Opcion invalida --");
    			out.println();
        	}
    	}
    }
    
    static void createJugador() throws IOException{
    	String pUsername,pEmail,pPassword;
    	
    	pUsername = getUsername();
    	pEmail = getEmail();
    	pPassword = getPassword();
    	
    	gestor.createJugador(pUsername,pEmail,pPassword);
    }
    
    static String getUsername() throws IOException{
    	String username = "";
    	boolean reprobate = true;
    	
    	while(reprobate){
    		out.println("Nombre de usuario: ");
    		username = readInput();
    		if(username != null && username != "" && gestor.checkExists()){
    			reprobate = false;
    		}
    	}
    	return username;
    }
    
    static String getEmail() throws IOException{
    	String email = "";
    	boolean reprobate = true;
    	Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    	Matcher mather;
    	
    	while(reprobate){
    		out.println("E-mail: ");
    		email = readInput();
            mather = pattern.matcher(email);
    		if(email != null && email != "" && mather.find()){
    			reprobate = false;
    		}
    	}
    	return email;
    }
    
    static String getPassword() throws IOException{
    	String password = "";
    	boolean reprobate = true;
    	
    	while(reprobate){
    		out.println("Contraseña: ");
    		password = readInput();
    		if(password != null && password != ""){
    			reprobate = false;
    		}
    	}
    	return password;
    }
	public static void escogerJuego(String tipoJuego){
		switch(tipoJuego){
			case "1":
				gestor.enviarJuego(tiposDeJuego.ajedrez,TiposPiezas.piezasAjedrez);
			break;
			case "2":
				gestor.enviarJuego(tiposDeJuego.damas,TiposPiezas.piezasDamas);
				break;
			case "3":
				gestor.enviarJuego(tiposDeJuego.go,TiposPiezas.piezasGo);
				break;
				
			default:
				System.out.println("Opcion invalida");
				break;
				
		}
	}

}
