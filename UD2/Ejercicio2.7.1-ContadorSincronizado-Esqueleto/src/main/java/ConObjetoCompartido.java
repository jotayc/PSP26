/**
 * Forma 2: un único objeto Contador y una tarea Runnable que ejecutan los
 * cuatro hilos. Solo te falta el run() de la tarea.
 */
public class ConObjetoCompartido {

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        Runnable tarea = new Runnable() {
            @Override
            public void run() {
                // TODO: llama a contador.incrementar() 500_000 veces.
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
