/**
 * El principal: crea el buffer y los dos hilos, los arranca y espera a que
 * terminen. No hace falta tocarlo, salvo los tiempos máximos.
 */
public class ProductorConsumidor {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(6);
        // Productor rápido (200 ms como mucho) y consumidor lento (400 ms).
        // Después cámbialos para que el rápido sea el consumidor.
        Thread productor = new Thread(new Productor(buffer, 15, 200), "productor");
        Thread consumidor = new Thread(new Consumidor(buffer, 15, 400), "consumidor");
        productor.start();
        consumidor.start();
        productor.join();
        consumidor.join();
        System.out.println("Fin: los 15 han pasado por el buffer");
    }
}
