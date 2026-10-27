# Ejercicio 1.6.3 · Dos hijos, un solo fichero

> Actividad **6.3** de `UD01_Actividades.html`.

Investiga qué pasa si dos procesos escriben a la vez en el mismo fichero: primero
sobrescribiendo y después en modo añadir.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes UnSoloFichero
```

Lo que hay que observar y anotar:

- Sobrescribiendo queda **un solo número**: el del hijo que cerró el último.
- En modo añadir quedan los dos, pero **el orden no está garantizado**, y con
  hijos que escribieran más podrían salir líneas partidas por la mitad.

Por eso en el ejercicio 7.1 cada hijo escribe en su propio fichero.
