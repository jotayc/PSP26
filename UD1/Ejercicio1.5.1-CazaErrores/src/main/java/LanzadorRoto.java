/**
 * Actividad 5.1 · el código con los cuatro fallos.
 *
 * Ejecútalo tal cual: no sale absolutamente nada por pantalla y el programa
 * termina con código 0, como si todo hubiera ido bien. Esa es la parte
 * interesante del ejercicio.
 */
public class LanzadorRoto {

    public static void main(String[] args) {
        try {
            // FALLO 1: el comando entero en un solo texto.
            ProcessBuilder pb = new ProcessBuilder("java Sumador 1 100");

            // FALLO 3: falta inheritIO(), así que no veremos lo que escriba el hijo.
            pb.start();
            // FALLO 4: falta waitFor(). Este mensaje ni siquiera llegas a verlo,
            // porque la línea de arriba ya ha lanzado la excepción; pero en cuanto
            // arregles los fallos 1 y 2 verás que miente: se imprime antes de que
            // el hijo haya sumado nada.
            System.out.println("El hijo ha sumado");

        } catch (Exception e) {
            // FALLO 2: el catch vacío se traga la excepción. El programa parece
            // que funciona y en realidad no ha arrancado nada.
        }
    }
}
