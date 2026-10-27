import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Actividad 9.2 · el programa que falla en silencio.
 *
 * Ejecútalo: no da ningún error, escribe "Terminado" y salida.txt se queda
 * vacío. Averigua por qué antes de mirar MisterioResuelto.
 */
public class Misterio {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Sumadr", "1", "100");
        pb.redirectOutput(new File("salida.txt"));

        Process hijo = pb.start();
        hijo.waitFor();

        System.out.println("Terminado");
        System.out.println("salida.txt contiene: ["
                + Files.readString(new File("salida.txt").toPath()).trim() + "]");
    }
}
