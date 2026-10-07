import java.io.IOException;

/**
 * Actividad 4.1 · arrancar otro programa desde el tuyo.
 *
 * Lo que hay que ver aquí es CUÁNDO aparece el mensaje del final: sale sin
 * esperar a que cierres el editor, porque start() devuelve el control enseguida.
 */
public class AbreEditor {

    public static void main(String[] args) throws IOException {

        ProcessBuilder pb;

        // El editor no se llama igual en los dos sistemas, así que preguntamos
        // en cuál estamos. os.name empieza por "Windows" en todos los Windows.
        if (System.getProperty("os.name").startsWith("Windows")) {
            // Cada trozo del comando, en su propio texto. Si se escribiera todo
            // junto, el sistema buscaria un programa llamado "notepad.exe notas.txt".
            pb = new ProcessBuilder("notepad.exe", "notas.txt");
        } else {
            pb = new ProcessBuilder("gedit", "notas.txt");
        }

        // start() lanza IOException si no encuentra el programa. Aquí la dejamos
        // subir con throws: lo que no hay que hacer nunca es capturarla y callarse.
        pb.start();

        // Esta línea se ejecuta inmediatamente, con el editor recién abierto y
        // todavía en pantalla. El padre no espera a nadie.
        System.out.println("Ya lo he lanzado, y no he esperado a que lo cierres");
    }
}
