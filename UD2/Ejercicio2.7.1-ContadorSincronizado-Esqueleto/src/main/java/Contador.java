/**
 * Forma 2: el contador de la 6.1, que comparten los cuatro hilos.
 *
 * <p>Tal como está, se pierden sumas: cuenta++ son tres pasos (leer, sumar,
 * escribir) y otro hilo se puede colar entre ellos.</p>
 */
public class Contador {

    private int cuenta = 0;

    // TODO: protege los dos métodos para que se puedan usar desde varios hilos
    //       a la vez.

    public void incrementar() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}
