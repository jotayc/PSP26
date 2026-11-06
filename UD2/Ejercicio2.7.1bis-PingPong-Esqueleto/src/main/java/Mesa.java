/**
 * La mesa de ping-pong que comparten los dos jugadores: sabe a quién le toca
 * golpear.
 *
 * <p>La usan dos hilos a la vez: tienes que conseguir que salga siempre ping,
 * pong, ping, pong…, y que el jugador al que no le toca espere sin gastar
 * procesador.</p>
 */
public class Mesa {

    /** {@code true} si le toca al ping y {@code false} si le toca al pong. Empieza el ping. */
    private boolean tocaPing = true;

    /**
     * Espera a que le toque al ping, escribe «ping» y pasa el turno al pong.
     *
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public void jugarPing() throws InterruptedException {
        // TODO 1: mientras no le toque al ping, espera.
        // TODO 2: escribe "ping".
        // TODO 3: pasa el turno al pong.
        // TODO 4: avisa al otro jugador, que puede estar esperando.
    }

    /**
     * Espera a que le toque al pong, escribe «pong» y pasa el turno al ping.
     *
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public void jugarPong() throws InterruptedException {
        // TODO: lo mismo que jugarPing(), pero para el pong. Escribe "pong" con
        //       unos espacios delante, para distinguirlo en la consola.
    }
}
