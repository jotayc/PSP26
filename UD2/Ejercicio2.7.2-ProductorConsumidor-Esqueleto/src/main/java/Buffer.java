import java.util.LinkedList;

/**
 * Buffer de capacidad limitada que comparten el productor y el consumidor.
 *
 * <p>Lo usan dos hilos a la vez: tienes que conseguir que ningún carácter se
 * pierda ni se repita, y que cada hilo espere cuando no puede hacer nada.</p>
 */
public class Buffer {

    /** Los caracteres pendientes, del más antiguo al más nuevo. */
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
     * Añade un carácter al final. Si el buffer está lleno, el hilo tiene que
     * esperar, sin gastar procesador, hasta que el consumidor saque alguno.
     *
     * @param letra el carácter que se añade
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public void poner(char letra) throws InterruptedException {
        // TODO 1: mientras el buffer esté lleno, espera.
        // TODO 2: añade la letra al final de la lista.
        // TODO 3: avisa a los hilos que estén esperando.
    }

    /**
     * Saca el carácter más antiguo. Si el buffer está vacío, el hilo tiene que
     * esperar hasta que el productor ponga alguno.
     *
     * @return el carácter más antiguo del buffer
     * @throws InterruptedException si interrumpen al hilo mientras espera
     */
    public char sacar() throws InterruptedException {
        // TODO 1: mientras el buffer esté vacío, espera.
        // TODO 2: saca la primera letra de la lista.
        // TODO 3: avisa a los hilos que estén esperando.
        // TODO 4: devuelve esa letra (y borra la línea de abajo, que solo está
        //         para que el esqueleto compile).
        return '?';
    }
}
