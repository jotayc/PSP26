/**
 * Actividad 3.2 · la tarea.
 *
 * run() no recibe parámetros, así que los datos entran por el constructor y se
 * guardan en campos. Cada hilo tendrá su propio objeto CuentaAtras: no comparten
 * nada y no hay nada que proteger.
 */
public class CuentaAtras implements Runnable {

    private final String nombre;
    private final int desde;

    public CuentaAtras(String nombre, int desde) {
        this.nombre = nombre;
        this.desde = desde;
    }

    @Override
    public void run() {
        for (int numero = desde; numero >= 0; numero--) {
            System.out.println(nombre + ": " + numero);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // Si nos interrumpen, nos piden que paremos: terminamos.
                return;
            }
        }
    }
}
