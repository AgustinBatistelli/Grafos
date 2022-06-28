import java.io.IOException;
import java.util.ArrayList;

public class Prim {
    private GrafoNDP grafo;
    private int cantNodos;
    private int cantAristas;
    private int nodoInicial;

    private ArrayList<Integer> arbol;
    private int[] padres;

    private ArrayList<Integer> nodosConectados;
    private ArrayList<Integer> nodosNoConectados;

    private int minimoCosto;
    private static final int INFINITO = -1;

    public Prim(GrafoNDP grafo, int nodoInicial) {
        this.grafo = grafo;
        this.cantNodos = grafo.getCantNodos();
        this.cantAristas = grafo.getCantAristas();
        this.nodoInicial = nodoInicial;

        new ArrayList<Integer>();
        this.arbol = new ArrayList<Integer>();
        this.padres = new int[this.cantNodos];
        inicializarPadres();
        this.minimoCosto = 0;

        this.nodosConectados = new ArrayList<Integer>();
        this.nodosNoConectados = new ArrayList<Integer>();
    }

    public void inicializarPadres(){
        for(int i = 0; i < padres.length; i++){
            padres[i] = i;
        }
    }

    public void ejecutar() throws IOException{
        // agregamos todos los nodos al conjunto de nodos no conectados
        for (int i = 0; i < this.cantNodos; i++)
            this.nodosNoConectados.add(i);

        this.nodosNoConectados.remove(this.nodosNoConectados.indexOf(nodoInicial));
        // lo agrego al conjunto de nodos conectados
        this.nodosConectados.add(nodoInicial);

        int nodoCreceRama = 0;
        int nodoMasCercano = 0;

        while(arbol.size() < cantNodos - 1){
            // pongo la distancia en infinito ya que no conocemos el nodo mas cercano
            int distancia = INFINITO;

            // para cada nodo del conjunto de nodos conectados
            for (int nodoActual : this.nodosConectados){
                // para cada nodo del conojunto de nodos no conectados
                for (int nodo : this.nodosNoConectados){
                    if(this.grafo.hayArista(nodo, nodoActual)) {
                        // si todavia no se determino el nodo mas cercano o se encontro uno mas cercano
                        if( distancia == INFINITO || grafo.getPesoArista(nodo, nodoActual) < distancia){
                            if (find(nodoActual) != find(nodo)){
                                // el nodo es el conectable mas cercano
                                distancia = grafo.getPesoArista(nodo, nodoActual);
                                nodoMasCercano = nodo;
                                nodoCreceRama = nodoActual;
                            }
                        }
                    }
                }
            }
            // le pongo el mismo padre a los nodos
            union(nodoCreceRama, nodoMasCercano);

            arbol.add(grafo.getPesoArista(nodoCreceRama,nodoMasCercano));

            // acumulo el peso de la arista al costo minimo
            this.minimoCosto += distancia;
            // quito ese nodo del conjunto de nodos no conectados
            this.nodosNoConectados.remove(this.nodosNoConectados.indexOf(nodoMasCercano));
            // lo agrego al conjunto de nodos conectados
            this.nodosConectados.add(nodoMasCercano);

        }

        // escribo la solucion en consola
        this.escribirSolucionEnConsola();
    }


    public void escribirSolucionEnConsola() {
        System.out.println("PRIM:");
        System.out.println("Costo del Árbol Abarcador Mínimo: " + this.minimoCosto);
        System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
        System.out.println("Lista de Ramas:");
        for (int rama : arbol) {
            System.out.print(rama + " - ");
        }
    }

    public int find(int nodo) {
        return this.padres[nodo] == nodo ? nodo : find(this.padres[nodo]);
    }

    public void union(int nodo1, int nodo2) {
        this.padres[find(nodo1)] = this.padres[find(nodo2)];
    }

}
