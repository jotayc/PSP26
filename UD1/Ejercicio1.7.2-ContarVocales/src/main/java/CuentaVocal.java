import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Actividad 7.2 · proceso hijo.
 *
 * Cuenta las apariciones de UNA vocal en un fichero y escribe el total por su
 * salida estándar. Recibe dos argumentos: el fichero y la vocal que le toca.
 */
public class CuentaVocal {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Uso: java CuentaVocal <fichero> <vocal>");
            System.exit(2);
        }

        // Pasamos la vocal a minúscula una sola vez, fuera del bucle.
        char vocal = Character.toLowerCase(args[1].charAt(0));
        long cuenta = 0;

        // Codificación explícita: así el recuento es el mismo en cualquier equipo.
        try (BufferedReader br = new BufferedReader(
                new FileReader(args[0], StandardCharsets.UTF_8))) {

            // read() devuelve un carácter cada vez, o -1 cuando se acaba el fichero.
            int c = br.read();
            while (c != -1) {
                // Comparando en minúsculas contamos igual "A" que "a".
                if (Character.toLowerCase((char) c) == vocal) {
                    cuenta++;
                }
                c = br.read();
            }

        } catch (IOException e) {
            System.err.println("No se pudo leer " + args[0] + ": " + e.getMessage());
            System.exit(1);
        }

        System.out.println(cuenta);
    }
}
