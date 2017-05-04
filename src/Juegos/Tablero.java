package Juegos;

import Comunicacion.CommunicationComponentFactory;
import Enum.tiposDeJuego;
import PiezasDeJuego.Pieza;

public class Tablero {
	private TipoJuego tipoJuego;
	private int x;
	private int y;

	public Tablero(tiposDeJuego tipoJuego){
		setTipoJuego(CommunicationComponentFactory.CreateComponentForGame(tipoJuego));
		setX(tipoJuego.getX());
		setY(tipoJuego.getY());
	}
	public TipoJuego getTipoJuego() {
		return tipoJuego;
	}
	public void setTipoJuego(TipoJuego tipoJuego) {
		this.tipoJuego = tipoJuego;
	}
	public String[][] dibujarTablero(){
		String [][] tablero = new String[getX()][getY()];
		for(Pieza item : tipoJuego.getPiezas()){
			tablero[item.getX()][item.getY()] =  "[" + item.getImagen() + "]";
		}
		tablero[8][0] = "  A ";
		tablero[8][1] = "  B ";
		tablero[8][2] = "  C ";
		tablero[8][3] = "  D ";
		tablero[8][4] = "  E ";
		tablero[8][5] = "  F ";
		tablero[8][6] = "  G ";
		tablero[8][7] = "  H ";
		return tablero;
	
	}
	/*public void dibujarTablero(Pieza Peon,Pieza Peon2){		
	//	tablero[Peon3.getY()][Peon3.getX()] = "[" + Peon3.getImagen() + "]";
		Boolean negro = true; 
		int X = 0;
	   	 
        for(int Y= 0; Y < getDimensionY(); Y++){ 
     
            for(X = 0; X< getDimensionX(); X++){ 
               // if(Peon != null){ 
                  //  if(Peon.getX()==X && Peon.getY()==Y){ 
                    	if(tablero[Y][X] != null){
                    		System.out.print(tablero[Y][X]); 

                            negro = !negro; 
                            continue; 
                    	}
                    	
                    //}  
                //}  
                if(Peon2!=null){ 
                    if(Peon2.getX()==X && Peon2.getY()==Y){ 
                    	System.out.print(tablero[Y][X] = "[" + Peon2.getImagen() +"]"); 
                        negro = !negro; 
                        continue; 
                    }  
                } 
                if(8 > X){
                	if(tablero[Y][X] == null){
                		System.out.print(tablero[Y][X] = "[  ]");
                	}
            	}
            } 
            System.out.println(); 
            
        } 
       // System.out.print("   A  B  C  D  E  F  G  H\n"); 
    }*/
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


}
