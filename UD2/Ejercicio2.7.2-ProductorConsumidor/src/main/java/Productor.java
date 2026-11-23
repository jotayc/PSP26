import java.util.Random;

/**
 * Actividad 7.2 · el productor: pone n letras, de la 'A' en adelante.
 */
public class Productor implements Runnable {

    private final Buffer buffer;
    private final int cuantos, pausaMax;

    public Productor(Buffer buffer, int cuantos, int pausaMax) {
        this.buffer = buffer;
        this.cuantos = cuantos;
        this.pausaMax = pausaMax;
    }

    @Override
    public void run() {
        Random azar = new Random();
        try {
            for (int i = 0; i < cuantos; i++) {
                char letra = (char) ('A' + i);
                buffer.poner(letra);
                System.out.println("Productor pone " + letra);
                Thread.sleep(azar.nextInt(pausaMax + 1));
            }
        } catch (InterruptedException e) {
            System.out.println("Productor interrumpido: termino");
        }
    }
}
