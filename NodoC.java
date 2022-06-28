

public class NodoC {

	private int nroNodo;
	private int grado = 0;
	private int color;
	

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void colorMasUno() {
		this.color++;
	}

	public NodoC(int nroNodo) {
		this.nroNodo = nroNodo;
	}

	public int getNroNodo() {
		return nroNodo;
	}

	public int getGrado() {
		return grado;
	}
}
