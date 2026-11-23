# Ejercicio 6.2 · ¿Cuántas multiplicaciones?

> Actividad **6.2** de `UD02_Actividades.html`.

Diez hilos hacen un número de multiplicaciones al azar (100, 200, 300, 400 o 500). El principal escribe cuántas se han hecho en total, sin que ningún hilo toque datos de otro.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes TotalMultiplicaciones
```
