package hoja10;
/**
 * Clase que gestiona el sistema de rutas de transporte usando las demás clases del proyecto.
 */
public class GestorTransporte {
    private  RedTransporte red;
    private  CalculadoraRutas calculadora;
    private  AnalizadorCentro analizador;

    public GestorTransporte() {
        red = new RedTransporte();
        calculadora = new CalculadoraRutas();
        analizador = new AnalizadorCentro();
    }

    public void ejecutarSistema() {
        red.inicializarRed();
        calculadora.ejecutarFloyd(red.obtenerMatriz());
    }

    public RedTransporte getRed() {
        return red;
    }

    public CalculadoraRutas getCalculadora() {
        return calculadora;
    }

    public AnalizadorCentro getAnalizador() {
        return analizador;
    }
}
