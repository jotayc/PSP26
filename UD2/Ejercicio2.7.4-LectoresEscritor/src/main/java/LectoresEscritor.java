import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Actividad 7.4 · el principal: un escritor y cinco lectores.
 *
 * Fíjate en lo que tarda el escritor en entrar ("tras esperar ... ms"): con cinco
 * lectores que se van relevando, a veces tiene que esperar varios segundos.
 */
public class LectoresEscritor {

    public static void main(String[] args) throws InterruptedException, IOException {
        Path fichero = Path.of("compartido.txt");
        Files.writeString(fichero, "", StandardCharsets.UTF_8);   // empezar con el fichero vacío
        Control control = new Control();

        Thread escritor = new Thread(new Escritor(control, fichero), "escritor");
        Thread[] lectores = new Thread[5];
        escritor.start();
        for (int i = 0; i < lectores.length; i++) {
            lectores[i] = new Thread(new Lector(control, fichero), "lector " + (i + 1));
            lectores[i].start();
        }
        escritor.join();
        for (Thread lector : lectores) {
            lector.join();
        }
        System.out.println("Fin");
    }
}
