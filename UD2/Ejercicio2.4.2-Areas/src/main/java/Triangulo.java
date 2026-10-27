/**
 * Actividad 4.2 · la tarea: un triángulo.
 *
 * Cada hilo tiene su propio Triangulo, con su base y su altura. Si se usara un
 * único objeto para los diez, todos calcularían el mismo triángulo.
 */
public class Triangulo implements Runnable {

    private final int base, altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void run() {
        // / 2.0 y no / 2: con dos int, base * altura / 2 es una división entera
        // y 3 x 5 daría 7.0 en lugar de 7.5, aunque se guarde en un double.
        double area = base * altura / 2.0;

        // Todo en un único println: si se escribiera con varios print seguidos,
        // las líneas de distintos hilos se podrían mezclar a trozos.
        System.out.println(Thread.currentThread().getName() + ": base " + base
                + ", altura " + altura + ", área " + area);
    }
}
