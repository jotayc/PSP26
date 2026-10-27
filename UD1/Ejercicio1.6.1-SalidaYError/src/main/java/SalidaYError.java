import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Actividad 6.1 · los dos flujos del hijo, cada uno a su fichero.
 *
 * Aquí se ve para qué sirve separar System.out de System.err: con los
 * argumentos buenos se llena uno de los ficheros, y con los malos, el otro.
 */
public class SalidaYError {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        System.out.println("=== Con argumentos buenos ===");
        probar(classpath, "3", "7");

        System.out.println();
        System.out.println("=== Con los numeros al reves ===");
        probar(classpath, "7", "3");
    }

    private static void probar(String classpath, String desde, String hasta)
            throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Rango", desde, hasta);

        // Lo que el hijo escriba con System.out irá a parar aquí...
        pb.redirectOutput(new File("resultado.txt"));
        // ...y lo que escriba con System.err, aquí.
        pb.redirectError(new File("errores.txt"));

        Process hijo = pb.start();

        // Sin esta línea los ficheros se leerían vacíos: es el fallo del
        // apartado 05. Primero se espera, y solo después se lee.
        hijo.waitFor();

        System.out.println("  resultado.txt: [" + leer("resultado.txt") + "]");
        System.out.println("  errores.txt:   [" + leer("errores.txt") + "]");
    }

    /**
     * Devuelve el contenido de un fichero de texto, sin espacios sobrantes.
     *
     * @param nombre nombre del fichero, relativo a la carpeta del proyecto
     * @return lo que hubiera dentro, o cadena vacía si el fichero está vacío
     * @throws IOException si el fichero no se puede leer
     */
    private static String leer(String nombre) throws IOException {
        return Files.readString(new File(nombre).toPath()).trim();
    }
}
