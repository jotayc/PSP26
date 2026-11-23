# Ejercicio 6.3 · Suma con hilos

> Actividad **6.3** de `UD02_Actividades.html`.

La suma de 1 a N repartida entre K hilos (N y K como argumentos), comprobada con la fórmula N·(N+1)/2 y midiendo el tiempo con 1, 2, 4 y 8 hilos.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes SumaConHilos 2000000000 4
```

Los argumentos vienen puestos en el `pom.xml` (N = 2000000000, K = 4). Cambia K en *Properties* → *Run* → *Arguments* para comparar tiempos.
