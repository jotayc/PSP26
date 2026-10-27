import java.io.IOException;

/**
 * Actividad 5.2 · leer el código de salida de un hijo.
 *
 * Ojo a una cosa que va al revés que en el ejercicio 7.1: aquí interesa lanzar
 * y esperar UNO A UNO, porque queremos los mensajes en orden. Cuando lo que se
 * busca es paralelismo, se lanzan todos primero y se espera después.
 */
public class ProbadorRango {

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        System.out.println("=== Caso 1: argumentos correctos ===");
        lanzar(classpath, "3", "7");

        System.out.println();
        System.out.println("=== Caso 2: numeros al reves ===");
        lanzar(classpath, "7", "3");

        System.out.println();
        System.out.println("=== Caso 3: sin argumentos ===");
        lanzar(classpath);
    }

    /**
     * Lanza Rango con los argumentos que se le pasen y explica lo que devuelve.
     *
     * @param classpath classpath con el que arrancar al hijo
     * @param numeros   argumentos para Rango: ninguno, uno o dos
     */
    private static void lanzar(String classpath, String... numeros)
            throws IOException, InterruptedException {

        // El comando se monta en dos trozos: la parte fija y los argumentos
        // variables, que pueden ser cero.
        String[] comando = new String[4 + numeros.length];
        comando[0] = "java";
        comando[1] = "-cp";
        comando[2] = classpath;
        comando[3] = "Rango";
        System.arraycopy(numeros, 0, comando, 4, numeros.length);

        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        // waitFor() para el padre hasta que el hijo termine y devuelve su código.
        int codigo = pb.start().waitFor();

        System.out.println("  -> codigo " + codigo + ": " + explica(codigo));
    }

    /**
     * Traduce el código de salida de Rango.
     *
     * @param codigo el que ha devuelto el proceso hijo
     * @return una frase que explica qué ha pasado
     */
    private static String explica(int codigo) {
        // Los significados los inventa cada programa. Lo único que es convenio
        // de todos es que el 0 significa "ha ido bien".
        switch (codigo) {
            case 0:  return "ha ido bien";
            case 1:  return "los numeros estaban al reves";
            case 2:  return "faltaban argumentos";
            default: return "codigo desconocido";
        }
    }
}
