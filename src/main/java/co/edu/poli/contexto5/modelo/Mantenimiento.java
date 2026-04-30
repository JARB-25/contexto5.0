package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa un registro de mantenimiento realizado en el sistema de satélites.
 * <p>
 * Contiene la información administrativa y técnica de cada operación de
 * mantenimiento, incluyendo el personal, herramientas, capital y documentos
 * asociados.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Documento
 * @see Empleado
 */
public class Mantenimiento implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Número de Identificación Tributaria de la empresa de mantenimiento. */
    private String nit;

    /** Fecha en que se realiza el mantenimiento. */
    private String fecha;

    /** Nombre del gerente responsable del mantenimiento. */
    private String gerente;

    /** Nombre del supervisor del mantenimiento. */
    private String supervisor;

    /** Nombre(s) del personal asignado al mantenimiento. */
    private String personal;

    /** Herramientas utilizadas en el mantenimiento. */
    private String herramientas;

    /** Justificación técnica o administrativa del mantenimiento. */
    private String justificacion;

    /** Propuesta de acción para el mantenimiento. */
    private String propuesta;

    /** Capital económico asignado al mantenimiento. */
    private double capital;

    /** Arreglo de documentos generados por este mantenimiento. */
    private Documento[] documento;

    /**
     * Construye un objeto {@code Mantenimiento} con todos sus atributos inicializados.
     *
     * @param nit           NIT de la empresa responsable.
     * @param fecha         Fecha del mantenimiento.
     * @param gerente       Nombre del gerente responsable.
     * @param supervisor    Nombre del supervisor asignado.
     * @param personal      Personal asignado al mantenimiento.
     * @param herramientas  Herramientas empleadas.
     * @param justificacion Justificación del mantenimiento.
     * @param propuesta     Propuesta de acción.
     * @param capital       Capital asignado al mantenimiento.
     * @param documento     Arreglo de documentos asociados.
     */
    public Mantenimiento(String nit, String fecha, String gerente, String supervisor,
            String personal, String herramientas, String justificacion,
            String propuesta, double capital, Documento[] documento) {
        this.nit = nit;
        this.fecha = fecha;
        this.gerente = gerente;
        this.supervisor = supervisor;
        this.personal = personal;
        this.herramientas = herramientas;
        this.justificacion = justificacion;
        this.propuesta = propuesta;
        this.capital = capital;
        this.documento = documento;
    }

    /**
     * Retorna el NIT de la empresa responsable del mantenimiento.
     *
     * @return NIT de la empresa.
     */
    public String getNit() { return nit; }

    /**
     * Establece el NIT de la empresa responsable del mantenimiento.
     *
     * @param nit NIT de la empresa.
     */
    public void setNit(String nit) { this.nit = nit; }

    /**
     * Retorna la fecha del mantenimiento.
     *
     * @return Fecha del mantenimiento.
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha del mantenimiento.
     *
     * @param fecha Fecha del mantenimiento.
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Retorna el nombre del gerente responsable.
     *
     * @return Nombre del gerente.
     */
    public String getGerente() { return gerente; }

    /**
     * Establece el nombre del gerente responsable.
     *
     * @param gerente Nombre del gerente.
     */
    public void setGerente(String gerente) { this.gerente = gerente; }

    /**
     * Retorna el nombre del supervisor asignado.
     *
     * @return Nombre del supervisor.
     */
    public String getSupervisor() { return supervisor; }

    /**
     * Establece el nombre del supervisor asignado.
     *
     * @param supervisor Nombre del supervisor.
     */
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    /**
     * Retorna el personal asignado al mantenimiento.
     *
     * @return Nombre(s) del personal.
     */
    public String getPersonal() { return personal; }

    /**
     * Establece el personal asignado al mantenimiento.
     *
     * @param personal Nombre(s) del personal.
     */
    public void setPersonal(String personal) { this.personal = personal; }

    /**
     * Retorna las herramientas utilizadas en el mantenimiento.
     *
     * @return Descripción de herramientas.
     */
    public String getHerramientas() { return herramientas; }

    /**
     * Establece las herramientas utilizadas en el mantenimiento.
     *
     * @param herramientas Descripción de herramientas.
     */
    public void setHerramientas(String herramientas) { this.herramientas = herramientas; }

    /**
     * Retorna la justificación del mantenimiento.
     *
     * @return Justificación técnica o administrativa.
     */
    public String getJustificacion() { return justificacion; }

    /**
     * Establece la justificación del mantenimiento.
     *
     * @param justificacion Justificación técnica o administrativa.
     */
    public void setJustificacion(String justificacion) { this.justificacion = justificacion; }

    /**
     * Retorna la propuesta de acción del mantenimiento.
     *
     * @return Propuesta de acción.
     */
    public String getPropuesta() { return propuesta; }

    /**
     * Establece la propuesta de acción del mantenimiento.
     *
     * @param propuesta Propuesta de acción.
     */
    public void setPropuesta(String propuesta) { this.propuesta = propuesta; }

    /**
     * Retorna el capital asignado al mantenimiento.
     *
     * @return Capital económico del mantenimiento.
     */
    public double getCapital() { return capital; }

    /**
     * Establece el capital asignado al mantenimiento.
     *
     * @param capital Capital económico del mantenimiento.
     */
    public void setCapital(double capital) { this.capital = capital; }

    /**
     * Retorna el arreglo de documentos asociados al mantenimiento.
     *
     * @return Arreglo de objetos {@link Documento}.
     */
    public Documento[] getDocumento() { return documento; }

    /**
     * Establece el arreglo de documentos asociados al mantenimiento.
     *
     * @param documento Arreglo de objetos {@link Documento}.
     */
    public void setDocumento(Documento[] documento) { this.documento = documento; }

    /**
     * Retorna una representación en cadena del objeto {@code Mantenimiento}
     * en formato de tabla con todos los campos relevantes.
     *
     * @return Cadena formateada con los datos del mantenimiento.
     */
    @Override
    public String toString() {
        return "\n+--------------------------------------------------+"
             + "\n| REGISTRO DE MANTENIMIENTO                        |"
             + "\n+--------------------------------------------------+"
             + "\n| NIT          : " + nit
             + "\n| Fecha        : " + fecha
             + "\n| Gerente      : " + gerente
             + "\n| Supervisor   : " + supervisor
             + "\n| Personal     : " + personal
             + "\n| Herramientas : " + herramientas
             + "\n| Justificacion: " + justificacion
             + "\n| Propuesta    : " + propuesta
             + "\n| Capital      : $" + capital
             + "\n+--------------------------------------------------+";
    }
}
