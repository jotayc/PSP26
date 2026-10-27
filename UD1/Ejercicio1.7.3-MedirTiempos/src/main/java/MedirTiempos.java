import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad 7.3 · cuánto se gana de verdad al repartir.
 *
 * Recibe el fichero y cuántos procesos usar. Mide el tiempo TOTAL, incluido lo
 * que cuesta arrancar los hijos, que es justo la parte que hace que repartir
 * deje de compensar a partir de cierto número.
 */
public class MedirTiempos {

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length != 2) {
            System.err.println("Uso: java MedirTiempos <fichero> <numero de procesos>");
            System.exit(2);
        }

        String fichero = args[0];
        int procesos = Integer.parseInt(args[1]);
        long tamano = new File(fichero).length();
        String classpath = System.getProperty("java.class.path");

        // El cronómetro arranca ANTES de lanzar nada: el arranque de cada
        // máquina virtual también es tiempo que tarda el programa.
        long inicio = System.currentTimeMillis();

        long trozo = tamano / procesos;
        List<Process> hijos = new ArrayList<>();

        for (int i = 0; i < procesos; i++) {
            long desde = i * trozo;
            // Al último le toca el resto, por si la división no era exacta.
            long cuantos = (i == procesos - 1) ? tamano - desde : trozo;

            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "CuentaTrozo",
                    fichero, String.valueOf(desde), String.valueOf(cuantos));
            pb.redirectOutput(new File("trozo_" + i + ".txt"));
            pb.redirectError(new File("error_" + i + ".txt"));
            hijos.add(pb.start());
        }

        for (Process hijo : hijos) {
            hijo.waitFor();
        }

        long total = 0;
        for (int i = 0; i < procesos; i++) {
            total += Long.parseLong(
                    Files.readString(new File("trozo_" + i + ".txt").toPath()).trim());
        }

        long fin = System.currentTimeMillis();

        System.out.println("Procesos: " + procesos
                + "   Vocales: " + total
                + "   Tiempo: " + (fin - inicio) + " ms");
    }
}
