/**
 * Actividad 7.2 · el principal.
 *
 * Cambiando los dos tiempos máximos se ve cada caso: con el productor rápido, el
 * buffer se llena y espera el productor; con el consumidor rápido, el buffer se
 * vacía y espera el consumidor. Ninguno da vueltas preguntando: los dos esperan
 * con wait() hasta que el otro les avisa.
 */
public class ProductorConsumidor {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(6);
        Thread productor = new Thread(new Productor(buffer, 15, 200), "productor");
        Thread consumidor = new Thread(new Consumidor(buffer, 15, 400), "consumidor");
        productor.start();
        consumidor.start();
        productor.join();
        consumidor.join();
        System.out.println("Fin: los 15 han pasado por el buffer");
    }
}
