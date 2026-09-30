/**
 * Actividad 1.2 · un proceso que dice quién es.
 *
 * Lanzándolo dos veces a la vez se ve lo que dice el apartado 01: dos procesos
 * del mismo programa son independientes, cada uno con su PID y su memoria.
 */
public class QuienSoy {

    public static void main(String[] args) throws InterruptedException {

        // ProcessHandle.current() es "el proceso que me está ejecutando a mí".
        // El PID lo asigna el sistema al crearlo, así que cambia en cada ejecución.
        long pid = ProcessHandle.current().pid();

        // Si no le pasan nombre, se pone uno: así el programa no se cae al
        // ejecutarlo sin argumentos.
        String nombre = args.length > 0 ? args[0] : "sin nombre";

        System.out.println("Soy " + nombre + ", PID " + pid);

        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " (" + pid + "): linea " + i);

            // La pausa está para que dé tiempo a ver el entrelazado cuando hay
            // dos copias corriendo. sleep obliga a declarar InterruptedException.
            Thread.sleep(500);
        }

        System.out.println("Adios de " + nombre + ", PID " + pid);
    }
}
