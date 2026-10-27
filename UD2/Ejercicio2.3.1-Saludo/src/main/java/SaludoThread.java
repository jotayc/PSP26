/**
 * Actividad 3.1 · versión heredando de Thread.
 *
 * Cada objeto ES un hilo, así que hacen falta seis objetos. El nombre se pide
 * con getName() porque this es el propio hilo.
 */
public class SaludoThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hola mundo desde " + getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new SaludoThread().start();
        }
    }
}
