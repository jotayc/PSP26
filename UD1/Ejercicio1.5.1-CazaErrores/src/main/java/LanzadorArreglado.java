import java.io.IOException;

/**
 * Actividad 5.1 · la versión buena, con los cuatro fallos corregidos.
 */
public class LanzadorArreglado {

    public static void main(String[] args) {
        try {
            String classpath = System.getProperty("java.class.path");

            // ARREGLO 1: cada trozo del comando, en su propio texto.
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "Sumador", "1", "100");

            // ARREGLO 3: el hijo escribe en nuestra misma consola.
            pb.inheritIO();

            Process hijo = pb.start();

            // ARREGLO 4: esperamos de verdad, y de paso nos quedamos con el
            // código de salida para saber si le ha ido bien.
            int codigo = hijo.waitFor();

            System.out.println("El hijo ha sumado, codigo de salida " + codigo);

        } catch (IOException | InterruptedException e) {
            // ARREGLO 2: si algo falla, nos enteramos.
            System.err.println("No se pudo lanzar el hijo: " + e.getMessage());
        }
    }
}
