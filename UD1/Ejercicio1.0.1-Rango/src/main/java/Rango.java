/**
 * Actividad 0.1 · argumentos y código de salida.
 *
 * Este programa es la base de media unidad: lo van a lanzar como proceso hijo
 * los ejercicios 5.2, 6.1 y 6.3, y lo que devuelve es lo único que el padre
 * podrá saber de él.
 */
public class Rango {

    public static void main(String[] args) {

        // Los argumentos llegan SIEMPRE como texto y pueden no llegar: lo primero
        // es comprobar cuántos hay, antes de tocar args[0] o args[1].
        if (args.length != 2) {
            // Los mensajes de error van por System.err, no por System.out.
            // En el ejercicio 6.1 se verá por qué importa: cada flujo va a un fichero.
            System.err.println("Uso: java Rango <desde> <hasta>");
            System.exit(2);          // 2 = no me han pasado dos argumentos
        }

        int desde = Integer.parseInt(args[0]);
        int hasta = Integer.parseInt(args[1]);

        if (desde > hasta) {
            System.err.println("El primer numero no puede ser mayor que el segundo");
            System.exit(1);          // 1 = los numeros estan al reves
        }

        // El resultado, por la salida normal.
        System.out.println(hasta - desde + 1);

        // Si el main termina aquí sin más, el código de salida es 0.
        // El 0 no hay que pedirlo: es lo que significa "he terminado bien".
    }
}
