/**
 * Actividad 8.2 · un programa que consume procesador.
 *
 * No hace nada útil a propósito: está para que se le pueda cambiar la prioridad
 * y ver el efecto en el monitor del sistema.
 */
public class Bucle {

    public static void main(String[] args) {

        String nombre = args.length > 0 ? args[0] : "bucle";
        long pid = ProcessHandle.current().pid();

        System.out.println(nombre + " arrancado, PID " + pid);

        long vueltas = 0;
        long inicio = System.currentTimeMillis();

        // Treinta segundos dando vueltas sin parar: tiempo de sobra para
        // mirarlo en el Administrador de tareas o en top.
        while (System.currentTimeMillis() - inicio < 30000) {
            vueltas++;
            Math.sqrt(vueltas);      // algo que el compilador no pueda quitar
        }

        System.out.println(nombre + " ha dado " + vueltas + " vueltas en 30 segundos");
    }
}
