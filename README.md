# Ejercicios de Programación de Servicios y Procesos

Ejercicios resueltos y comentados del módulo, organizados por unidad. Cada
carpeta es un **proyecto Maven independiente** que se abre directamente en
NetBeans.

Los ejercicios se van publicando aquí a medida que avanzamos: si no ves el de
un apartado, es que todavía no toca.

## Cómo descargarlo

La primera vez, en la carpeta donde quieras tenerlo:

```
git clone https://github.com/jotayc/PSP26.git
```

Después, cada vez que se publique un ejercicio nuevo, basta con actualizar:

```
git pull
```

No hace falta volver a clonar ni descargar nada a mano.

Si no quieres usar git, arriba a la derecha tienes **Code → Download ZIP**, pero
entonces tendrás que repetirlo cada vez.

## Cómo abrir un ejercicio en NetBeans

*Archivo → Abrir proyecto* y selecciona la carpeta del ejercicio, la que tiene
el `pom.xml` dentro. NetBeans lo reconoce como proyecto Maven y no hay que
configurar nada.

Para ejecutarlo, el botón de *Run*: la clase principal y los argumentos ya vienen
puestos. Si quieres cambiar los argumentos, botón derecho sobre el proyecto →
*Properties* → *Run*.

También funciona desde la consola, dentro de la carpeta del ejercicio:

```
mvn compile
java -cp target/classes NombreDeLaClase argumentos
```

## Cómo se llama cada cosa

```
UD1/
└── Ejercicio1.5.2-ProbadorRango/
    ├── pom.xml          configuración del proyecto
    ├── README.md        el enunciado y cómo ejecutarlo
    └── src/main/java/   el código, comentado
```

El nombre de la carpeta es `Ejercicio` + número de unidad + número de la
actividad + un nombre que describe de qué va. `Ejercicio1.5.2` es la actividad
**5.2** de la **unidad 1**, la misma numeración que tienen en
`UD01_Actividades.html`.

## Antes de mirar el código

Están resueltos, pero eso no los convierte en la solución que tienes que
entregar: lo que se evalúa es que sepas escribirlos tú. Úsalos para comprobar
lo que has hecho y para desatascarte, no para copiar y seguir.

Cada fichero lleva comentarios explicando **por qué** está hecho así, no qué
hace cada línea. Esos comentarios son la parte que merece la pena leer.
