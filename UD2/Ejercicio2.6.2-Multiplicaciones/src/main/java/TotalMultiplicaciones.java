/**
 * Actividad 6.2 · el principal.
 *
 * Se guardan las tareas además de los hilos: después de join() el principal ve
 * todo lo que escribió el hilo, y entonces le pide la cuenta a su tarea.
 */
public class TotalMultiplicaciones {

    public static void main(String[] args) throws InterruptedException {
        Multiplicador[] tareas = new Multiplicador[10];
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < hilos.length; i++) {
            tareas[i] = new Multiplicador();
            hilos[i] = new Thread(tareas[i], "Hilo " + i);
            hilos[i].start();
        }
        int total = 0;
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
            total = total + tareas[i].getHechas();
        }
        System.out.println("Total: " + total + " multiplicaciones");
    }
}
