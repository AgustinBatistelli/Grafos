import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private GrafoNDNP grafo;
    private int cantNodos;
    private int cantAristas;

    private int nodoInicial;
    private ArrayList<Arista> arbol;
    private boolean[] nodoTerminado;

    public GrafoNDNP getGrafo() {
        return grafo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public int getCantAristas() {
        return cantAristas;
    }

    public int getNodoInicial() {
        return nodoInicial;
    }

    public BFS(GrafoNDNP grafo, int nodoInicial) {
        this.grafo = grafo;
        this.cantNodos = grafo.getCantNodos();
        this.cantAristas = grafo.getCantAristas();

        this.nodoInicial = nodoInicial;
        this.arbol = new ArrayList<Arista>();
        this.nodoTerminado = new boolean[cantNodos];
    }

    public void ejectuar() throws IOException {
        // Cola que almacena los nodos visitados
        Queue<Integer> cola = new LinkedList<Integer>();
        // encolo el nodo inicial
        cola.offer(this.nodoInicial);

        int nodo, indice;

        while (!cola.isEmpty()) {
            nodo = cola.peek();

            // genero todos los numeros de nodo
            for (int i = 0; i < this.cantNodos; i++) {
                if (nodo != i && !this.nodoTerminado[i]) {
                    // si existe una arista que una estos nodos
                    if (this.grafo.getGrafo().hayArista(i,nodo)) {
                        //agrego la arista al arbol
                        this.arbol.add(new Arista(nodo, i));
                        // encolo el otro node de la arista para seguir recorriendo a partir de el
                        cola.offer(i);
                        //marco como terminado al nodo encolado
                        this.nodoTerminado[i] = true;
                    }
                }

            }
            // desencolo el primer nodo de la cola y lo marco como terminado;
            nodo = cola.poll();
            this.nodoTerminado[nodo] = true;
        }
        this.escribirSolucionEnConsola();
    }


    public void escribirSolucionEnConsola() {
        System.out.println("BFS: Búsqueda en Anchura:");
        System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
        System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + this.nodoInicial);
        System.out.println("Lista de Ramas:");
        for (Arista rama : arbol) {
            System.out.println(rama.getNodo1() + " " + rama.getNodo2());
        }
    }
}
