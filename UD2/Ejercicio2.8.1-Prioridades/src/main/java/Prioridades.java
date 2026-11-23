/**
 * Actividad 8.1.
 *
 * Resultados esperables:
 * - Windows, con más hilos ocupados que núcleos: los de prioridad mínima apenas
 *   avanzan, o nada. Es inanición.
 * - Con tantos hilos como núcleos (o menos): cada hilo tiene su núcleo y las dos
 *   prioridades dan números parecidos.
 * - GNU/Linux con la configuración normal: la máquina virtual ignora las
 *   prioridades y los dos grupos salen parecidos.
 * Conclusión: la prioridad no garantiza nada.
 */
public class Prioridades {

    static volatile boolean seguir = true;   // volatile: el aviso de parar lo tienen que ver todos

    static class Contador implements Runnable {
        long cuenta = 0;

        @Override
        public void run() {
            while (seguir) {
                cuenta++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Sin esto, en Windows el principal (prioridad 5) puede no conseguir turno
        // para despertar de su sleep con todos los núcleos ocupados por hilos de
        // prioridad 10, y el programa no termina nunca.
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        int nucleos = Runtime.getRuntime().availableProcessors();
        int numHilos = args.length > 0 ? Integer.parseInt(args[0]) : nucleos * 2;
        Contador[] tareas = new Contador[numHilos];
        Thread[] hilos = new Thread[numHilos];
        for (int i = 0; i < numHilos; i++) {
            tareas[i] = new Contador();
            hilos[i] = new Thread(tareas[i]);
            hilos[i].setPriority(i % 2 == 0 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        Thread.sleep(2000);
        seguir = false;

        long minimas = 0, maximas = 0;
        for (int i = 0; i < numHilos; i++) {
            hilos[i].join();
            if (i % 2 == 0) {
                minimas += tareas[i].cuenta;
            } else {
                maximas += tareas[i].cuenta;
            }
        }
        System.out.println("Núcleos: " + nucleos + ", hilos: " + numHilos);
        System.out.printf("Prioridad mínima: %,d vueltas%n", minimas);
        System.out.printf("Prioridad máxima: %,d vueltas%n", maximas);
    }
}
