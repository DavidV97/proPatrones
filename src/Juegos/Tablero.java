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
		String[][] tablero = new String[getX()][getY()];
		for(Pieza item : this.tipoJuego.getPiezas()){
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
