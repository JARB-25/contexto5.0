# Actividad 9 - SatControl

Proyecto Java Maven con interfaz grafica JavaFX para gestionar mantenimiento, personal tecnico y satelites.

## Requisitos

- JDK 11 o superior
- Apache Maven 3.8 o superior

## Ejecutar

Desde la carpeta del proyecto:

```bash
mvn clean javafx:run
```

## Compilar

```bash
mvn clean package
```

El archivo `.jar` se genera en la carpeta `target/`.

## Notas

- Las dependencias de JavaFX se descargan automaticamente desde Maven usando el archivo `pom.xml`.
- Los archivos `personal.dat` y `mantenimiento.dat` son datos generados al usar la aplicacion. No se suben al repositorio porque cada usuario debe generar sus propios datos localmente.
- La clase principal configurada es `co.edu.poli.contexto5.vista.App`.
