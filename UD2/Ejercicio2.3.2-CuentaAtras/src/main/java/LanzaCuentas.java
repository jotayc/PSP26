/**
 * Actividad 3.2 · el lanzador.
 */
public class LanzaCuentas {

    public static void main(String[] args) {
        new Thread(new CuentaAtras("cohete", 5)).start();
        new Thread(new CuentaAtras("petardo", 3)).start();
    }
}
