/**
 * Actividad 4.3 · la tarea.
 *
 * Aquí no hay sleep, así que nunca salta InterruptedException: la petición de
 * parar solo se nota si el hilo mira la marca. Se mira en la condición del bucle,
 * una vez por número, que es suficiente para parar casi en el momento.
 */
public class Buscador implements Runnable {

    @Override
    public void run() {
        long encontrados = 0, ultimo = 0;
        long candidato = 2;
        while (!Thread.currentThread().isInterrupted()) {
            if (esPrimo(candidato)) {
                encontrados++;
                ultimo = candidato;
            }
            candidato++;
        }
        // Salir de run() es terminar el hilo, y con todo en orden.
        System.out.println("Encontrados " + encontrados + " primos; el último, " + ultimo);
    }

    private static boolean esPrimo(long numero) {
        for (long divisor = 2; divisor * divisor <= numero; divisor++) {
            if (numero % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
