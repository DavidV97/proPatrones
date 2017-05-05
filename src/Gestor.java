import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
 private Jugador jugAct1;
 private Jugador jugAct2;
 
 protected Gestor(){}
 
 public static Gestor getGestor(){
  if(gestor == null){
   gestor = new Gestor();
   filesDirection();
  }
  return gestor;
 }
 
 public void setJugador(String jug1, String jug2) throws IOException{
  jugAct1  = getDBJugador(jug1);
  jugAct2  = getDBJugador(jug2);
 }
 
 public String getJugAct1(){
  return jugAct1.getUsername();
 }
 
 public String getJugAct2(){
  return jugAct2.getUsername();
 }
 
 public boolean haveSelecJug(){
  if(jugAct1 != null && jugAct2 != null){
   return true;
  }
  return false;
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
 
 public int getQuanJug() throws IOException{
  int quantity = 0;
  int aux = 3;
  int lines = 1;
  
  BufferedReader reader = new BufferedReader(new FileReader("Jugadores.txt"));
  while (reader.readLine() != null) lines++;
  reader.close();
  
  while(true){
   if(lines>aux){
    quantity += 1;
    aux += 3;
   }else{
    if(lines<(lines+aux)){
     break;
    }
   }
  }
  return quantity;
 }
 
 public String getDBJugadores() throws IOException{
  String dbuser,usernamePart = "Jugadores\n";
  String[] parts;
  int aux = 0;
  
  for(int i=0; i<getQuanJug(); i++){
   dbuser = Files.readAllLines(Paths.get("Jugadores.txt")).get(aux);
   parts = dbuser.split("= "); //returns an array with the 2 parts
   usernamePart += "- " + parts[1] + "\n"; 
   aux += 3;
  }
  
  return usernamePart;
 }
 
 public Jugador getDBJugador(String pjugador) throws IOException{
  String user,email,password;
  Jugador jugador = null;
  int aux = 0;
  
  for(int i=0; i<getQuanJug(); i++){
   user = getOutputDB(aux);
   
   if(pjugador.equals(user)){
    email = getOutputDB(aux+1);
    password = getOutputDB(aux+2);
    jugador = new Jugador(user,email,password);
   }
   aux += 3;
  }
  return jugador;
 }
 
 public String getOutputDB(int aux) throws IOException{
  String dboutputComplete,dboutput;
  String[] parts;
  dboutputComplete = Files.readAllLines(Paths.get("Jugadores.txt")).get(aux);
  parts = dboutputComplete.split("= ");
  dboutput = parts[1];
  return dboutput;
 }
 
 public void guardarPartida(Tablero partida) throws IOException{
  
  try {
            FileWriter writer = new FileWriter("Partidas.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Jugador 1= " + this.jugAct1.getUsername());
            bufferedWriter.newLine();
            bufferedWriter.write("Jugador 2= " + this.jugAct2.getUsername());
            bufferedWriter.newLine();
            bufferedWriter.write("Partida = " );
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            BufferedWriter out = new BufferedWriter(new FileWriter("Partidas.txt"));
            guardarPartida(partida);
        }
   
 }
 
 public static void filesDirection(){
  Properties prop = new Properties();
  OutputStream output  = null;

  try {
   output  = new FileOutputStream("filesDirections.properties");
   
   // set the properties value
   prop.setProperty("workspace proPatrones Jugadores.txt", "Archivo de Jugadores");
   prop.setProperty("workspace proPatrones Partidas.txt", "Archivo de Partidas");

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
 
 public boolean checkTipJuego(){
  if(this.tablero != null){
   return true;
  }
  return false;
 }

 public String[][] obtenerMatriz(){
  return this.tablero.dibujarTablero();
 }

 public void moverPiezas(int posActX, int posAct, int posMovX, int posAMov){
 /* Pieza pieza;
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
  }*/
  ajedrez.moverPieza(posActX, posAct, posMovX, posAMov);
  System.out.println(tablero.dibujarTablero());
 }
}