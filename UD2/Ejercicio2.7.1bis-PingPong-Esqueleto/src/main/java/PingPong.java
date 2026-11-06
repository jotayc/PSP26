/**
 * El principal: crea la mesa y los dos jugadores, los arranca y espera a que
 * terminen. No hace falta tocarlo.
 *
 * Arranca primero el pong a propósito: aun así, el primero en escribir tiene
 * que ser el ping.
 */
public class PingPong {

    public static void main(String[] args) throws InterruptedException {
        Mesa mesa = new Mesa();
        Thread pong = new Thread(new Jugador(mesa, false, 10), "pong");
        Thread ping = new Thread(new Jugador(mesa, true, 10), "ping");
        pong.start();
        ping.start();
        pong.join();
        ping.join();
        System.out.println("Fin del partido");
    }
}
