
public class MatrizSimetrica {

    private int[][] matrizSimetrica;

    public MatrizSimetrica(int cantNodos) { // Recibe el orden de la matriz
        matrizSimetrica = new int[cantNodos][cantNodos];

        for (int i = 0; i < cantNodos - 1; i++)
            for (int j = 0; i < cantNodos - 1 - i; i++) {
                matrizSimetrica[i][j] = 0;
                matrizSimetrica[j][i] = 0;
            }
    }

    public void ponerArista(int nodo1, int nodo2) {
        matrizSimetrica[nodo1][nodo2] = 1;
        matrizSimetrica[nodo2][nodo1] = 1;
    }
    public void ponerAristaPonderada(int nodo1, int nodo2, int peso) {
        matrizSimetrica[nodo1][nodo2] = peso;
        matrizSimetrica[nodo2][nodo1] = peso;
    }

    public int getPesoArista(int nodo1, int nodo2){
        return matrizSimetrica[nodo1][nodo2];
    }
    public boolean hayArista(int nodo1, int nodo2) {
        return matrizSimetrica[nodo1][nodo2] == 1;
    }
}
