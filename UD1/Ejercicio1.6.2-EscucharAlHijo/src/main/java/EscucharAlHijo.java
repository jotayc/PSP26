import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Actividad 6.2 · leer por la tubería lo que escribe el hijo.
 *
 * Ojo al nombre del método: getInputStream() es la ENTRADA DEL PADRE, que es la
 * SALIDA DEL HIJO. Se lee como "por aquí me entra lo que el hijo dice".
 */
public class EscucharAlHijo {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "QuienSoy", "escuchado");
        // Aquí NO se pone inheritIO: si el hijo escribiera directamente en la
        // consola no habría nada que leer.
        Process hijo = pb.start();

        BufferedReader salidaDelHijo =
                new BufferedReader(new InputStreamReader(hijo.getInputStream()));

        // El orden importa: leemos MIENTRAS el hijo escribe, no después.
        // Si esperásemos primero con waitFor() y leyésemos luego, con un hijo
        // que escriba mucho la tubería se llenaría, el hijo se quedaría
        // bloqueado esperando sitio y el padre esperándolo a él. Los dos parados.
        String linea = salidaDelHijo.readLine();
        while (linea != null) {
            System.out.println("[hijo] " + linea);
            linea = salidaDelHijo.readLine();
        }

        // readLine() ha devuelto null, o sea que el hijo ha cerrado su salida.
        // Ahora ya se puede esperar sin riesgo.
        int codigo = hijo.waitFor();
        System.out.println("El hijo ha terminado con codigo " + codigo);
    }
}
