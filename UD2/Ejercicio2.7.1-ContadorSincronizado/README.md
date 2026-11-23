# Ejercicio 7.1 · Contador sincronizado

> Actividad **7.1** de `UD02_Actividades.html`.

El contador de la 6.1 con 500000 incrementos por hilo, arreglado con `synchronized` de dos formas: heredando de `Thread` con un método `synchronized` que toca un campo `static`, y con un objeto `Contador` compartido. Una de las dos sigue fallando: por qué, y cómo se arregla.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ConObjetoCompartido
```

Tres clases con `main`: `HiloContadorMal` (la que sigue fallando), `HiloContador` (la misma, arreglada) y `ConObjetoCompartido` (la segunda forma). El botón *Run* ejecuta la última; para las otras, *Run File*.
