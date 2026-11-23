/**
 * Actividad 5.1 · la tarea.
 */
public class Saludador implements Runnable {

    private final int segundos;

    public Saludador(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Hola mundo desde " + Thread.currentThread().getName());
    }
}
