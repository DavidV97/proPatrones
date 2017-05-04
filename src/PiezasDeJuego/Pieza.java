package PiezasDeJuego;

import Juegos.Comer;

public class Pieza {
	private String nombre; 
	private String imagen; 
	private Boolean blanca; 
	private int x; 
	private int y; 
	private Comer comer; 
    
	public Pieza(String nombre, String imagen, Boolean blanca, int x, int y, Comer comer){ 
        setNombre(nombre); 
        setImagen(imagen); 
        setBlanca(blanca); 
        setX(x); 
        setY(y); 
        setComer(comer);

    } 
     
    public Pieza(String nombre, String imagen){ 
        this(nombre, imagen, null, 0,0,null); 
    } 
     
    public Pieza(String nombre, String imagen, Boolean blanca){ 
        this(nombre, imagen, blanca, 0,0,null); 
    } 
 
    /** 
     * @return the nombre 
     */ 
    public String getNombre() { 
        return nombre; 
    } 
 
    /** 
     * @param nombre the nombre to set 
     */ 
    public void setNombre(String nombre) { 
       this.nombre = nombre; 
    } 
 
    /** 
     * @return the imagen 
     */ 
    public String getImagen() { 
        return imagen; 
    } 
 
    /** 
     * @param imagen the imagen to set 
     */ 
    public void setImagen(String imagen) { 
    	this.imagen = imagen; 
    } 
 
    /** 
     * @return the blanca 
     */ 
    public Boolean getBlanca() { 
        return blanca; 
    } 
 
    /** 
     * @param blanca the blanca to set 
     */ 
    public void setBlanca(Boolean blanca) { 
      this.blanca = blanca; 
    } 
 
    /** 
     * @return the x 
     */ 
    public int getX() { 
        return x; 
    } 
 
    /** 
     * @param x the x to set 
     */ 
    public void setX(int x) { 
      this.x = x; 
    } 
 
    /** 
     * @return the y 
     */ 
    public int getY() { 
        return y; 
    } 
 
    /** 
     * @param y the y to set 
     */ 
    public void setY(int y) { 
    	this.y = y; 
    } 
 
    /** 
     * @return the comer 
     */ 
    public Comer getComer() { 
        return comer; 
    } 
 
    /** 
     * @param comer the comer to set 
     */ 
    public void setComer(Comer comer) { 
       this.comer = comer; 
    } 
}
