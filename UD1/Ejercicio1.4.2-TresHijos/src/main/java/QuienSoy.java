/** Copia del ejercicio 1.2: aquí hace de proceso hijo. */
public class QuienSoy {

    public static void main(String[] args) throws InterruptedException {
        long pid = ProcessHandle.current().pid();
        String nombre = args.length > 0 ? args[0] : "sin nombre";

        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " (" + pid + "): linea " + i);
            Thread.sleep(500);
        }
    }
}
