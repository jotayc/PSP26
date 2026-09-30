# Ejercicio 1.1.2 · Un programa que se presenta

> Actividad **1.2** de `UD01_Actividades.html`.

Muestra su propio PID, escribe diez líneas numeradas con medio segundo de pausa entre ellas y
se despide con su PID otra vez. Ejecútalo **dos veces a la vez** en dos consolas y compara.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes QuienSoy primero
```

Ejecuta dos veces a la vez desde dos consolas:

```
java -cp target/classes QuienSoy primero
java -cp target/classes QuienSoy segundo
```

Cierra una de las dos consolas a mitad: la otra sigue. Esa es la prueba de que son
dos procesos y no uno con dos ventanas.
