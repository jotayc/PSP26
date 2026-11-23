import java.util.LinkedList;

/**
 * Buffer de capacidad limitada para pasar caracteres de unos hilos a otros
 * (actividades 7.2 y 10.2).
 *
 * <p>Se puede usar desde varios hilos a la vez sin protegerlo desde fuera: todos
 * los métodos que tocan la lista son {@code synchronized} sobre este objeto, y su
 * cerrojo protege {@code datos}.</p>
 */
public class Buffer {

    /** Los caracteres pendientes, del más antiguo al más nuevo. Protegido por el cerrojo de este objeto. */
    private final LinkedList<Character> datos = new LinkedList<>();
    private final int capacidad;

    /**
     * Crea un buffer vacío.
     *
     * @param capacidad cuántos caracteres caben como máximo
     */
    public Buffer(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Añade un carácter al final. Si el buffer está lleno, el hilo espera, sin
     * gastar procesador, hasta que alguien saque uno.
     *
     * @param letra el carácter que se añade
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public synchronized void poner(char letra) throws InterruptedException {
        // while y no if: al despertar, otro productor podría haber llenado el hueco.
        while (datos.size() == capacidad) {
            wait();
        }
        datos.addLast(letra);
        // notifyAll y no notify: si esperan productores y consumidores, notify
        // podría despertar justo a uno que no puede hacer nada.
        notifyAll();
    }

    /**
     * Saca el carácter más antiguo. Si el buffer está vacío, el hilo espera hasta
     * que alguien ponga uno.
     *
     * @return el carácter más antiguo del buffer
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public synchronized char sacar() throws InterruptedException {
        while (datos.isEmpty()) {
            wait();
        }
        char letra = datos.removeFirst();
        notifyAll();
        return letra;
    }
}
