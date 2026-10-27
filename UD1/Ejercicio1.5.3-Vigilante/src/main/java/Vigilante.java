import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Actividad 5.3 · esperar con un límite y parar al hijo.
 *
 * waitFor() a secas dejaría al padre esperando para siempre. La versión con
 * tiempo límite devuelve true o false según haya terminado o no.
 */
public class Vigilante {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Colgado");
        pb.inheritIO();
        Process hijo = pb.start();

        System.out.println("Le doy tres segundos...");

        // Devuelve false si se agota el tiempo antes de que termine el hijo.
        boolean haTerminado = hijo.waitFor(3, TimeUnit.SECONDS);

        if (!haTerminado) {
            System.out.println();
            System.out.println("Tarda demasiado: lo paro");

            // destroy() le pide al proceso que termine.
            hijo.destroy();

            // Después de pedirlo todavía tarda un poco en morir, así que hay que
            // esperar otra vez. Si se pide exitValue() aquí sin esperar, salta
            // IllegalThreadStateException.
            hijo.waitFor();
        }

        // exitValue() devuelve el código sin esperar, y solo vale cuando ya
        // sabemos que el proceso ha terminado.
        System.out.println("Codigo de salida: " + hijo.exitValue());
    }
}
