
import java.util.ArrayList;
import java.util.Stack;

public class GrafoC {
	private int[][] matrizAdya;
	private ArrayList<AristaC> puentes = new ArrayList<AristaC>();

	public void inicializarMatriz(int tam) {
		this.matrizAdya = new int[tam][tam];
	}

	public void ponerArista(int fil, int col) {
		this.matrizAdya[fil - 1][col - 1] = 1;
	}

	public boolean existeArista(int fil, int col) {
		return this.matrizAdya[fil][col] != 0;
	}

	public void agregarPuente(int n1, int n2) {
		puentes.add(new AristaC(n1 - 1, n2 - 1));
	}

	public boolean esPuente(int fil, int col) {
		return puentes.contains(new AristaC(fil, col));
	}

	public int cantNodos() {
		return matrizAdya.length;
	}

	public static ArrayList<AristaC> DFS(GrafoC grafo, NodoC nodoInicial) {

		ArrayList<AristaC> arbol = new ArrayList<AristaC>();
		boolean[] nodoVisitado = new boolean[grafo.cantNodos()];

		Stack<NodoC> pila = new Stack<NodoC>();
		pila.push(nodoInicial);
		NodoC nodoAux;
		boolean adyacente = false;

		while (!pila.isEmpty()) { // Mientras la pila no este vacia.

			nodoAux = pila.peek(); // Asigno el nodo al primero de la pila.
			for (int i = 0; i < grafo.cantNodos(); i++) { // Recorro todos los nodos

				if (nodoAux.getNroNodo() != i && !nodoVisitado[i]) {// Si el i es distinto del nodo y i no fue visitado.

					if (grafo.existeArista(nodoAux.getNroNodo(), i)) {// Si hay una arista que conecte nodo y i.

						arbol.add(new AristaC(nodoAux.getNroNodo(), i)); // Agrego la arista al arbol.
						nodoVisitado[nodoAux.getNroNodo()] = true;
						pila.push(new NodoC(i)); // Agrego a la pila el i.
						adyacente = true;
						break;
					}
				}
			}

			if (!adyacente) { // Si no tiene mas adyacentes.

				nodoAux = pila.pop(); // Lo saco de la pila.
				nodoVisitado[nodoAux.getNroNodo()] = true; // Lo marco como visitado.
			} else // Si tiene adyacentes no lo saco de la pila.
				adyacente = false;
		}

		ArrayList<AristaC> aristas = new ArrayList<AristaC>();
		for (AristaC rama : arbol)
			aristas.add(new AristaC(rama.getNodo1(), rama.getNodo2()));

		return aristas;

	}

	public int[][] floyd(int[][] matAdy) {
		int ady[][] = matAdy;
		int cantNodos = matAdy.length;
		for (int k = 0; k < cantNodos; ++k) {
			for (int i = 0; i < cantNodos; ++i) {
				for (int j = 0; j < cantNodos; ++j) {
					ady[i][j] = min(ady[i][j], ady[i][k] + ady[k][j]);
				}
			}
		}
		return ady;
	}

	public boolean[][] warshall(boolean[][] matAdy) {
		boolean ady[][] = matAdy;
		int cantNodos = matAdy.length;
		for (int k = 0; k < cantNodos; ++k) {
			for (int i = 0; i < cantNodos; ++i) {
				for (int j = 0; j < cantNodos; ++j) {
					if (ady[i][j] || (ady[i][k] && ady[k][j]))
						ady[i][j] = true;
				}
			}
		}
		return ady;
	}

	public int min(int i, int j) {
		return i - j;
	}

	public void secuencial(boolean matAdy[][]) {
		int cantNodos = matAdy.length;
		ArrayList<NodoC> nodos = new ArrayList<NodoC>(cantNodos);
		int colorMax = 1;
		boolean colorNuevo;
		boolean aux;

		for (int i = 0; i < cantNodos; i++) {
			nodos.get(i).setColor(i);
			colorNuevo = false;
			aux = true;
			while (aux) {
				for (int j = 0; j < cantNodos; j++) {
					if (matAdy[j][i] && (nodos.get(i).getColor() == nodos.get(j).getColor()))
						colorNuevo = true;
				}

				if (colorNuevo) {
					aux = true;
					colorNuevo = false;
					nodos.get(i).colorMasUno();
				} else
					aux = false;

				if (nodos.get(i).getColor() > colorMax)
					colorMax = nodos.get(i).getColor();
			}

			System.out.println(colorMax);
		}

	}
}
