package hoja10;

/**
 * Calcula el centro del grafo, que es el nodo con menor distancia máxima hacia otros.
 */
public class AnalizadorCentro {
    public int calcularCentro(int[][] distancias) {
        int n = distancias.length;
        int centro = -1;
        int menorExcentricidad = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (distancias[i][j] != Integer.MAX_VALUE && distancias[i][j] > max) {
                    max = distancias[i][j];
                }
            }
            if (max < menorExcentricidad) {
                menorExcentricidad = max;
                centro = i;
            }
        }
        return centro;
    }
}

