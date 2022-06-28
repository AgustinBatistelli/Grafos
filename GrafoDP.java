import java.util.ArrayList;

public class GrafoDP {

    private static final int INFINITO = -1;

    private int[][] grafo;
    private int cantNodos;
    private int cantAristas;

    private ArrayList<Nodo> nodos;
    private int[] pesosAristas;

    public GrafoDP(int cantNodos, int cantAristas){
        this.cantNodos = cantNodos;
        this.cantAristas = cantAristas;

        this.grafo = new int[this.cantNodos][4];
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

    public int[][] getGrafo(){
        return this.grafo;
    }
    public int getCantNodos() {
        return cantNodos;
    }

    public int getCantAristas() {
        return cantAristas;
    }

    public int getPesoArista(int nodo1, int nodo2) {
        return grafo[nodo1][nodo2];
    }

    public boolean hayArista(int nodo1, int nodo2){
        return grafo[nodo1][nodo2] != INFINITO;
    }
    public void ponerArista(int nodo1, int nodo2, int peso) {
        grafo[nodo1][nodo2] =  peso;
    }
}
