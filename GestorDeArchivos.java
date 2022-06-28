import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorDeArchivos {
    public static  GrafoNDNP leerArchivoNDNP(String Path) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(Path));

        int cantNodos = scan.nextInt();
        int cantArtistas = scan.nextInt();

        GrafoNDNP grafoNDNP = new GrafoNDNP(cantNodos, cantArtistas);

        int nodo1; int nodo2;
        for (int i = 0; i < cantArtistas; i++){
            nodo1 = scan.nextInt();
            nodo2 = scan.nextInt();
            grafoNDNP.ponerArista(nodo1, nodo2);
        }

        scan.close();
        return grafoNDNP;
    }

    public static  GrafoNDP leerArchivoNDP(String Path) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(Path));

        int cantNodos = scan.nextInt();
        int cantArtistas = scan.nextInt();

        GrafoNDP grafoNDP = new GrafoNDP(cantNodos, cantArtistas);

        int nodo1, nodo2,peso;
        for (int i = 0; i < cantArtistas; i++){
            nodo1 = scan.nextInt() - 1;
            nodo2 = scan.nextInt() - 1;
            peso = scan.nextInt();
            grafoNDP.ponerArista(nodo1, nodo2, peso);
        }

        scan.close();
        return grafoNDP;
    }

    public static  GrafoDP leerArchivoDP(String Path) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(Path));

        int cantNodos = scan.nextInt();
        int cantArtistas = scan.nextInt();

        GrafoDP grafoDP = new GrafoDP(cantNodos, cantArtistas);

        int nodo1, nodo2,peso;
        for (int i = 0; i < cantArtistas; i++){
            nodo1 = scan.nextInt();
            nodo2 = scan.nextInt();
            peso = scan.nextInt();
            grafoDP.ponerArista(nodo1, nodo2, peso);
        }

        scan.close();
        return grafoDP;
    }

}
