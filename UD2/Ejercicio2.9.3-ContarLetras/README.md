# Ejercicio 9.3 · Las letras de varios textos

> Actividad **9.3** de `UD02_Actividades.html`.

Contar cuántas veces aparece cada letra en varios textos largos, con una tarea por texto en un pool y un `ConcurrentHashMap` compartido; después, con un `HashMap` normal, y comparar los totales.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ContarLetras
```

Sin argumentos usa `ConcurrentHashMap`. Con el argumento `hashmap` usa un `HashMap` normal: ejecútalo varias veces y mira si el total cuadra.
