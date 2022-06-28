import java.util.ArrayList;

public class GrafoNDP {
    private int[][] grafo;
    private int cantNodos;
    private int cantAristas;

    private static final int INFINITO = -1;
    private ArrayList<Nodo> nodos;
    private int[] pesosAristas;

    public GrafoNDP(int cantNodos, int cantAristas){
        this.cantNodos = cantNodos;
        this.cantAristas = cantAristas;

        this.grafo = new int[cantNodos][cantNodos];
        nodos = new ArrayList<Nodo>();
        pesosAristas = new int[cantAristas];
        inicializarMatriz(grafo);
    }


    public void inicializarMatriz(int[][] grafo){
        for(int i = 0; i < grafo.length; i++){
            for(int j = 0; j < grafo.length; j++){
                grafo[i][j] = INFINITO;
            }
        }
    }
    public int getPesoArista(int nodo1, int nodo2) {
        return grafo[nodo1][nodo2];
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public int getCantAristas() {
        return cantAristas;
    }

    public void ponerArista(int nodo1, int nodo2, int peso) {
        grafo[nodo1][nodo2] = peso;
        grafo[nodo2][nodo1] = peso;
    }

    public boolean hayArista(int nodo1, int nodo2){
        return grafo[nodo1][nodo2] != -1;
    }
}
