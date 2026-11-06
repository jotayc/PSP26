/**
 * Un jugador: golpea tantas veces como le digan, siempre esperando su turno en
 * la mesa.
 */
public class Jugador implements Runnable {

    private final Mesa mesa;
    private final boolean esPing;
    private final int golpes;

    /**
     * @param mesa   la mesa que comparte con el otro jugador
     * @param esPing {@code true} para el jugador del ping y {@code false} para el del pong
     * @param golpes cuántas veces golpea
     */
    public Jugador(Mesa mesa, boolean esPing, int golpes) {
        this.mesa = mesa;
        this.esPing = esPing;
        this.golpes = golpes;
    }

    @Override
    public void run() {
        // TODO: repite "golpes" veces: si es el jugador del ping, llama a
        //       mesa.jugarPing(); si no, a mesa.jugarPong().
        // Si interrumpen al hilo, escribe su nombre seguido de
        // " interrumpido: termino".
    }
}
