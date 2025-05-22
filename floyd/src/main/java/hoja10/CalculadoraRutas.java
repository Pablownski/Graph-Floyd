package hoja10;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementa el algoritmo de Floyd-Warshall para encontrar rutas más cortas.
 */
public class CalculadoraRutas {
    private int[][] distancias;
    private int[][] predecesores;

    public void ejecutarFloyd(int[][] matriz) {
        int n = matriz.length;
        distancias = new int[n][n];
        predecesores = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                distancias[i][j] = matriz[i][j];
                predecesores[i][j] = (matriz[i][j] != Integer.MAX_VALUE && i != j) ? i : -1;
            }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE) {
                        int nuevo = distancias[i][k] + distancias[k][j];
                        if (nuevo < distancias[i][j]) {
                            distancias[i][j] = nuevo;
                            predecesores[i][j] = predecesores[k][j];
                        }
                    }
    }

    public int[][] getDistancias() {
        return distancias;
    }

    public List<Integer> obtenerCamino(int origen, int destino) {
        LinkedList<Integer> camino = new LinkedList<>();
        if (predecesores[origen][destino] == -1) return camino;

        while (destino != origen) {
            camino.addFirst(destino);
            destino = predecesores[origen][destino];
        }
        camino.addFirst(origen);
        return camino;
    }
}
