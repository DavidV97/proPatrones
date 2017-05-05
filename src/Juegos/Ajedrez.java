package Juegos;

import java.util.ArrayList;
import java.util.List;

import Enum.TiposPiezas;
import PiezasDeJuego.Pieza;

public class Ajedrez implements TipoJuego{
	private List<Pieza> piezas;
	
	public Ajedrez(){
		this.piezas = new ArrayList<Pieza>();
		crearPiezasTablero();
	}
	private void crearPiezasTablero(){
		this.piezas.add(new Pieza("Torre","NR",false,0,0,null));
		this.piezas.add(new Pieza("Torre","NR",false,0,7,null));
		this.piezas.add(new Pieza("Caballo","NH",false,0,1,null));
		this.piezas.add(new Pieza("Caballo","NH",false,0,6,null));
		this.piezas.add(new Pieza("Alfil","NB",false,0,5,null));
		this.piezas.add(new Pieza("Alfil","NB",false,0,2,null));
		this.piezas.add(new Pieza("Reina","NQ",false,0,3,null));
		this.piezas.add(new Pieza("Rey","NK",false,0,4,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,0,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,1,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,2,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,3,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,4,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,5,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,6,null));
		this.piezas.add(new Pieza("Peon","NP",false,1,7,null));

		//piezas blancas
		this.piezas.add(new Pieza("Torre","BR",true,7,7,null));
		this.piezas.add(new Pieza("Torre","BR",true,7,0,null));
		this.piezas.add(new Pieza("Caballo","BH",true,7,1,null));
		this.piezas.add(new Pieza("Caballo","BH",true,7,6,null));
		this.piezas.add(new Pieza("Alfil","BB",true,7,5,null));
		this.piezas.add(new Pieza("Alfil","BB",true,7,2,null));
		this.piezas.add(new Pieza("Reina","BQ",true,7,3,null));
		this.piezas.add(new Pieza("Rey","BK",true,7,4,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,0,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,1,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,2,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,3,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,4,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,5,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,6,null));
		this.piezas.add(new Pieza("Peon","BP",true,6,7,null));
		
	}
	/*public Pieza definePiezas(TiposPiezas pieza,boolean blanca,int x, int y){
	switch(pieza){ 
    case PEON: 
        Pieza peon = new Pieza(pieza.name(), blanca?"B1":"P6",blanca); 
        peon.setX(x); 
        peon.setY(y); 
        peon.setComer((p)->{ 
            int avanza = 0; 
            if(peon.getBlanca()){ 
                avanza = 1; 
            } else{ 
                avanza = -1; 
            } 
            if((peon.getX()+avanza)==p.getX()){ 
                if(((peon.getY()-avanza)==p.getY())||((peon.getY()+avanza)==p.getY())){ 
                    return true; 
                } 
            } 
            return false; 
        }); 
        return peon; 
    case ALFIL: 
        Pieza alfil = new Pieza(pieza.name(), blanca?"C1":"F6",blanca); 
        alfil.setX(x); 
        alfil.setY(y); 
        alfil.setComer((p)->{ 
             
            for(int xF = -1; xF<2 ;xF+=2){ 
                for(int yF = -1; yF<2;yF+=2){ 
                    if(movimientoDiagonal(alfil.getX(), alfil.getY(), p.getX(), p.getY(), xF, yF)){ 
                        return true; 
                    } 
                } 
            } 
            return false; 
        }); 
        return alfil; 
    case CABALLO: 
        Pieza caballo = new Pieza(pieza.name(), blanca?"B8":"G8",blanca); 
        caballo.setX(x); 
        caballo.setY(y); 
        caballo.setComer((p)->{ 
            int yF = 1; 
            for(int xF=-2; xF < 3; xF+=1){ 
                if(xF != 0){ 
                    if(movimientoCaballo(caballo.getX(), caballo.getY(), p.getX(), p.getY(), xF, yF)){ 
                       return true;  
                    } 
                } 
                if(xF<0){ 
                    yF++; 
                }else{ 
                    if(xF>=0){ 
                        yF--; 
                    } 
                } 
            } 
            return false; 
        }); 
        return caballo; 
    case TORRE: 
        Pieza torre = new Pieza(pieza.name(), blanca?"A1":"H1",blanca); 
        torre.setX(x); 
        torre.setY(y); 
        torre.setComer((p)->{ 
            if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 0, -1)){ 
                return true; 
            } 
            if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 0, 1)){ 
                return true; 
            } 
            if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), -1, 0)){ 
                return true; 
            } 
            if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 1, 0)){ 
                return true; 
            } 
            return false; 
        }); 
        return torre; 
    case REINA: 
        Pieza reina = new Pieza(pieza.name(), blanca?"D1":"D8",blanca); 
        reina.setX(x); 
        reina.setY(y); 
        reina.setComer((p)->{ 
            for(int xF = -1; xF<2 ;xF+=2){ 
                for(int yF = -1; yF<2;yF+=2){ 
                    if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), xF, yF)){ 
                        return true; 
                    } 
                } 
            } 
            if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 0, -1)){ 
                return true; 
            } 
            if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 0, 1)){ 
                return true; 
            } 
            if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), -1, 0)){ 
                return true; 
            } 
            if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 1, 0)){ 
                return true; 
            } 
            return false; 
        }); 
        return reina; 
    case REY: 
        Pieza rey = new Pieza(pieza.name(), blanca?"E1":"E8",blanca); 
        rey.setX(x); 
        rey.setY(y); 
        rey.setComer((p)->{ 
             
            for(int xF = -1; xF<2 ;xF+=2){ 
                for(int yF = -1; yF<2;yF+=2){ 
                    if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), xF, yF)){ 
                        return true; 
                    } 
                } 
            } 
            if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 1, 0)){ 
                return true; 
            } 
            if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 0, 1)){ 
                return true; 
            } 
            if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 0, -1)){ 
                return true; 
            } 
            if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), -1, 0)){ 
                return true; 
            } 
            return false; 
        }); 
        return rey; 
	} 
	return null; 
	} 

	private boolean movimientoDiagonal(int x, int y,int xB,int yB,int incX, int incY){ 
		for(int xF = x,yF=y; xF < 8 && yF < 8 && xF>=0 && yF>=0; xF+=incX,yF+=incY){ 
			if(xB == xF && yB == yF){ 
				return true; 
	    	} 
		} 
		return false; 
	} 

	private boolean movimientoCaballo(int x, int y,int xB,int yB,int incX, int incY){ 
		return (((x+incX)==xB) &&(((y+incY)==yB)||(y-incY)==yB)); 
	} 

	private boolean movimientoRey(int x, int y, int xB, int yB,int incX, int incY){ 
		return (((x+incX) == xB)&&((y+incY)==yB)); 
	}*/

	@Override
	public List<Pieza> getPiezas() {
		return this.piezas;
	}
	@Override
	public void moverPieza(int xOrigen, int yOringen, int xDestino, int yDestino) {
		for(Pieza item : this.piezas){
			if(item.getX()==xOrigen && item.getY()==yOringen){
				item.setX(xDestino); 
				item.setY(yDestino);
				System.out.println(item.getImagen()+"-"+item.getX()+"-"+item.getY());
			}
		}
		
	} 

}
