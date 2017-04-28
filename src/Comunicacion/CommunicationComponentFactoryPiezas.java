package Comunicacion;
import Enum.TiposPiezas;
import PiezasDeJuego.Piezas;
import PiezasDeJuego.PiezasAjedrez;
import PiezasDeJuego.PiezasDamas;
import PiezasDeJuego.PiezasGo;

public class CommunicationComponentFactoryPiezas {
	public static Piezas CreateComponentForGame(TiposPiezas ppiezas){
		switch(ppiezas){ 
			case piezasAjedrez:
				return new PiezasAjedrez();
			case piezasDamas:
				 return new PiezasDamas();
			case piezasGo:
				return new PiezasGo();
			default:
				return null;	
		}
	}
}
