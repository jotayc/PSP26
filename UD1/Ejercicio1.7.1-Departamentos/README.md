# Ejercicio 1.7.1 · Las cuentas de los departamentos

> Actividad **7.1** de `UD01_Actividades.html`.

Cinco ficheros con las cuentas de cinco departamentos, una cantidad por línea. Calcula la
suma total **aprovechando el paralelismo**: un proceso por fichero.

Los cinco `.txt` **los tienes que crear tú**, con al menos veinte cantidades cada uno. El programa
avisa si falta alguno.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes SumaDepartamentos
```

**Los cinco ficheros los creas tú**, en la carpeta del proyecto:
`informatica.txt`, `gerencia.txt`, `contabilidad.txt`, `comercio.txt` y
`rrhh.txt`, con una cantidad entera por línea y al menos veinte cada uno.

Para comprobar que está bien: suma los cinco ficheros a mano (o con una hoja de
cálculo) y compara con el TOTAL.

**La actividad 9.1 se hace sobre este proyecto**: documentar sus dos clases con
JavaDoc y generar la documentación.
