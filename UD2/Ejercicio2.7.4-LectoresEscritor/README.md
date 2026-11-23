# Ejercicio 7.4 · Lectores y escritor (reto plus)

> Actividad **7.4** de `UD02_Actividades.html`.

Un escritor añade datos a un fichero compartido y varios lectores lo leen. El escritor escribe solo; los lectores pueden leer a la vez; prioridad a los lectores. Los lectores duermen de 2 a 5 s entre lecturas y el escritor de 1 a 3 s entre escrituras. ¿Qué le puede pasar al escritor?

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes LectoresEscritor
```

El fichero `compartido.txt` se crea en la carpeta del proyecto al ejecutarlo. Cada lector lee cuatro veces y el escritor escribe cinco, para que el programa termine solo.
