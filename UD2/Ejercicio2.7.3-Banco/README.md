# Ejercicio 7.3 · Interbloqueo en el banco

> Actividad **7.3** de `UD02_Actividades.html`.

Dos cuentas (Ana y Luis, 1000 euros cada una) y dos hilos: cien transferencias de 10 euros de Ana a Luis y cien de Luis a Ana. Comprobar que se queda bloqueado, también sin la pausa, y arreglarlo cogiendo los cerrojos siempre en el mismo orden. El total, 2000 euros, no debe cambiar.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes BancoOrdenado
```

`BancoBloqueado` es la versión que se queda parada y `BancoOrdenado`, la arreglada. Con el argumento `sinpausa` las dos quitan la pausa entre los dos cerrojos.

**La actividad 10.1 se hace sobre este proyecto**: ejecuta `BancoBloqueado`, y cuando se pare, `jps` y `jstack PID` (o *Debug → Check for Deadlock* en NetBeans).
