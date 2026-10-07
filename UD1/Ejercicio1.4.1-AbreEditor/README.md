# Ejercicio 1.4.1 · Arrancar un programa del sistema

> Actividad **4.1** de `UD01_Actividades.html`.

Arranca el editor de texto del sistema pasándole un fichero que exista, y escribe un mensaje
justo después. Fíjate en cuándo aparece el mensaje.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes AbreEditor
```

Si salta `IOException` diciendo que no encuentra el programa, prueba con la ruta
completa del ejecutable.

Pregunta para responder antes de seguir: ¿qué habría que añadir para que el
mensaje no saliera hasta cerrar el editor? La respuesta está en el apartado 05.
