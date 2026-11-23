import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

/**
 * Actividad 7.4 · un lector: lee el fichero entero cuatro veces.
 */
public class Lector implements Runnable {

    private final Control control;
    private final Path fichero;

    public Lector(Control control, Path fichero) {
        this.control = control;
        this.fichero = fichero;
    }

    @Override
    public void run() {
        Random azar = new Random();
        String yo = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 4; i++) {
                control.empezarLectura();
                try {
                    List<String> lineas = Files.readAllLines(fichero, StandardCharsets.UTF_8);
                    System.out.println(yo + " lee " + lineas.size() + " líneas (leyendo ahora: " + control.getLeyendo() + ")");
                } catch (IOException e) {
                    System.err.println(yo + " no puede leer: " + e.getMessage());
                } finally {
                    // finally: si la lectura falla, hay que salir igual o el escritor esperaría siempre.
                    control.terminarLectura();
                }
                Thread.sleep(2000 + azar.nextInt(3001));   // de 2 a 5 segundos: duerme el hilo, no el procesador
            }
        } catch (InterruptedException e) {
            System.out.println(yo + " interrumpido: termino");
        }
    }
}
