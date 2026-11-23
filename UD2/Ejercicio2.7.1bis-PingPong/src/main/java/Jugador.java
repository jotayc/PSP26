/**
 * Actividad 7.1 bis · un jugador: golpea tantas veces como le digan, siempre
 * esperando su turno en la mesa.
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
        try {
            for (int i = 0; i < golpes; i++) {
                // El jugador no comprueba el turno: eso lo hace la mesa, que es
                // lo compartido. Aquí solo se pide golpear.
                if (esPing) {
                    mesa.jugarPing();
                } else {
                    mesa.jugarPong();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrumpido: termino");
        }
    }
}
