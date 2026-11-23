/**
 * Actividad 6.3 · la tarea: sumar un tramo.
 */
public class Tramo implements Runnable {

    private final long desde, hasta;
    private long suma;            // cada hilo escribe solo en su tramo

    public Tramo(long desde, long hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public void run() {
        long parcial = 0;
        for (long i = desde; i <= hasta; i++) {
            parcial = parcial + i;
        }
        suma = parcial;
    }

    public long getSuma() {
        return suma;
    }
}
