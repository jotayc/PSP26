/**
 * Actividad 5.1 · el principal.
 *
 * Tarda unos 6 segundos y no 1+2+3+4+5+6 = 21, porque los seis duermen a la
 * vez: el total es lo que tarda el más lento. Si saliera 21, sería que se espera
 * a cada hilo justo después de arrancarlo.
 */
public class SaludoConEsperas {

    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        Thread[] hilos = new Thread[6];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Saludador(i + 1), "Saludador " + (i + 1));
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        long ms = System.currentTimeMillis() - inicio;
        System.out.println("Total: " + ms + " ms");
    }
}
