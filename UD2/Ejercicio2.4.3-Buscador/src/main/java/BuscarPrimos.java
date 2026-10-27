/**
 * Actividad 4.3 · el principal.
 */
public class BuscarPrimos {

    public static void main(String[] args) throws InterruptedException {
        Thread buscador = new Thread(new Buscador(), "buscador");
        buscador.start();
        Thread.sleep(2000);
        buscador.interrupt();   // le pide que pare; no lo mata
        buscador.join();        // y esperamos a que termine de verdad
        System.out.println("El buscador ha terminado");
    }
}
