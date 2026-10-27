/**
 * Actividad 4.1 · con start().
 *
 * Ahora sí hay tres hilos nuevos (Thread-0, Thread-1, Thread-2). start() vuelve
 * enseguida, así que el principal escribe su mensaje antes de que los hilos hayan
 * hecho nada, y las vueltas se mezclan.
 */
public class ProbarStart {

    public static void main(String[] args) {
        Thread[] hilos = new Thread[3];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Repetidor("Hilo " + (i + 1)));
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        System.out.println("Fin del principal");
    }
}
