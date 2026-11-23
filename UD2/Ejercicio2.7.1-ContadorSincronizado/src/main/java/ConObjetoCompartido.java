/**
 * Actividad 7.1 · forma 2: un objeto Contador compartido y una tarea Runnable.
 *
 * Los cuatro hilos llaman a incrementar() sobre el mismo objeto, así que todos
 * cogen el mismo cerrojo: siempre sale 2000000.
 */
public class ConObjetoCompartido {

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        Runnable tarea = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500_000; i++) {
                    contador.incrementar();
                }
            }
        };
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(tarea);
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Cuenta: " + contador.getCuenta() + " (esperaba 2000000)");
    }
}
