import java.util.Random;

/**
 * El productor: pone en el buffer tantas letras como le digan, de la 'A' en
 * adelante.
 */
public class Productor implements Runnable {

    private final Buffer buffer;
    private final int cuantos, pausaMax;

    /**
     * @param buffer   el buffer compartido con el consumidor
     * @param cuantos  cuántas letras pone
     * @param pausaMax milisegundos máximos que duerme entre una letra y la siguiente
     */
    public Productor(Buffer buffer, int cuantos, int pausaMax) {
        this.buffer = buffer;
        this.cuantos = cuantos;
        this.pausaMax = pausaMax;
    }

    @Override
    public void run() {
        Random azar = new Random();
        // TODO: repite "cuantos" veces:
        //   - calcula la letra: la primera vez 'A', después 'B', 'C'...
        //   - ponla en el buffer y escribe "Productor pone " seguido de la letra;
        //   - duerme un tiempo al azar entre 0 y pausaMax milisegundos.
        // Si interrumpen al hilo, escribe "Productor interrumpido: termino".
    }
}
