# Ejercicio 0.2 · Los hilos de un programa Java

> Actividad **0.2** de `UD02_Actividades.html`.

Un programa que escribe el nombre del hilo que ejecuta su `main` y se queda esperando a que pulses Intro. Mientras espera, busca su proceso `java` en el Administrador de tareas y mira cuántos hilos tiene.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes EsperaIntro
```

Mientras el programa espera, en el Administrador de tareas: pestaña *Detalles*, botón derecho sobre la cabecera → *Seleccionar columnas* → *Subprocesos* (así llama Windows a los hilos). En GNU/Linux: `ps -o nlwp -p PID`.
