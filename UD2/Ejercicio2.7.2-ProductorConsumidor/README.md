# Ejercicio 7.2 · Productor y consumidor

> Actividad **7.2** de `UD02_Actividades.html`.

Un productor guarda 15 caracteres en un buffer con capacidad para 6 y un consumidor los saca. El productor duerme de 0 a 200 ms entre carácter y carácter y el consumidor de 0 a 400 ms.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ProductorConsumidor
```

Para que el consumidor sea el rápido, cambia los dos tiempos máximos en `ProductorConsumidor`.

**La actividad 10.2 se hace sobre este proyecto**: `Buffer.java` ya está documentado con JavaDoc. Para generar la documentación: botón derecho sobre el proyecto → *Generate Javadoc*, o `javadoc -d doc src/main/java/Buffer.java`.
