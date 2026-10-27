import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad 7.2 · proceso padre.
 *
 * Mismo esqueleto que el ejercicio 7.1: lanzar todos, esperar a todos, y leer
 * al final. Lo único que cambia es el trabajo que hace cada hijo.
 */
public class ContadorVocales {

    private static final String[] VOCALES = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length != 1) {
            System.err.println("Uso: java ContadorVocales <fichero>");
            System.exit(2);
        }
        String fichero = args[0];
        String classpath = System.getProperty("java.class.path");

        // 1. Lanzar los cinco, cada uno con su vocal y su fichero de salida.
        List<Process> hijos = new ArrayList<>();
        for (String vocal : VOCALES) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "CuentaVocal", fichero, vocal);
            pb.redirectOutput(new File("vocal_" + vocal + ".txt"));
            pb.redirectError(new File("error_" + vocal + ".txt"));
            hijos.add(pb.start());
        }

        // 2. Esperar a todos antes de leer nada.
        for (int i = 0; i < hijos.size(); i++) {
            if (hijos.get(i).waitFor() != 0) {
                System.err.println("Fallo contando la " + VOCALES[i]
                        + ", mira error_" + VOCALES[i] + ".txt");
                System.exit(1);
            }
        }

        // 3. Recoger los cinco parciales.
        long total = 0;
        for (String vocal : VOCALES) {
            String texto = Files.readString(new File("vocal_" + vocal + ".txt").toPath()).trim();
            long n = Long.parseLong(texto);
            System.out.println(vocal + ": " + n);
            total = total + n;
        }

        System.out.println("TOTAL: " + total);
    }
}
