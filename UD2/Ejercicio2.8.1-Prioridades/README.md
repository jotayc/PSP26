# Ejercicio 8.1 · Prioridades a prueba

> Actividad **8.1** de `UD02_Actividades.html`.

El programa del apartado 08: el doble de hilos que núcleos, la mitad con prioridad mínima y la mitad con máxima, contando vueltas dos segundos. Probarlo varias veces, con tantos hilos como núcleos y, si se puede, en GNU/Linux.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes Prioridades
```

Sin argumentos lanza el doble de hilos que núcleos. Con un número como argumento, lanza ese número de hilos (por ejemplo, tantos como núcleos).
