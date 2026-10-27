# Ejercicio 1.7.2 · Contar vocales entre cinco

> Actividad **7.2** de `UD01_Actividades.html`.

Cuenta cuántas vocales hay en un fichero repartiendo el trabajo entre **cinco procesos**, uno
por vocal. Cada hijo cuenta la suya y el padre muestra los cinco recuentos y el total.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ContadorVocales texto.txt
```

El fichero `texto.txt` viene con el proyecto.

Una cosa que merece la pena probar: añade al fichero una palabra con tilde,
como «canción», y vuelve a ejecutarlo. La **ó** no se cuenta, porque
`Character.toLowerCase('Ó')` no es `'o'`. Piensa qué habría que hacer para
contarlas.
