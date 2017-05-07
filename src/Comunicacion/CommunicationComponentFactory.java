package Comunicacion;

import Enum.tiposDeJuego;
import Juegos.Ajedrez;
import Juegos.Damas;
import Juegos.Go;
import Juegos.TipoJuego;


public class CommunicationComponentFactory {
	
	public static TipoJuego CreateComponentForGame(tiposDeJuego ptipoJuego){
		switch(ptipoJuego){ 
			case ajedrez:
				return new Ajedrez();
			case damas:
				return new Damas();
			case go:
				return new Go();
			default:
				return null;	
		}
	}
}
