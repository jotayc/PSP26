# Ejercicio 4.1 · start o run

> Actividad **4.1** de `UD02_Actividades.html`.

Predecir y comprobar qué sale al llamar a `run()` en lugar de `start()` sobre tres hilos, y después con `start()`.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ProbarRun
```

`ProbarRun` es la versión con `run()` y `ProbarStart` la versión con `start()`. Para ejecutar la segunda, botón derecho sobre el fichero → *Run File*.
