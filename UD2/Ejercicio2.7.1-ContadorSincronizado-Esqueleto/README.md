# Ejercicio 7.1 · Contador sincronizado (esqueleto)

> Actividad **7.1** de `UD02_Actividades.html`.

El contador de la 6.1, con 500000 incrementos por cada uno de los cuatro hilos, arreglado con `synchronized` de dos formas. Las dos tienen que dar siempre 2000000. Una de ellas, hecha tal como dice el enunciado, sigue fallando: averigua cuál, explica por qué y arréglala.

## Qué tienes que completar

Las tres clases ya existen y compilan. Lo que falta está marcado con `TODO`:

| Clase | Forma | Qué falta |
|---|---|---|
| `HiloContador` | 1 | Los métodos `incrementar()` y `run()`. |
| `Contador` | 2 | Que se pueda usar desde varios hilos a la vez. |
| `ConObjetoCompartido` | 2 | El `run()` de la tarea. |

Si lo ejecutas tal cual, las dos formas escriben «Cuenta: 0»: los hilos todavía no hacen nada.

## Sabrás que está bien si

- La forma 2 da siempre 2000000.
- La forma 1, hecha como dice el enunciado, sigue fallando, y sabes explicar por qué.
- Después de arreglarla, la forma 1 también da siempre 2000000.

Ejecuta cada una unas diez veces: que salga bien una vez no demuestra nada.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto. El botón *Run* ejecuta `ConObjetoCompartido` (forma 2); para la forma 1, botón derecho sobre `HiloContador` y *Run File*.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ConObjetoCompartido
java -cp target/classes HiloContador
```
