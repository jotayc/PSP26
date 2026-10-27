import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad 6.3 · qué pasa cuando dos hijos escriben en el mismo sitio.
 *
 * La conclusión de este ejercicio es la que justifica que en el 7.1 cada hijo
 * tenga su propio fichero.
 */
public class UnSoloFichero {

    private static final String COMUN = "comun.txt";

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        System.out.println("=== Sobrescribiendo (lo normal) ===");
        lanzarDos(classpath, false);
        System.out.println("comun.txt contiene: [" + leerTodo() + "]");

        System.out.println();
        System.out.println("=== En modo anadir ===");
        new File(COMUN).delete();          // empezamos limpio
        lanzarDos(classpath, true);
        System.out.println("comun.txt contiene: [" + leerTodo() + "]");
    }

    /**
     * Lanza dos Rango a la vez con la salida al mismo fichero.
     *
     * @param classpath classpath con el que arrancar a los hijos
     * @param anadir    true para añadir al final, false para sobrescribir
     */
    private static void lanzarDos(String classpath, boolean anadir)
            throws IOException, InterruptedException {

        List<Process> hijos = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "Rango", "1", String.valueOf(i * 100));

            if (anadir) {
                // appendTo() no borra lo que hubiera: escribe a continuación.
                pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(COMUN)));
            } else {
                // Esta forma vacía el fichero al abrirlo. Como los dos hijos lo
                // abren, el segundo se lleva por delante lo del primero.
                pb.redirectOutput(new File(COMUN));
            }
            hijos.add(pb.start());
        }

        for (Process hijo : hijos) {
            hijo.waitFor();
        }
    }

    private static String leerTodo() throws IOException {
        return Files.readString(new File(COMUN).toPath()).trim().replace("\n", " / ");
    }
}
