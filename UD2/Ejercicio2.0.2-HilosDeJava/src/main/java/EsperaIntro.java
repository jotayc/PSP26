import java.util.Scanner;

/**
 * Actividad 0.2.
 *
 * Tu programa solo usa un hilo, main. Los demás que verás en el Administrador
 * de tareas son de la máquina virtual: el recolector de basura, el compilador
 * que traduce a código máquina las partes más usadas, etc.
 */
public class EsperaIntro {

    public static void main(String[] args) {
        System.out.println("Me ejecuta el hilo: " + Thread.currentThread().getName());

        // Esperar a Intro mantiene vivo el proceso sin gastar procesador:
        // mientras, el hilo main está bloqueado leyendo del teclado.
        System.out.println("Mira ahora sus hilos en el Administrador de tareas. Pulsa Intro para terminar.");
        new Scanner(System.in).nextLine();
    }
}
