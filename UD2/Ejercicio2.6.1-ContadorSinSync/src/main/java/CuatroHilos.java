/**
 * Actividad 6.1.
 *
 * Con 5000 vueltas casi siempre sale bien: cada hilo termina antes de que arranque
 * el siguiente y no llegan a solaparse. Con 500000 se solapan y se pierden sumas,
 * cada vez un número distinto. La sección crítica es el cuenta++ de Contador.
 */
public class CuatroHilos {

    public static void main(String[] args) throws InterruptedException {
        int vueltas = args.length > 0 ? Integer.parseInt(args[0]) : 5000;
        Contador contador = new Contador();          // UN objeto para los cuatro

        Runnable tarea = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < vueltas; i++) {
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
        System.out.println("Cuenta: " + contador.getCuenta() + " (esperaba " + 4 * vueltas + ")");
    }
}
