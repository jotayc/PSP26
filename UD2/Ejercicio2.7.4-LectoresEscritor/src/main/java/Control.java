/**
 * Actividad 7.4 · el control de acceso al fichero.
 *
 * Prioridad a los lectores: el escritor no entra mientras haya algún lector
 * leyendo o esperando para leer. Con muchos lectores que se van turnando, el
 * escritor puede pasarse mucho tiempo sin entrar: INANICIÓN. El programa sigue
 * funcionando, pero el escritor no avanza.
 */
public class Control {

    private int leyendo = 0;          // lectores dentro
    private int esperandoLeer = 0;    // lectores que quieren entrar
    private boolean escribiendo = false;

    public synchronized void empezarLectura() throws InterruptedException {
        esperandoLeer++;
        // Un lector solo espera si el escritor está dentro.
        while (escribiendo) {
            wait();
        }
        esperandoLeer--;
        leyendo++;
    }

    public synchronized void terminarLectura() {
        leyendo--;
        notifyAll();                  // por si el escritor esperaba a que no quedara nadie
    }

    public synchronized void empezarEscritura() throws InterruptedException {
        // El escritor espera mientras haya lectores dentro o esperando (la prioridad),
        // o mientras otro escriba.
        while (escribiendo || leyendo > 0 || esperandoLeer > 0) {
            wait();
        }
        escribiendo = true;
    }

    public synchronized void terminarEscritura() {
        escribiendo = false;
        notifyAll();                  // despierta a los lectores que esperaban
    }

    public synchronized int getLeyendo() {
        return leyendo;
    }
}
