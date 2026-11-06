/**
 * Forma 1: cuatro hilos que heredan de Thread y suman en un campo static.
 *
 * <p>Hazla tal como dice el enunciado y ejecútala varias veces. Si falla,
 * averigua por qué y arréglala aquí mismo.</p>
 */
public class HiloContador extends Thread {

    /** La cuenta. Al ser static hay una sola, compartida por los cuatro hilos. */
    private static int cuenta = 0;

    /** Suma uno a la cuenta. */
    private void incrementar() {
        // TODO 1: suma uno a cuenta.
        // TODO 2: haz que este método sea synchronized.
    }

    @Override
    public void run() {
        // TODO: llama a incrementar() 500_000 veces.
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
        System.out.println("Cuenta: " + cuenta + " (esperaba 2000000)");
    }
}
