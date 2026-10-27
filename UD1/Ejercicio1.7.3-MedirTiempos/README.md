# Ejercicio 1.7.3 · Hasta dónde compensa

> Actividad **7.3** de `UD01_Actividades.html`.

El reparto del 7.2, pero con el número de procesos como argumento. Mide con 1, 2, 4, 8 y 16
procesos, tres veces cada uno, y haz una tabla con los tiempos.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes MedirTiempos texto.txt 4
```

**Primero genera el fichero de pruebas**, que no viene con el proyecto porque
ocupa demasiado para subirlo:

```
java -cp target/classes GeneraTexto texto.txt 4
```

Eso crea un `texto.txt` de unos 4 MB. Con un fichero pequeño no se mide nada:
lo único que se notaría es lo que tarda en arrancar cada máquina virtual. Con
4 MB, una pasada con un solo proceso tarda unos diez segundos, que es lo que
hace falta para que las diferencias se vean.

Después ejecuta cambiando el segundo argumento y anota los tiempos:

```
java -cp target/classes MedirTiempos texto.txt 1
java -cp target/classes MedirTiempos texto.txt 2
java -cp target/classes MedirTiempos texto.txt 4
java -cp target/classes MedirTiempos texto.txt 8
java -cp target/classes MedirTiempos texto.txt 16
```

Tres veces cada uno y haz la media: una sola medida no dice nada.

El número de vocales tiene que salir **igual** en todos los casos. Si cambia,
el reparto de los trozos está mal.

Compara la tabla con lo que averiguaste en el ejercicio 3.1 y explica por qué
con 16 procesos no va dieciséis veces más rápido.
