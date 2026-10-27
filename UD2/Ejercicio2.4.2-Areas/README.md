# Ejercicio 4.2 · Áreas en paralelo

> Actividad **4.2** de `UD02_Actividades.html`.

Diez hilos. Cada uno recibe la base y la altura de un triángulo (enteros al azar entre 1 y 10) y escribe, en una sola línea, lo que ha recibido y el área. Cuando terminan los diez, el principal escribe «Calculadas las 10 áreas».

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes AreasEnParalelo
```
