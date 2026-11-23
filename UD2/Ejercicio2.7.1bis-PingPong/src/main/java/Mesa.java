/**
 * La mesa de ping-pong que comparten los dos jugadores (actividad 7.1 bis): sabe
 * a quién le toca golpear.
 *
 * <p>Se puede usar desde los dos hilos a la vez: los dos métodos son
 * {@code synchronized} sobre este objeto, y su cerrojo protege {@code tocaPing}.</p>
 */
public class Mesa {

    /** {@code true} si le toca al ping y {@code false} si le toca al pong. Empieza el ping. */
    private boolean tocaPing = true;

    /**
     * Espera a que le toque al ping, escribe «ping» y pasa el turno al pong.
     *
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public synchronized void jugarPing() throws InterruptedException {
        // while y no if: al despertar hay que volver a mirar si de verdad le toca.
        while (!tocaPing) {
            wait();
        }
        System.out.println("ping");
        tocaPing = false;
        // El pong puede estar esperando su turno: hay que despertarlo.
        notifyAll();
    }

    /**
     * Espera a que le toque al pong, escribe «pong» y pasa el turno al ping.
     *
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public synchronized void jugarPong() throws InterruptedException {
        while (tocaPing) {
            wait();
        }
        System.out.println("        pong");
        tocaPing = true;
        notifyAll();
    }
}
