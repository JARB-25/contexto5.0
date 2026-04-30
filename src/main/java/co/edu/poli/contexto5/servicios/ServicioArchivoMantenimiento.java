package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Mantenimiento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Servicio encargado de la persistencia del arreglo de {@link Mantenimiento}
 * en archivo binario, siguiendo el mismo patrón que {@link ServicioArchivo}.
 *
 * @author Poliedro
 * @version 1.0
 */
public class ServicioArchivoMantenimiento {

    private static final String NOMBRE_ARCHIVO = "mantenimiento.dat";

    /**
     * Serializa el arreglo de mantenimientos en el archivo binario.
     *
     * @param arreglo Arreglo de {@link Mantenimiento} a guardar.
     * @return Mensaje con el resultado de la operación.
     */
    public String serializar(Mantenimiento[] arreglo) {
        if (arreglo == null) {
            return "Error: el arreglo a guardar no puede ser nulo.";
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(arreglo);
            return "Archivo guardado exitosamente en '" + NOMBRE_ARCHIVO + "'. "
                 + "Capacidad: " + arreglo.length + " posiciones.";
        } catch (IOException e) {
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }

    /**
     * Deserializa el arreglo de mantenimientos desde el archivo binario.
     *
     * @return Arreglo de {@link Mantenimiento} recuperado, o {@code null} si falla.
     */
    public Mantenimiento[] deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(NOMBRE_ARCHIVO))) {
            return (Mantenimiento[]) ois.readObject();
        } catch (IOException e) {
            System.out.println("Aviso: no se encontró archivo de mantenimiento previo.");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: clase no encontrada al deserializar mantenimiento: " + e.getMessage());
            return null;
        }
    }
}