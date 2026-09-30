# Ejercicio 1.0.1 · Argumentos y código de salida

> Actividad **0.1** de `UD01_Actividades.html`.

Recibe dos números como argumentos y escribe cuántos enteros hay entre ellos, los dos
incluidos. Devuelve **0** si todo va bien, **1** si el primero es mayor que el segundo y **2** si no
le han pasado exactamente dos argumentos.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes Rango 3 7
```

Para ver el código de salida después de ejecutarlo desde la consola:

- Windows: `echo %ERRORLEVEL%`
- GNU/Linux: `echo $?`

Tiene que ser el comando siguiente; cualquier otro lo cambia.
