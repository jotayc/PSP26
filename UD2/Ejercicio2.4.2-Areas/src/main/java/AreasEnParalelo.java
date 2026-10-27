import java.util.Random;

/**
 * Actividad 4.2 · el principal.
 */
public class AreasEnParalelo {

    public static void main(String[] args) throws InterruptedException {
        Random azar = new Random();
        Thread[] hilos = new Thread[10];

        // 1. Lanzar todos.
        for (int i = 0; i < hilos.length; i++) {
            int base = 1 + azar.nextInt(10);
            int altura = 1 + azar.nextInt(10);
            hilos[i] = new Thread(new Triangulo(base, altura));
            hilos[i].start();
        }
        // 2. Esperar a todos. En un bucle aparte: si se esperase a cada uno nada
        //    más arrancarlo, irían uno detrás de otro.
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Calculadas las 10 áreas");
    }
}
