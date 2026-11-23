/**
 * Actividad 6.3 · el principal.
 *
 * El tiempo baja al subir el número de hilos hasta llegar al número de núcleos; a partir de ahí
 * los hilos se turnan en los mismos núcleos y casi no se gana nada.
 */
public class SumaConHilos {

    public static void main(String[] args) throws InterruptedException {
        long n = Long.parseLong(args[0]);          // N del enunciado: hasta dónde se suma
        int numHilos = Integer.parseInt(args[1]);  // K del enunciado

        long inicio = System.currentTimeMillis();
        Tramo[] tramos = new Tramo[numHilos];
        Thread[] hilos = new Thread[numHilos];
        long trozo = n / numHilos;
        for (int i = 0; i < numHilos; i++) {
            long desde = i * trozo + 1;
            // El último llega hasta n: si n no se divide exacto entre numHilos, el resto va con él.
            long hasta = (i == numHilos - 1) ? n : (i + 1) * trozo;
            tramos[i] = new Tramo(desde, hasta);
            hilos[i] = new Thread(tramos[i]);
            hilos[i].start();
        }
        long total = 0;
        for (int i = 0; i < numHilos; i++) {
            hilos[i].join();
            total = total + tramos[i].getSuma();
        }
        long ms = System.currentTimeMillis() - inicio;

        long formula = n * (n + 1) / 2;   // long: con n tan grande no cabe en un int
        System.out.println("Suma con " + numHilos + " hilos: " + total + " en " + ms + " ms");
        System.out.println("Fórmula:            " + formula + (total == formula ? "  (coinciden)" : "  (NO coinciden)"));
    }
}
