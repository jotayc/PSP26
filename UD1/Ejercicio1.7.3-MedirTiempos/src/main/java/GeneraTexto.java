import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Actividad 7.3 · genera el fichero de pruebas.
 *
 * El fichero no viene con el proyecto porque ocuparía demasiado en el
 * repositorio. Se genera aquí, del tamaño que haga falta para que los tiempos
 * del reparto se puedan medir.
 */
public class GeneraTexto {

    private static final String[] PALABRAS = {
        "proceso", "hilo", "memoria", "fichero", "ejecutable", "sistema",
        "argumento", "salida", "codigo", "planificador", "nucleo", "paralelo"
    };

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Uso: java GeneraTexto <fichero> <megabytes>");
            System.exit(2);
        }

        String fichero = args[0];
        int megas = Integer.parseInt(args[1]);
        long objetivo = megas * 1024L * 1024L;

        Random azar = new Random(7);          // semilla fija: siempre el mismo fichero
        long escrito = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            while (escrito < objetivo) {
                String palabra = PALABRAS[azar.nextInt(PALABRAS.length)];
                bw.write(palabra);
                bw.write(' ');
                escrito += palabra.length() + 1;
            }
        }

        System.out.println("Escrito " + fichero + " con " + escrito + " bytes");
    }
}
