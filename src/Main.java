import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
		out.println("    -- MENU PRINCIPAL --    ");
		out.println("1.  Crear un jugador");
		out.println("2.  ");
		out.println("3.  ");
		out.println("0. Salir. ");
		out.println();
		out.print("Seleccione una opcion: ");
	}
    
    static void menu()throws java.io.IOException{
    	
    	gestor.filesDirection();
    	boolean exit = false;
    	String option;
    	
    	while(!exit){
    		showMenu();
    		option = readInput();
    		
    		switch(option){
    		
    		case "1":
    			createJugador();
    			break;
    			
    		case "2":
    			break;
    			
    		case "3":
    			break;
    			
    		case "0":
    			exit = true;
        		out.println("-- Hasta pronto --");
        		
        		break;
    		default:
    			out.println("-- Opcion invalida --");
    			out.println();
				break;
    		}
    	}
    }
    
    static void createJugador() throws IOException{
    	String pUsername,pEmail,pPassword;
    	
    	pUsername = getUsername();
    	pEmail = getEmail();
    	pPassword = getPassword();
    	
    	gestor.createJugador(pUsername,pEmail,pPassword);
    	
    	out.println("El jugador se creo de manera exitosa.");
    }
    
    static String getUsername() throws IOException{
    	String username = "";
    	boolean reprobate = true;
    	
    	while(reprobate){
    		out.println("Nombre de usuario: ");
    		username = readInput();
    		if(username != null && username != ""){
    			if(!gestor.checkExists(username)){
    				reprobate = false;
    			}else{
    				out.println("El usuario digitado ya existe, por favor ingrese otro.");
    			}
    		}else{
    			out.println("Aseg�rese de no haber dejado el espacio en blanco.");
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
    		if(email != null && email != ""){
    			if(mather.find()){
    				reprobate = false;
    			}else{
    				out.println("El correo digitado no es un correo, por favor ingrese otro.");
    			}
    		}else{
    			out.println("Aseg�rese de no haber dejado el espacio en blanco.");
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
    			if(password.length() >= 6){
    				reprobate = false;
    			}else{
    				out.println("La contrase�a digitade debe tener seis o mas caracteres, por favor ingrese otra.");
    			}
    		}else{
    			out.println("Aseg�rese de no haber dejado el espacio en blanco.");
    		}
    	}
    	return password;
    }

}
