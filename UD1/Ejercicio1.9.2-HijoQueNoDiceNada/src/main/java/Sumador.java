/** Proceso hijo. Fíjate bien en cómo se llama esta clase. */
public class Sumador {

    public static void main(String[] args) {
        int desde = Integer.parseInt(args[0]);
        int hasta = Integer.parseInt(args[1]);

        long suma = 0;
        for (int i = desde; i <= hasta; i++) {
            suma = suma + i;
        }
        System.out.println(suma);
    }
}
