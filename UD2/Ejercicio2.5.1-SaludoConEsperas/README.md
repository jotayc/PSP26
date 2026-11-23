# Ejercicio 5.1 · Saludo con esperas

> Actividad **5.1** de `UD02_Actividades.html`.

Seis hilos llamados «Saludador 1» a «Saludador 6». Cada uno duerme tantos segundos como su número y después saluda. El principal espera a los seis y escribe cuánto han tardado en total.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes SaludoConEsperas
```
