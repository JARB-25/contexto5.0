package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa un documento oficial asociado a una misión espacial.
 * <p>
 * Almacena información como el identificador, fecha, categoría, tipo,
 * encargado, solución propuesta, estado y la misión relacionada.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Mision
 */
public class Documento implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Identificador único del documento. */
    private String id;

    /** Fecha de creación o registro del documento. */
    private String fecha;

    /** Categoría del documento (técnico, administrativo, etc.). */
    private String categoria;

    /** Tipo de documento. */
    private String tipo;

    /** Nombre del encargado responsable del documento. */
    private String encargado;

    /** Solución propuesta o descrita en el documento. */
    private String solucion;

    /** Lugar donde fue generado o aplica el documento. */
    private String lugar;

    /** Plan de acción descrito en el documento. */
    private String plan;

    /** Descripción del problema que motiva el documento. */
    private String problema;

    /** Objetivo que persigue el documento. */
    private String objetivo;

    /** Propuesta formal contenida en el documento. */
    private String propuesta;

    /** Firma digital o manuscrita que avala el documento. */
    private String firma;

    /** Estado actual del documento (activo, archivado, etc.). */
    private String estado;

    /** Misión espacial a la que está asociado este documento. */
    private Mision mision;

    /**
     * Construye un objeto {@code Documento} con todos sus atributos inicializados.
     *
     * @param id        Identificador único del documento.
     * @param fecha     Fecha de creación o registro.
     * @param categoria Categoría del documento.
     * @param tipo      Tipo de documento.
     * @param encargado Nombre del encargado responsable.
     * @param solucion  Solución propuesta en el documento.
     * @param lugar     Lugar de generación o aplicación.
     * @param plan      Plan de acción descrito.
     * @param problema  Problema que motiva el documento.
     * @param objetivo  Objetivo que persigue el documento.
     * @param propuesta Propuesta formal del documento.
     * @param firma     Firma que avala el documento.
     * @param estado    Estado actual del documento.
     * @param mision    Misión espacial asociada.
     */
    public Documento(String id, String fecha, String categoria, String tipo,
            String encargado, String solucion, String lugar, String plan,
            String problema, String objetivo, String propuesta,
            String firma, String estado, Mision mision) {
        this.id = id;
        this.fecha = fecha;
        this.categoria = categoria;
        this.tipo = tipo;
        this.encargado = encargado;
        this.solucion = solucion;
        this.lugar = lugar;
        this.plan = plan;
        this.problema = problema;
        this.objetivo = objetivo;
        this.propuesta = propuesta;
        this.firma = firma;
        this.estado = estado;
        this.mision = mision;
    }

    /**
     * Retorna el identificador único del documento.
     *
     * @return ID del documento.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único del documento.
     *
     * @param id ID del documento.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna la fecha del documento.
     *
     * @return Fecha de creación o registro.
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha del documento.
     *
     * @param fecha Fecha de creación o registro.
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Retorna la categoría del documento.
     *
     * @return Categoría del documento.
     */
    public String getCategoria() { return categoria; }

    /**
     * Establece la categoría del documento.
     *
     * @param categoria Categoría del documento.
     */
    public void setCategoria(String categoria) { this.categoria = categoria; }

    /**
     * Retorna el tipo de documento.
     *
     * @return Tipo del documento.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo de documento.
     *
     * @param tipo Tipo del documento.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Retorna el nombre del encargado del documento.
     *
     * @return Nombre del encargado.
     */
    public String getEncargado() { return encargado; }

    /**
     * Establece el nombre del encargado del documento.
     *
     * @param encargado Nombre del encargado.
     */
    public void setEncargado(String encargado) { this.encargado = encargado; }

    /**
     * Retorna la solución descrita en el documento.
     *
     * @return Solución propuesta.
     */
    public String getSolucion() { return solucion; }

    /**
     * Establece la solución descrita en el documento.
     *
     * @param solucion Solución propuesta.
     */
    public void setSolucion(String solucion) { this.solucion = solucion; }

    /**
     * Retorna el lugar asociado al documento.
     *
     * @return Lugar de generación o aplicación.
     */
    public String getLugar() { return lugar; }

    /**
     * Establece el lugar asociado al documento.
     *
     * @param lugar Lugar de generación o aplicación.
     */
    public void setLugar(String lugar) { this.lugar = lugar; }

    /**
     * Retorna el plan de acción del documento.
     *
     * @return Plan de acción.
     */
    public String getPlan() { return plan; }

    /**
     * Establece el plan de acción del documento.
     *
     * @param plan Plan de acción.
     */
    public void setPlan(String plan) { this.plan = plan; }

    /**
     * Retorna el problema descrito en el documento.
     *
     * @return Descripción del problema.
     */
    public String getProblema() { return problema; }

    /**
     * Establece el problema descrito en el documento.
     *
     * @param problema Descripción del problema.
     */
    public void setProblema(String problema) { this.problema = problema; }

    /**
     * Retorna el objetivo del documento.
     *
     * @return Objetivo del documento.
     */
    public String getObjetivo() { return objetivo; }

    /**
     * Establece el objetivo del documento.
     *
     * @param objetivo Objetivo del documento.
     */
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    /**
     * Retorna la propuesta formal del documento.
     *
     * @return Propuesta formal.
     */
    public String getPropuesta() { return propuesta; }

    /**
     * Establece la propuesta formal del documento.
     *
     * @param propuesta Propuesta formal.
     */
    public void setPropuesta(String propuesta) { this.propuesta = propuesta; }

    /**
     * Retorna la firma que avala el documento.
     *
     * @return Firma del documento.
     */
    public String getFirma() { return firma; }

    /**
     * Establece la firma que avala el documento.
     *
     * @param firma Firma del documento.
     */
    public void setFirma(String firma) { this.firma = firma; }

    /**
     * Retorna el estado actual del documento.
     *
     * @return Estado del documento.
     */
    public String getEstado() { return estado; }

    /**
     * Establece el estado actual del documento.
     *
     * @param estado Estado del documento.
     */
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Retorna la misión espacial asociada al documento.
     *
     * @return Objeto {@link Mision} asociado.
     */
    public Mision getMision() { return mision; }

    /**
     * Establece la misión espacial asociada al documento.
     *
     * @param mision Objeto {@link Mision} asociado.
     */
    public void setMision(Mision mision) { this.mision = mision; }

    /**
     * Retorna una representación en cadena del objeto {@code Documento}.
     *
     * @return Cadena con id, fecha, categoría y estado.
     */
    @Override
    public String toString() {
        return "Documento [id=" + id + ", fecha=" + fecha
                + ", categoria=" + categoria + ", estado=" + estado + "]";
    }
}
