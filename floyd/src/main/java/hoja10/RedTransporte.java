package hoja10;

/**
 * Clase que representa la red de transporte mediante un grafo dirigido
 * usando una matriz de adyacencia.
 */
public class RedTransporte {
    private int[][] matrizAdyacencia;
    private String[] ciudades = {"Ciudad de Guatemala", "Zacapa", "Chiquimula", "Quetzaltenango", "Cobán"};

    /**
     * Inicializa la matriz de adyacencia con los valores de distancia dados.
     */
    public void inicializarRed() {
        int INF = Integer.MAX_VALUE;
        matrizAdyacencia = new int[][] {
            {0, 3, INF, 7, INF},
            {INF, 0, 1, INF, 8},
            {INF, INF, 0, 2, INF},
            {INF, INF, INF, 0, 3},
            {4, INF, INF, INF, 0}
        };
    }

    public int[][] obtenerMatriz() {
        return matrizAdyacencia;
    }

    public String getCiudad(int index) {
        return ciudades[index];
    }

    public int getCantidadCiudades() {
        return ciudades.length;
    }

    public String[] getCiudades() {
        return ciudades;
    }
}
