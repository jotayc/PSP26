# Ejercicio 1.5.1 · Caza de errores

> Actividad **5.1** de `UD01_Actividades.html`.

`LanzadorRoto` tiene **cuatro** fallos. Encuéntralos, arréglalos y explica qué provocaba cada
uno. `LanzadorArreglado` es la versión buena: míralo solo después de intentarlo.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes LanzadorArreglado
```

Ejecuta primero `LanzadorRoto`: **no sale nada**, y aun así el programa
termina como si todo hubiera ido bien. Empieza por ahí, porque ese silencio ya
es una pista de dos de los cuatro fallos.

Después `LanzadorArreglado`, que escribe el resultado del hijo y luego el
mensaje, en ese orden.
