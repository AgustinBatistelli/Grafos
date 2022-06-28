import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       // Probando BFS
       // GrafoNDNP grafo = GestorDeArchivos.leerArchivoNDNP("./archivosIN/grafo.in");
       // BFS bfs = new BFS(grafo, 1);
       // bfs.ejectuar();

      // Probando Dijkstra
        GrafoDP grafo = GestorDeArchivos.leerArchivoDP("./archivosIN/grafoDijkstra.in");
        Dijkstra dijkstra = new Dijkstra(grafo, 0);
        dijkstra.ejecutar();

      // Probando Prim
      //   GrafoNDP grafo = GestorDeArchivos.leerArchivoNDP("./archivosIN/grafoPrim2.in");
      //   Prim prim = new Prim(grafo, 1);
      //   prim.ejecutar();
    }
}
