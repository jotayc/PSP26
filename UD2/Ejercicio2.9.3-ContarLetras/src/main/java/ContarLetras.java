import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Actividad 9.3.
 *
 * Con ConcurrentHashMap y un AtomicInteger por letra el total cuadra siempre. Con HashMap, varios
 * hilos lo cambian a la vez y se pierden cuentas (o la tabla se estropea por
 * dentro). Los textos se alargan con repeat() para que los hilos se solapen: con
 * textos cortos, el HashMap podría salir bien por casualidad.
 */
public class ContarLetras {

    public static void main(String[] args) throws InterruptedException {
        boolean normal = args.length > 0 && args[0].equals("hashmap");
        String[] textos = {
            "el hilo principal espera a los demas ".repeat(20_000),
            "los hilos comparten la memoria del proceso ".repeat(20_000),
            "cada hilo tiene su propia pila ".repeat(20_000)
        };
        Map<Character, AtomicInteger> veces = normal ? new HashMap<>() : new ConcurrentHashMap<>();

        ExecutorService pool = Executors.newFixedThreadPool(textos.length);
        for (String texto : textos) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (char letra : texto.toCharArray()) {
                        if (letra != ' ') {
                            // Crea el contador de la letra si aún no tiene, y le suma 1
                            veces.putIfAbsent(letra, new AtomicInteger(0));
                            veces.get(letra).incrementAndGet();
                        }
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long esperadas = 0;
        for (String texto : textos) {
            esperadas += texto.replace(" ", "").length();
        }
        long contadas = 0;
        for (AtomicInteger contador : veces.values()) {
            contadas += contador.get();
        }
        System.out.println((normal ? "HashMap" : "ConcurrentHashMap") + ": " + new TreeMap<>(veces));
        System.out.println("Letras contadas: " + contadas + "   letras en los textos: " + esperadas
                + (contadas == esperadas ? "   (cuadra)" : "   (NO cuadra)"));
    }
}
