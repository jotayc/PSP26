/**
 * Actividad 5.2.
 *
 * Dos hilos: uno que trabaja sin parar (RUNNABLE) y otro que duerme
 * (TIMED_WAITING). Para pillarlos en ese estado hay que darles tiempo a llegar:
 * por eso el principal duerme 200 ms antes de preguntar. getState() es una foto
 * de ese momento.
 */
public class VerCuatroEstados {

    public static void main(String[] args) throws InterruptedException {
        // Da vueltas hasta que le pidan que pare (apartado 04).
        Thread ocupado = new Thread(new Runnable() {
            @Override
            public void run() {
                long vueltas = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    vueltas++;
                }
            }
        }, "ocupado");

        Thread dormilon = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }, "dormilon");

        System.out.println("ocupado:  " + ocupado.getState() + "   (creado, sin start)");
        ocupado.start();
        dormilon.start();
        Thread.sleep(200);
        System.out.println("ocupado:  " + ocupado.getState() + "   (dando vueltas: puede ejecutarse)");
        System.out.println("dormilon: " + dormilon.getState() + "   (dentro de sleep(1000))");

        ocupado.interrupt();
        ocupado.join();
        dormilon.join();
        System.out.println("ocupado:  " + ocupado.getState() + "   (su run() ha terminado)");
        System.out.println("dormilon: " + dormilon.getState() + "   (su run() ha terminado)");
    }
}
