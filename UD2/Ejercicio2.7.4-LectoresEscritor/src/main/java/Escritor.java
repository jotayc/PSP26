import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.Random;

/**
 * Actividad 7.4 · el escritor: añade una línea cinco veces.
 */
public class Escritor implements Runnable {

    private final Control control;
    private final Path fichero;

    public Escritor(Control control, Path fichero) {
        this.control = control;
        this.fichero = fichero;
    }

    @Override
    public void run() {
        Random azar = new Random();
        try {
            for (int i = 1; i <= 5; i++) {
                long antes = System.currentTimeMillis();
                control.empezarEscritura();
                long espera = System.currentTimeMillis() - antes;
                try {
                    String linea = "dato " + i + " escrito a las " + LocalTime.now().withNano(0) + System.lineSeparator();
                    Files.writeString(fichero, linea, StandardCharsets.UTF_8,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("ESCRITOR escribe el dato " + i + " tras esperar " + espera + " ms");
                } catch (IOException e) {
                    System.err.println("El escritor no puede escribir: " + e.getMessage());
                } finally {
                    control.terminarEscritura();
                }
                Thread.sleep(1000 + azar.nextInt(2001));   // de 1 a 3 segundos
            }
        } catch (InterruptedException e) {
            System.out.println("Escritor interrumpido: termino");
        }
    }
}
