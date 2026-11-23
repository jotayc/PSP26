/**
 * Un contador SIN proteger: incrementar() son tres pasos (leer, sumar, escribir)
 * y otro hilo se puede colar entre ellos.
 */
public class Contador {

    private int cuenta = 0;

    public void incrementar() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}
