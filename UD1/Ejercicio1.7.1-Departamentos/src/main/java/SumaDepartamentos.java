import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad 7.1 · proceso padre.
 *
 * Reparte el trabajo entre cinco hijos y junta los resultados. Los tres pasos
 * van en tres bucles separados a propósito; el motivo está comentado abajo.
 */
public class SumaDepartamentos {

    private static final String[] DEPARTAMENTOS = {
        "informatica", "gerencia", "contabilidad", "comercio", "rrhh"
    };

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");
        List<Process> hijos = new ArrayList<>();

        // 1. LANZAR. Un hijo por departamento, cada uno con SU fichero de salida.
        //    Si compartieran fichero se pisarían, como se vio en el ejercicio 6.3.
        for (String dep : DEPARTAMENTOS) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "SumaFichero", dep + ".txt");
            pb.redirectOutput(new File("parcial_" + dep + ".txt"));
            pb.redirectError(new File("error_" + dep + ".txt"));

            // Hay que guardarse el Process que devuelve start(): es la única
            // forma de poder esperarlo después.
            hijos.add(pb.start());
        }

        // 2. ESPERAR. Este bucle va aparte del anterior, y ese es el punto del
        //    ejercicio: si se esperase a cada hijo justo después de lanzarlo,
        //    irían uno detrás de otro y no habría paralelismo ninguno.
        boolean todoBien = true;
        for (int i = 0; i < hijos.size(); i++) {
            int codigo = hijos.get(i).waitFor();
            if (codigo != 0) {
                System.err.println("Fallo en " + DEPARTAMENTOS[i] + " (codigo " + codigo
                        + "), mira error_" + DEPARTAMENTOS[i] + ".txt");
                todoBien = false;
            }
        }
        if (!todoBien) {
            System.err.println("Crea los cinco ficheros .txt antes de ejecutar esto.");
            System.exit(1);
        }

        // 3. LEER. Solo ahora, con todos terminados, los ficheros están completos.
        long total = 0;
        for (String dep : DEPARTAMENTOS) {
            String texto = Files.readString(new File("parcial_" + dep + ".txt").toPath()).trim();
            long parcial = Long.parseLong(texto);
            System.out.println(dep + ": " + parcial);
            total = total + parcial;
        }

        System.out.println("TOTAL: " + total);
    }
}
