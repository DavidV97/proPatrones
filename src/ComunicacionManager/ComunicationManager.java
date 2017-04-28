package ComunicacionManager;

import Comunicacion.CommunicationComponentFactory;
import Comunicacion.CommunicationComponentFactoryPiezas;
import Enum.TiposPiezas;
import Enum.tiposDeJuego;
import Juegos.TipoJuego;
import PiezasDeJuego.Piezas;

public class ComunicationManager {
	
	public void juegoEnviado(tiposDeJuego ptipoJuego,TiposPiezas pTipoPieza){
		TipoJuego tipJuego = CommunicationComponentFactory.CreateComponentForGame(ptipoJuego);
		Piezas  tipPiezas = CommunicationComponentFactoryPiezas.CreateComponentForGame(pTipoPieza);
		// crearPiezas devuelve un arrayListDePiezas
		tipJuego.jugar(tipPiezas.crearPiezas());
	}
}
