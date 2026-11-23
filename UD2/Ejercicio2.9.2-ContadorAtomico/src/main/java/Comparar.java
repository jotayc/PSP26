import java.util.concurrent.atomic.AtomicInteger;

/**
 * Actividad 9.2: las tres versiones del contador, con el mismo trabajo, y lo
 * que tarda cada una.
 *
 * Normalmente: la que falla es la más rápida (no se protege nada, por eso falla),
 * y AtomicInteger es más rápida que synchronized. Los números cambian mucho de un
 * ordenador a otro.
 */
public class Comparar {

    static final int HILOS = 4, VUELTAS = 500_000;

    static int sinProteger = 0;
    static int conCerrojo = 0;
    static final Object CERROJO = new Object();
    static final AtomicInteger atomico = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        long ms = medir(new Runnable() {
            @Override
            public void run() {
                sinProteger++;
            }
        });
        System.out.println("Sin proteger:  " + sinProteger + " en " + ms + " ms");

        ms = medir(new Runnable() {
            @Override
            public void run() {
                synchronized (CERROJO) {
                    conCerrojo++;
                }
            }
        });
        System.out.println("synchronized:  " + conCerrojo + " en " + ms + " ms");

        ms = medir(new Runnable() {
            @Override
            public void run() {
                atomico.incrementAndGet();
            }
        });
        System.out.println("AtomicInteger: " + atomico.get() + " en " + ms + " ms");
    }

    /** Lanza HILOS hilos que hacen VUELTAS veces el incremento y devuelve los ms que tardan. */
    static long medir(Runnable incremento) throws InterruptedException {
        Thread[] hilos = new Thread[HILOS];
        long t0 = System.nanoTime();
        for (int i = 0; i < HILOS; i++) {
            hilos[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int vuelta = 0; vuelta < VUELTAS; vuelta++) {
                        incremento.run();
                    }
                }
            });
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        return (System.nanoTime() - t0) / 1_000_000;
    }
}
