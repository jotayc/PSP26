import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Actividad 9.2 · el mismo programa, pero que se entera de lo que pasa.
 *
 * Los dos cambios son los que pide el apartado 09: redirigir SIEMPRE la salida
 * de error a un fichero, y comprobar SIEMPRE el código de salida del hijo.
 * Con eso, el motivo del fallo aparece escrito en errores.txt.
 */
public class MisterioResuelto {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Sumadr", "1", "100");
        pb.redirectOutput(new File("salida.txt"));

        // CAMBIO 1: las quejas del hijo, a un fichero. Sin esto se pierden.
        pb.redirectError(new File("errores.txt"));

        Process hijo = pb.start();

        // Dejar rastro: saber qué PID tenía ayuda cuando hay varios hijos.
        System.out.println("Lanzado hijo con PID " + hijo.pid());

        // CAMBIO 2: mirar lo que devuelve, en vez de ignorarlo.
        int codigo = hijo.waitFor();

        if (codigo != 0) {
            System.out.println("El hijo ha fallado con codigo " + codigo + ". Dice esto:");
            System.out.println("  " + Files.readString(new File("errores.txt").toPath()).trim());
        } else {
            System.out.println("salida.txt contiene: ["
                    + Files.readString(new File("salida.txt").toPath()).trim() + "]");
        }
    }
}
