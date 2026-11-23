import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Actividad 9.1.
 *
 * El trabajo de cada tarea es minúsculo, así que con un hilo por tarea casi todo
 * el tiempo se va en crear diez mil hilos. El pool crea solo cuatro y los
 * reutiliza: tarda bastante menos.
 */
public class DiezMilAreas {

    static final int N = 10_000;

    public static void main(String[] args) throws InterruptedException {
        // Forma 1: un hilo por triángulo.
        long t0 = System.currentTimeMillis();
        Thread[] hilos = new Thread[N];
        for (int i = 0; i < N; i++) {
            hilos[i] = new Thread(new AreaTarea());
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        long ms1 = System.currentTimeMillis() - t0;

        // Forma 2: un pool de 4 hilos.
        long t1 = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < N; i++) {
            pool.execute(new AreaTarea());
        }
        pool.shutdown();                                // sin esto, el programa no terminaría
        pool.awaitTermination(1, TimeUnit.MINUTES);
        long ms2 = System.currentTimeMillis() - t1;

        System.out.println("Un hilo por tarea: " + ms1 + " ms (" + N + " hilos creados)");
        System.out.println("Pool de 4 hilos:   " + ms2 + " ms (4 hilos creados)");
    }
}
