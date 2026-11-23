/**
 * Actividad 7.3 · la versión ARREGLADA.
 *
 * Se cogen los cerrojos siempre en el mismo orden. El total no cambia porque cada
 * transferencia saca y mete la misma cantidad con las dos cuentas bloqueadas.
 */
public class BancoOrdenado {

    static boolean conPausa = true;

    static void transferir(Cuenta origen, Cuenta destino, int cantidad) {
        // Primero, siempre el cerrojo de la cuenta que va antes por nombre, sea el
        // origen o el destino. Así nadie espera la primera teniendo ya la segunda.
        Cuenta primera = origen.getNombre().compareTo(destino.getNombre()) < 0 ? origen : destino;
        Cuenta segunda = (primera == origen) ? destino : origen;
        synchronized (primera) {
            pausa();
            synchronized (segunda) {
                origen.sacar(cantidad);
                destino.ingresar(cantidad);
            }
        }
    }

    static void pausa() {
        if (!conPausa) {
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        conPausa = !(args.length > 0 && args[0].equals("sinpausa"));
        Cuenta ana = new Cuenta("Ana", 1000);
        Cuenta luis = new Cuenta("Luis", 1000);
        Cuenta[] todas = {ana, luis};
        System.out.println("Total al principio: " + total(todas));

        // Cien transferencias en cada sentido, cada sentido en su hilo.
        // Con nombre, para que el volcado de hilos (actividad 10.1) se lea bien.
        Thread[] hilos = {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    repetir(ana, luis);
                }
            }, "de Ana a Luis"),
            new Thread(new Runnable() {
                @Override
                public void run() {
                    repetir(luis, ana);
                }
            }, "de Luis a Ana")
        };
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Total al final:     " + total(todas));
    }

    static void repetir(Cuenta origen, Cuenta destino) {
        for (int i = 0; i < 100; i++) {
            transferir(origen, destino, 10);
        }
    }

    static int total(Cuenta[] cuentas) {
        int suma = 0;
        for (Cuenta cuenta : cuentas) {
            suma = suma + cuenta.getSaldo();
        }
        return suma;
    }
}
