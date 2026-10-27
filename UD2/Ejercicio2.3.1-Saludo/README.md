# Ejercicio 3.1 · Saludo

> Actividad **3.1** de `UD02_Actividades.html`.

Seis hilos escriben «Hola mundo» seguido del nombre del hilo que lo escribe. Dos versiones: heredando de `Thread` (`SaludoThread`) e implementando `Runnable` (`SaludoRunnable`). ¿Qué diferencias hay en el código y en la salida?

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes SaludoRunnable
```

Las dos clases tienen `main`. El botón *Run* ejecuta `SaludoRunnable`; para la otra, botón derecho sobre `SaludoThread.java` → *Run File*.
