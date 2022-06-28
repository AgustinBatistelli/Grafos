import java.util.ArrayList;

public class GrafoNDNP{
    private MatrizSimetrica grafo;
    private int cantNodos;
    private int cantAristas;

    private ArrayList<Nodo> nodos;

    public GrafoNDNP(int cantNodos, int cantAristas){
        this.cantNodos = cantNodos;
        this.cantAristas = cantAristas;
        this.grafo = new MatrizSimetrica(cantNodos);

        nodos = new ArrayList<Nodo>();
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public int getCantAristas() {
        return cantAristas;
    }

    public MatrizSimetrica getGrafo() {
        return this.grafo;
    }


    public void ponerArista(int nodo1, int nodo2) {
      grafo.ponerArista(nodo1, nodo2);
    }


}