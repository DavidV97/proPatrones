package Enum;

public enum tiposDeJuego {
	ajedrez(9,8),
	damas(8,16),
	go(8,16);
	private int x;
	private int y;
	
	tiposDeJuego(int x,int y){
		setX(x);
		setY(y);
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
