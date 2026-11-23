/**
 * Actividad 7.3 · la versión que se BLOQUEA.
 *
 * Cada hilo coge primero el cerrojo de su origen y luego el de su destino. Si los
 * dos cogen su origen a la vez, cada uno espera el que tiene el otro: un ciclo.
 * Sin la pausa también pasa, pero solo a veces, y eso es peor: puede funcionar en
 * tus pruebas y bloquearse un día cualquiera.
 */
public class BancoBloqueado {

    static boolean conPausa = true;

    static void transferir(Cuenta origen, Cuenta destino, int cantidad) {
        synchronized (origen) {
            pausa();
            synchronized (destino) {
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
