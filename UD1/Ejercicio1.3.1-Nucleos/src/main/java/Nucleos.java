/**
 * Actividad 3.1 · cuántos núcleos ve Java.
 *
 * El número que sale aquí es el de núcleos LÓGICOS, que en muchos procesadores
 * es el doble de los físicos. Eso importa en el ejercicio 7.3: lanzar ocho
 * procesos de cálculo en cuatro núcleos físicos no va el doble de rápido.
 */
public class Nucleos {

    public static void main(String[] args) {

        // availableProcessors() es lo que la máquina virtual cree que tiene
        // disponible. Puede ser menos que los del equipo si el proceso está
        // limitado (por ejemplo, dentro de un contenedor).
        int nucleos = Runtime.getRuntime().availableProcessors();

        System.out.println("Nucleos que ve Java: " + nucleos);
        System.out.println();
        System.out.println("Comparalo con:");
        System.out.println("  - Windows: Administrador de tareas > Rendimiento > CPU");
        System.out.println("  - GNU/Linux: lscpu");
        System.out.println("  - La web del fabricante de tu procesador");
        System.out.println();
        System.out.println("Si el numero del fabricante es la mitad, busca que es");
        System.out.println("el multihilo simultaneo y anota la respuesta.");
    }
}
