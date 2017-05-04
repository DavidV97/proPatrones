package ComunicacionManager;

import Comunicacion.CommunicationComponentFactory;
import Enum.TiposPiezas;
import Enum.tiposDeJuego;
import Juegos.TipoJuego;

public class ComunicationManager {
	
	public void juegoEnviado(tiposDeJuego ptipoJuego){
		TipoJuego tipJuego = CommunicationComponentFactory.CreateComponentForGame(ptipoJuego);

	}
}
