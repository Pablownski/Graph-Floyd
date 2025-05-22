package hoja10;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        GestorTransporte gestor = new GestorTransporte();
        gestor.ejecutarSistema();

        RedTransporte red = gestor.getRed();
        CalculadoraRutas calc = gestor.getCalculadora();

        int[][] distancias = calc.getDistancias();
        String[] ciudades = red.getCiudades();

        System.out.println("\nMatriz de distancias mínimas:");
        System.out.print("      ");
        for (String ciudad : ciudades) {
            System.out.printf("%20s", ciudad);
        }
        System.out.println();

        for (int i = 0; i < distancias.length; i++) {
            System.out.printf("%-6s", ciudades[i]);
            for (int j = 0; j < distancias.length; j++) {
                if (distancias[i][j] >= Integer.MAX_VALUE / 2) {
                    System.out.printf("%20s", "-");
                } else {
                    System.out.printf("%20d", distancias[i][j]);
                }
            }
            System.out.println();
        }

        int centro = gestor.getAnalizador().calcularCentro(distancias);
        System.out.println("\nCentro del grafo: " + ciudades[centro]);

        int origen = 0; // Ciudad de Guatemala
        for (int destino = 0; destino < red.getCantidadCiudades(); destino++) {
            if (origen != destino) {
                List<Integer> camino = calc.obtenerCamino(origen, destino);
                System.out.print("Ruta de " + red.getCiudad(origen) + " a " + red.getCiudad(destino) + ": ");
                if (camino.isEmpty()) {
                    System.out.println("No hay ruta.");
                } else {
                    for (int idx = 0; idx < camino.size(); idx++) {
                        System.out.print(red.getCiudad(camino.get(idx)));
                        if (idx < camino.size() - 1) System.out.print(" -> ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
    
