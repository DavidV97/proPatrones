package Juegos;

import java.util.List;
import Enum.TiposPiezas;
import PiezasDeJuego.Pieza;

public  interface  TipoJuego {
	public List<Pieza> getPiezas(); 
	public void moverPieza(int xOrigen, int yOringen, int xDestino,int yDestino);
}
