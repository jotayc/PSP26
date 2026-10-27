import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Actividad 7.1 · proceso hijo.
 *
 * Suma las cantidades de UN fichero y escribe el total por su salida estándar.
 * No sabe nada del padre ni de los otros departamentos: recibe un nombre de
 * fichero y escribe un número. Esa independencia es lo que permite lanzar cinco
 * a la vez.
 */
public class SumaFichero {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Uso: java SumaFichero <fichero>");
            System.exit(2);
        }

        long suma = 0;

        // try-with-resources: cierra el lector solo, pase lo que pase.
        // La codificación se indica a mano: si no, cada versión de Java usa una
        // por defecto distinta y el resultado cambiaría de un equipo a otro.
        try (BufferedReader br = new BufferedReader(
                new FileReader(args[0], StandardCharsets.UTF_8))) {

            String linea = br.readLine();
            while (linea != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {          // saltamos las líneas en blanco
                    suma = suma + Long.parseLong(linea);
                }
                linea = br.readLine();
            }

        } catch (IOException e) {
            // Si el fichero no existe, el padre se entera por el código 1.
            System.err.println("No se pudo leer " + args[0] + ": " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Hay una linea que no es un numero en " + args[0]);
            System.exit(3);
        }

        System.out.println(suma);
    }
}
