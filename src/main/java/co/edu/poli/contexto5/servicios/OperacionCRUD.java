package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Personal;

/**
 * Interfaz que define el contrato de las operaciones CRUD sobre objetos
 * de tipo {@link Personal}.
 * <p>
 * <b>Punto 1 - Interfaz {@code OperacionCRUD}:</b> Establece los métodos
 * que toda clase de implementación debe proveer para gestionar el ciclo
 * de vida del personal en el sistema. La búsqueda, modificación y
 * eliminación se realizan por cédula (ID del objeto).
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see ImplementacionOperacionCRUD
 * @see Personal
 */
public interface OperacionCRUD {

    /**
     * Inserta un nuevo objeto {@link Personal} en el sistema.
     * <p>
     * La inserción se realiza en la primera posición nula disponible
     * del arreglo interno (de izquierda a derecha). Si el arreglo está
     * lleno, se aplica agregación infinita duplicando su capacidad.
     * </p>
     *
     * @param p Objeto {@link Personal} a registrar. No puede ser {@code null}.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String crear(Personal p);

    /**
     * Consulta un objeto {@link Personal} por su número de cédula.
     *
     * @param cedula Cédula (ID) del personal a buscar. No puede ser vacía ni {@code null}.
     * @return El objeto {@link Personal} encontrado, o {@code null} si no existe.
     */
    public Personal leer(String cedula);

    /**
     * Actualiza el registro del personal cuya cédula coincida con la indicada,
     * reemplazando el objeto existente por el nuevo objeto proporcionado.
     *
     * @param cedula Cédula del registro que se desea actualizar.
     * @param p      Nuevo objeto {@link Personal} con los datos actualizados.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String actualizar(String cedula, Personal p);

    /**
     * Elimina el registro del personal cuya cédula coincida con la indicada,
     * liberando esa posición en el arreglo para futuros registros.
     *
     * @param cedula Cédula del personal que se desea eliminar.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String eliminar(String cedula);
}
