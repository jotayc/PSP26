/**
 * Actividad 4.1 · con run().
 *
 * hilo.run() es una llamada normal a un método: la ejecuta main y no se crea ningún
 * hilo. Por eso todo sale en orden (hilo 1 entero, después el 2, después el 3),
 * cada línea dice que la escribe main, y el mensaje final sale el último.
 */
public class ProbarRun {

    public static void main(String[] args) {
        Thread[] hilos = new Thread[3];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Repetidor("Hilo " + (i + 1)));
        }
        for (Thread hilo : hilos) {
            hilo.run();
        }
        System.out.println("Fin del principal");
    }
}
