import java.util.Random;

/**
 * Actividad 7.2 · el consumidor: saca exactamente tantos como pone el productor,
 * así los dos terminan y el programa acaba solo.
 */
public class Consumidor implements Runnable {

    private final Buffer buffer;
    private final int cuantos, pausaMax;

    public Consumidor(Buffer buffer, int cuantos, int pausaMax) {
        this.buffer = buffer;
        this.cuantos = cuantos;
        this.pausaMax = pausaMax;
    }

    @Override
    public void run() {
        Random azar = new Random();
        try {
            for (int i = 0; i < cuantos; i++) {
                char letra = buffer.sacar();
                System.out.println("        Consumidor saca " + letra);
                Thread.sleep(azar.nextInt(pausaMax + 1));
            }
        } catch (InterruptedException e) {
            System.out.println("Consumidor interrumpido: termino");
        }
    }
}
