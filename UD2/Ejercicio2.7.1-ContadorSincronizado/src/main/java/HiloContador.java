/**
 * Actividad 7.1 · forma 1, ARREGLADA.
 *
 * Todos los hilos tienen que coger el cerrojo del MISMO objeto. Como cada hilo es
 * un objeto distinto, se añade uno compartido (static, así hay uno para todos) y
 * se protege la sección crítica con un bloque synchronized sobre él.
 */
public class HiloContador extends Thread {

    private static int cuenta = 0;
    private static final Object CERROJO = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 500_000; i++) {
            synchronized (CERROJO) {
                cuenta++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HiloContador[] hilos = new HiloContador[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloContador();
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        // Leer cuenta después de join() es seguro: join() garantiza que vemos
        // todo lo que escribieron los hilos.
        System.out.println("Cuenta: " + cuenta + " (esperaba 2000000)");
    }
}
