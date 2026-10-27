/**
 * Actividad 3.1 · versión implementando Runnable.
 *
 * Diferencias con SaludoThread:
 * - Esta clase podría heredar de otra, porque no gasta su única herencia en Thread.
 * - La tarea no es un hilo: getName() no existe aquí, hay que preguntar
 *   a Thread.currentThread() quién la está ejecutando.
 * - Una sola tarea sirve para los seis hilos: la tarea no tiene campos, así que
 *   compartirla no tiene ningún peligro.
 *
 * En la salida no hay diferencia: en las dos versiones el orden lo decide el
 * planificador y cambia de una ejecución a otra.
 */
public class SaludoRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hola mundo desde " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SaludoRunnable tarea = new SaludoRunnable();
        for (int i = 0; i < 6; i++) {
            new Thread(tarea).start();
        }
    }
}
