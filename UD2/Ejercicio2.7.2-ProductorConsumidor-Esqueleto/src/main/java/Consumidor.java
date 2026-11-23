import java.util.Random;

/**
 * El consumidor: saca del buffer exactamente tantas letras como pone el
 * productor, así los dos terminan y el programa acaba solo.
 */
public class Consumidor implements Runnable {

    private final Buffer buffer;
    private final int cuantos, pausaMax;

    /**
     * @param buffer   el buffer compartido con el productor
     * @param cuantos  cuántas letras saca
     * @param pausaMax milisegundos máximos que duerme entre una letra y la siguiente
     */
    public Consumidor(Buffer buffer, int cuantos, int pausaMax) {
        this.buffer = buffer;
        this.cuantos = cuantos;
        this.pausaMax = pausaMax;
    }

    @Override
    public void run() {
        Random azar = new Random();
        // TODO: repite "cuantos" veces:
        //   - saca una letra del buffer y escribe "        Consumidor saca "
        //     seguido de la letra (con espacios delante, para distinguirlo);
        //   - duerme un tiempo al azar entre 0 y pausaMax milisegundos.
        // Si interrumpen al hilo, escribe "Consumidor interrumpido: termino".
    }
}
