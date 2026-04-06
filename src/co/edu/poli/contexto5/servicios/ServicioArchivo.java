package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Personal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Servicio encargado de las operaciones de persistencia sobre archivo binario.
 * <p>
 * Permite serializar (guardar) y deserializar (cargar) el arreglo de
 * {@link Personal} en un archivo {@code .dat} usando el mecanismo de
 * serialización de Java ({@link ObjectOutputStream} / {@link ObjectInputStream}).
 * </p>
 * <p>
 * El archivo de persistencia se llama {@value #NOMBRE_ARCHIVO} y se genera
 * en el directorio de trabajo de la aplicación.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see ImplementacionOperacionCRUD
 * @see Personal
 */
public class ServicioArchivo {

    /**
     * Nombre del archivo binario donde se persiste el arreglo de personal.
     */
    private static final String NOMBRE_ARCHIVO = "personal.dat";

    /**
     * Serializa (guarda) el arreglo completo de {@link Personal} en el archivo binario.
     * <p>
     * Si el archivo no existe, lo crea. Si ya existe, lo sobreescribe.
     * Utiliza {@link ObjectOutputStream} para escribir el objeto directamente.
     * </p>
     *
     * @param arreglo El arreglo de tipo {@code Personal[]} a guardar.
     *                No puede ser {@code null}.
     * @return Mensaje indicando el resultado de la operación:
     *         éxito con la capacidad del arreglo, o error con el detalle.
     */
    public String serializar(Personal[] arreglo) {
        if (arreglo == null) {
            return "Error: el arreglo a guardar no puede ser nulo.";
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(arreglo);
            return "Archivo guardado exitosamente en '" + NOMBRE_ARCHIVO + "'. "
                 + "Capacidad del arreglo: " + arreglo.length + " posiciones.";
        } catch (IOException e) {
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }

    /**
     * Deserializa (carga) el arreglo de {@link Personal} desde el archivo binario.
     * <p>
     * Restaura el estado completo del arreglo tal como fue guardado previamente
     * mediante {@link #serializar(Personal[])}. Utiliza {@link ObjectInputStream}
     * para leer el objeto del archivo.
     * </p>
     *
     * @return El arreglo {@code Personal[]} recuperado del archivo,
     *         o {@code null} si ocurre un error de lectura o de clase no encontrada.
     */
    public Personal[] deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(NOMBRE_ARCHIVO))) {
            Personal[] arreglo = (Personal[]) ois.readObject();
            return arreglo;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: clase no encontrada al deserializar: " + e.getMessage());
            return null;
        }
    }
}
