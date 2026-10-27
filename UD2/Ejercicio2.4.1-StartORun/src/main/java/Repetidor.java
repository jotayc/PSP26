/**
 * La tarea del apartado 03 de los apuntes: repite su nombre tres veces con
 * una pausa de 100 ms entre una vuelta y otra.
 */
public class Repetidor implements Runnable {

    private final String quien;

    public Repetidor(String quien) {
        this.quien = quien;
    }

    @Override
    public void run() {
        for (int vuelta = 1; vuelta <= 3; vuelta++) {
            System.out.println(quien + ": vuelta " + vuelta + "   (lo escribe " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
