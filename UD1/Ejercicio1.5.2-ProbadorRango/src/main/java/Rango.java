/** Copia del ejercicio 0.1: aquí hace de proceso hijo. */
public class Rango {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java Rango <desde> <hasta>");
            System.exit(2);
        }
        int desde = Integer.parseInt(args[0]);
        int hasta = Integer.parseInt(args[1]);
        if (desde > hasta) {
            System.err.println("El primer numero no puede ser mayor que el segundo");
            System.exit(1);
        }
        System.out.println(hasta - desde + 1);
    }
}
