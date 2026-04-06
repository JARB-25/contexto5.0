package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Maquinaria;

/**
 * Servicio de mantenimiento que extiende de {@link Maquinaria}.
 * <p>
 * Representa un servicio especializado de mantenimiento que hereda
 * las características técnicas de la maquinaria y agrega información
 * administrativa propia del servicio, como el supervisor asignado y
 * el tipo de mantenimiento a ejecutar.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Maquinaria
 */
public class ServicioMantenimiento extends Maquinaria {

    /** Nombre del supervisor responsable del servicio de mantenimiento. */
    private String supervisor;

    /** Descripción del mantenimiento asignado a este servicio. */
    private String mantenimientoasignado;

    /**
     * Construye un objeto {@code ServicioMantenimiento} con todos los atributos
     * de {@link Maquinaria} más los propios del servicio.
     *
     * @param peso                 Peso de la maquinaria (kg).
     * @param marca                Marca o fabricante de la maquinaria.
     * @param color                Color de la maquinaria.
     * @param material             Material de fabricación.
     * @param tamano               Tamaño o dimensiones.
     * @param preciofabrica        Precio original de fábrica.
     * @param aniofabricacion      Año de fabricación.
     * @param tipo                 Tipo o clasificación de la maquinaria.
     * @param nivelseguridad       Nivel de seguridad requerido.
     * @param modoempleado         Modo de uso por parte del empleado.
     * @param anioctual            Año actual para cálculo de deterioro.
     * @param personalautorizado   Personal autorizado para operar la maquinaria.
     * @param supervisor           Nombre del supervisor del servicio.
     * @param mantenimientoasignado Descripción del mantenimiento asignado.
     */
    public ServicioMantenimiento(double peso, String marca, String color, String material,
            String tamano, double preciofabrica, double aniofabricacion,
            String tipo, String nivelseguridad, String modoempleado,
            int anioctual, String personalautorizado,
            String supervisor, String mantenimientoasignado) {
        super(peso, marca, color, material, tamano, preciofabrica, aniofabricacion,
                tipo, nivelseguridad, modoempleado, anioctual, personalautorizado);
        this.supervisor = supervisor;
        this.mantenimientoasignado = mantenimientoasignado;
    }

    /**
     * Retorna una descripción del servicio ejecutado según el tipo indicado.
     *
     * @param type Tipo de servicio de mantenimiento a ejecutar.
     * @return Cadena con el tipo de servicio y el nombre del supervisor.
     */
    public String method(String type) {
        return "Servicio tipo: " + type + " | Supervisor: " + supervisor;
    }

    /**
     * Retorna el nombre del supervisor responsable del servicio.
     *
     * @return Nombre del supervisor.
     */
    public String getSupervisor() { return supervisor; }

    /**
     * Establece el nombre del supervisor responsable del servicio.
     *
     * @param supervisor Nombre del supervisor.
     */
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    /**
     * Retorna la descripción del mantenimiento asignado.
     *
     * @return Descripción del mantenimiento asignado.
     */
    public String getMantenimientoasignado() { return mantenimientoasignado; }

    /**
     * Establece la descripción del mantenimiento asignado.
     *
     * @param m Descripción del mantenimiento asignado.
     */
    public void setMantenimientoasignado(String m) { this.mantenimientoasignado = m; }

    /**
     * Retorna una representación en cadena del objeto {@code ServicioMantenimiento}.
     *
     * @return Cadena con el supervisor y el mantenimiento asignado.
     */
    @Override
    public String toString() {
        return "ServicioMantenimiento [supervisor=" + supervisor
                + ", mantenimientoasignado=" + mantenimientoasignado + "]";
    }
}
