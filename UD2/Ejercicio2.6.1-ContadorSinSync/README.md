# Ejercicio 6.1 · Contador sin sincronizar

> Actividad **6.1** de `UD02_Actividades.html`.

Cuatro hilos incrementan, cada uno N veces, un contador compartido. Se ejecuta con N = 5000 y con N = 500000, varias veces, y se explica el resultado.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes CuatroHilos 5000
```

El número de incrementos por hilo es el argumento: viene puesto 5000 en el `pom.xml`. Para probar con 500000, *Properties* → *Run* → *Arguments*, o desde la consola: `java -cp target/classes CuatroHilos 500000`.
