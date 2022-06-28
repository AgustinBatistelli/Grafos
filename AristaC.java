


public class AristaC {

	private int nodo1;
	private int nodo2;

	public AristaC(int nodo1, int nodo2) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
	}

	public int getNodo1() {
		return nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}

	public void mostrar() {
		System.out.println(this.nodo1 + " " + this.nodo2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AristaC other = (AristaC) obj;
		if (nodo1 != other.nodo1)
			return false;
		if (nodo2 != other.nodo2)
			return false;
		return true;
	}
}
