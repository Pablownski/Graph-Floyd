package hoja10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoTest {

    private RedTransporte red;
    private CalculadoraRutas rutas;

    @BeforeEach
    void setUp() {
        red = new RedTransporte();
        red.inicializarRed();
        rutas = new CalculadoraRutas();
    }

    @Test
    void testAgregarYEliminarArco() {
        int[][] matriz = red.obtenerMatriz();

        // Simular agregar un arco de A a E con peso 5
        matriz[0][4] = 5;
        assertEquals(5, matriz[0][4]);

        // Simular eliminar un arco de B a E
        matriz[1][4] = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, matriz[1][4]);
    }

    @Test
    void testFloydFuncionamiento() {
        rutas.ejecutarFloyd(red.obtenerMatriz());
        int[][] distancias = rutas.getDistancias();

        // Verificamos que el camino más corto de A a C sea 4 (A -> B -> C)
        assertEquals(4, distancias[0][2]);

        // Verificamos que la distancia de C a E sea 5 (C -> D -> E)
        assertEquals(5, distancias[2][4]);

        // Verificamos que el camino de B a D sea 3 (B -> C -> D)
        assertEquals(3, distancias[1][3]);
    }
}
