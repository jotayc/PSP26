# Ejercicio 1.5.3 · Un hijo que no termina

> Actividad **5.3** de `UD01_Actividades.html`.

`Colgado` no termina nunca. `Vigilante` lo lanza, le da tres segundos y, si sigue vivo, lo
para y avisa.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal y los argumentos ya vienen puestos en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes Vigilante
```

El código de salida no es 0 y cambia según el sistema:

- Windows: **1**, porque `destroy()` ahí ya es forzado.
- GNU/Linux: **143**, que es 128 + 15, la señal de terminar.

Si quieres matarlo sin darle opción, `destroyForcibly()`.
