# Ejercicio 1.9.2 · El hijo que no dice nada

> Actividad **9.2** de `UD01_Actividades.html`.

`Misterio` se ejecuta sin errores, escribe «Terminado» y deja `salida.txt` vacío. Averigua por
qué **aplicando el método del apartado 09**, no a base de probar. `MisterioResuelto` enseña el
camino: míralo después.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes Misterio
```

El método, en este orden:

1. Mirar lo que devuelve `waitFor()`. No es 0.
2. Redirigir la salida de error a un fichero y leerlo. El motivo está ahí escrito.
3. Probar el hijo suelto desde la consola con los mismos argumentos.

Lo que se pide no es el error, que se ve enseguida, sino **explicar qué paso te
lo reveló** y proponer el cambio para que la próxima vez el programa se entere
solo.
