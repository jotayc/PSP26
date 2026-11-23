/**
 * Actividad 7.1 · forma 2: el contador protegido.
 *
 * Los dos métodos son synchronized: incrementar() para que los tres pasos de
 * cuenta++ vayan seguidos, y getCuenta() para ver siempre el último valor escrito.
 */
public class Contador {

    private int cuenta = 0;

    public synchronized void incrementar() {
        cuenta++;
    }

    public synchronized int getCuenta() {
        return cuenta;
    }
}
