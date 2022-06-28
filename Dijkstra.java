import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    private  GrafoDP grafo;
    private int nodoInicial;

    private int cantNodos;
    private boolean nodoTerminado[];
    private ArrayList<CostoAlNodo> costos;

    private static final int INFINITO = -1;

    public Dijkstra(GrafoDP grafo, int nodoInicial){
        this.grafo = grafo;
        this.nodoInicial = nodoInicial;
        this.cantNodos = grafo.getCantNodos();
        this.nodoTerminado = new boolean[cantNodos];
        costos = new ArrayList<CostoAlNodo>();
    }

    public void ejecutar() throws IOException{
        //Cola de prioridad para almacenar los nodos adyacentes que se van visitando
        Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
        CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial, 0);

        // encolo el nodo incial
        cola.add(nodoActual);
        int nodo = nodoActual.getNodo();
        CostoAlNodo actualizado;

        for (int i = 0; i < this.cantNodos; i++){
            if(i != nodo)
                costos.add(new CostoAlNodo(i, INFINITO));
            else{
                costos.add(new CostoAlNodo(i, 0));
                costos.get(i).agregarNodoAlCamino(nodo);
            }
        }

        while(!cola.isEmpty()){
            nodoActual = cola.poll();
            nodo = nodoActual.getNodo();

            for (int i = 0; i < this.cantNodos; i++){
                if (nodo != i && !this.nodoTerminado[i]) {
                    if(this.grafo.hayArista(nodo, i)){
                        if(this.costos.get(i).getCostoMinimo() == INFINITO ||
                           this.costos.get(nodo).getCostoMinimo() + this.grafo.getPesoArista(i, nodo) < this.costos.get(i).getCostoMinimo()){
                            // referencio al nodo
                            actualizado = this.costos.get(i);

                            // actualizo su costo al dado hasta el nodo actual mas el peso de la arista entre ambos
                            actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(nodo, i));

                            //le cambio el camino mas corto por el camino mas corto hasta el nodo actual
                            actualizado.setCaminoMasCorto((ArrayList<Integer>) this.costos.get(nodo).getCaminoMasCorto().clone());

                            //agrero el nodo visitado
                            actualizado.agregarNodoAlCamino(i);

                            // encolo el nodo visitado para luego buscar caminos desde el
                            if(!cola.contains(actualizado))
                                cola.add(actualizado);

                        }
                    }
                }
            }
            this.nodoTerminado[nodo] = true;
        }

        // muestro solución en consola
        this.escribirSolucionEnConsola();
    }

    public GrafoDP getGrafo() {
        return grafo;
    }

    private void escribirSolucionEnConsola() {
        int costo;
        System.out.println("DIJKSTRA: Nodo Inicial: " + this.nodoInicial);
        for (int i = 0; i < this.costos.size(); i++) {
            costo = costos.get(i).getCostoMinimo();
            if (costo == INFINITO) {
                System.out.println("Nodo Final: " + i + " Costo del Camino Más Corto: INFINITO");
            } else {
                System.out.println("Nodo Final: " + i + " Costo del Camino Más Corto: " + costo);
            }
        }
    }
}
