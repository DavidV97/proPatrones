package PiezasDeJuego;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public interface Piezas {
	public String color  = "";
	public String coordenadas = "";
	
	public ArrayList crearPiezas();
	public void color(String pcolor);
	public void coordenadas(String pcoordenadas);
}
