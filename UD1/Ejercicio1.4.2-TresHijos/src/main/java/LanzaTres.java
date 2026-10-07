import java.io.IOException;

/**
 * Actividad 4.2 · tres procesos hijo corriendo a la vez.
 *
 * Al ejecutarlo varias veces se ve que las líneas de los tres se mezclan y que
 * el orden no es siempre el mismo: quién entra al procesador lo decide el
 * planificador del sistema, no el programa.
 */
public class LanzaTres {

    public static void main(String[] args) throws IOException {

        // Los hijos son clases de ESTE mismo proyecto, así que están compiladas
        // en target/classes. En vez de escribir esa ruta a mano, le pasamos al
        // hijo el mismo classpath con el que se está ejecutando el padre: así
        // funciona igual desde NetBeans y desde la consola.
        String classpath = System.getProperty("java.class.path");

        for (int i = 1; i <= 3; i++) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "QuienSoy", "hijo" + i);

            // inheritIO hace que el hijo escriba en esta misma consola.
            // Sin esto no veríamos nada de lo que escriben.
            pb.inheritIO();

            pb.start();
        }

        // Sale de las primeras, aunque en el código esté la última: los tres
        // start() vuelven enseguida.
        System.out.println("Los tres lanzados");
    }
}
