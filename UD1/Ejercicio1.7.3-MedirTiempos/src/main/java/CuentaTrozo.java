import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Actividad 7.3 · proceso hijo.
 *
 * Cuenta las vocales de UN TROZO del fichero, entre dos posiciones. Así el
 * trabajo se puede partir en tantos trozos como se quiera, en vez de en cinco
 * como en el ejercicio 7.2.
 */
public class CuentaTrozo {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Uso: java CuentaTrozo <fichero> <desde> <cuantos>");
            System.exit(2);
        }

        String fichero = args[0];
        long desde = Long.parseLong(args[1]);
        long cuantos = Long.parseLong(args[2]);
        long cuenta = 0;

        // RandomAccessFile permite empezar a leer por la mitad del fichero,
        // que es justo lo que hace falta para repartirlo en trozos.
        try (RandomAccessFile f = new RandomAccessFile(fichero, "r")) {

            f.seek(desde);
            for (long i = 0; i < cuantos; i++) {
                int b = f.read();
                if (b == -1) {
                    break;               // se acabó el fichero antes de tiempo
                }
                char c = Character.toLowerCase((char) b);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cuenta++;
                }
            }

        } catch (IOException e) {
            System.err.println("No se pudo leer " + fichero + ": " + e.getMessage());
            System.exit(1);
        }

        System.out.println(cuenta);
    }
}
