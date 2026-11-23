import java.util.Random;

/**
 * Actividad 6.2 · la tarea.
 *
 * Cada multiplicador cuenta en SU campo. Ningún hilo escribe en el objeto de
 * otro, así que no hay nada compartido que se pueda pisar y no hace falta
 * sincronizar nada.
 */
public class Multiplicador implements Runnable {

    private int hechas = 0;

    @Override
    public void run() {
        int veces = (1 + new Random().nextInt(5)) * 100;
        for (int i = 0; i < veces; i++) {
            int producto = i * 3;      // la multiplicación del enunciado; el resultado no se usa
            hechas++;
        }
        System.out.println(Thread.currentThread().getName() + ": " + hechas + " multiplicaciones");
    }

    public int getHechas() {
        return hechas;
    }
}
