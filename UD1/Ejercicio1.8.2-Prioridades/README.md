# Ejercicio 1.8.2 · Prioridades

> Actividad **8.2** de `UD01_Actividades.html`.

Arranca este programa con prioridad baja y con prioridad normal a la vez, míralos en el
monitor del sistema y escribe qué diferencia observas.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes Bucle
```

Arranca dos copias a la vez, una normal y otra con prioridad baja:

**Windows**
```
start "normal" java -cp target/classes Bucle normal
start /low "bajo" java -cp target/classes Bucle bajo
```

**GNU/Linux**
```
java -cp target/classes Bucle normal &
nice -n 19 java -cp target/classes Bucle bajo &
```

Compara el número de vueltas que dice cada uno al terminar.

Si tu equipo tiene núcleos de sobra no se notará nada: la prioridad solo importa
cuando hay más procesos pidiendo procesador que núcleos. En ese caso, lanza
tantas copias como núcleos tengas y vuelve a probar.
