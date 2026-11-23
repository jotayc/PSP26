/**
 * Actividad 7.1 bis · el principal.
 *
 * Arranca primero el pong a propósito: aun así, el primero en escribir es el
 * ping, porque el pong encuentra que no le toca y se queda esperando con wait()
 * hasta que el ping le pasa el turno.
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
