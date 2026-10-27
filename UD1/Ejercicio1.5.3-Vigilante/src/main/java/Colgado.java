/** Proceso hijo que no termina nunca: escribe un punto cada segundo. */
public class Colgado {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Colgado arrancado, PID " + ProcessHandle.current().pid());

        // Bucle infinito a propósito: hace falta alguien que lo pare desde fuera.
        while (true) {
            System.out.print(".");
            Thread.sleep(1000);
        }
    }
}
