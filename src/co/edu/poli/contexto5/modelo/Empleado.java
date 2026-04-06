package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Clase base que representa a un empleado genérico del sistema de satélites.
 * <p>
 * Actúa como superclase en la jerarquía de herencia, proporcionando el
 * arreglo de mantenimientos asociados y el método {@link #obtenerInformacion()},
 * el cual puede ser sobreescrito por las subclases para personalizar la
 * información mostrada (Punto 3 - Sobreescritura).
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Personal
 * @see Mantenimiento
 */
public class Empleado implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Arreglo de mantenimientos asignados a este empleado. */
    private Mantenimiento[] mantenimiento;

    /**
     * Constructor por defecto. Crea un empleado sin mantenimientos asignados.
     */
    public Empleado() {
    }

    /**
     * Constructor que inicializa el empleado con un arreglo de mantenimientos.
     *
     * @param mantenimiento Arreglo de objetos {@link Mantenimiento} asignados al empleado.
     */
    public Empleado(Mantenimiento[] mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    /**
     * Retorna información básica sobre el empleado.
     * <p>
     * <b>Punto 3 - Sobreescritura:</b> Este método está diseñado para ser
     * sobreescrito (@Override) por la subclase {@link Personal}, la cual
     * proporciona una descripción más detallada del personal.
     * </p>
     *
     * @return Cadena con la descripción genérica del empleado.
     */
    public String obtenerInformacion() {
        return "Empleado generico del sistema de satelites";
    }

    /**
     * Retorna el arreglo de mantenimientos asignados al empleado.
     *
     * @return Arreglo de objetos {@link Mantenimiento}.
     */
    public Mantenimiento[] getMantenimiento() { return mantenimiento; }

    /**
     * Establece el arreglo de mantenimientos asignados al empleado.
     *
     * @param mantenimiento Arreglo de objetos {@link Mantenimiento}.
     */
    public void setMantenimiento(Mantenimiento[] mantenimiento) { this.mantenimiento = mantenimiento; }

    /**
     * Retorna una representación en cadena del objeto {@code Empleado}.
     *
     * @return Cadena con el número de mantenimientos asignados.
     */
    @Override
    public String toString() {
        return "Empleado [mantenimientos=" + (mantenimiento != null ? mantenimiento.length : 0) + "]";
    }
}
