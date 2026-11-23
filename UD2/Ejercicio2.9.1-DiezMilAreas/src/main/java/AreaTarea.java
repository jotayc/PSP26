import java.util.Random;

/**
 * Actividad 9.1 · la tarea: el área de un triángulo al azar.
 *
 * Es la misma en las dos formas del ejercicio: solo cambia quién la ejecuta.
 */
public class AreaTarea implements Runnable {

    @Override
    public void run() {
        Random azar = new Random();
        int base = 1 + azar.nextInt(10);
        int altura = 1 + azar.nextInt(10);
        double area = base * altura / 2.0;
        if (area <= 0) {
            System.out.println("Imposible: " + area);   // nunca pasa; evita que el cálculo no sirva para nada
        }
    }
}
