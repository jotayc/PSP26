# Ejercicio 1.6.1 · Cada cosa a su fichero

> Actividad **6.1** de `UD01_Actividades.html`.

Lanza `Rango` mandando su salida normal a `resultado.txt` y sus errores a `errores.txt`.
Hazlo con argumentos buenos y con los números al revés, y lee los dos ficheros.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes SalidaYError
```

Fíjate en que los dos ficheros se **sobrescriben** en cada llamada: el segundo
caso borra lo que dejó el primero. Por eso, cuando varios hijos escriben a la
vez (ejercicio 7.1), cada uno necesita su propio fichero.
