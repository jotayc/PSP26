/**
 * Actividad 7.1 · forma 1, la que SIGUE FALLANDO.
 *
 * incrementar() es synchronized, pero un método synchronized coge el cerrojo del
 * objeto sobre el que se llama, y aquí cada hilo es un objeto distinto: hay
 * cuatro cerrojos y cada hilo coge el suyo. Nunca se esperan, así que es como no
 * tener ninguno. El campo static, en cambio, sí es uno solo: se pierden sumas.
 */
public class HiloContadorMal extends Thread {

    private static int cuenta = 0;

    private synchronized void incrementar() {
        cuenta++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500_000; i++) {
            incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HiloContadorMal[] hilos = new HiloContadorMal[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloContadorMal();
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Cuenta: " + cuenta + " (esperaba 2000000)");
    }
}
