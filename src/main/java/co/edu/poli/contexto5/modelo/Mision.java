package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa una misión espacial gestionada dentro del sistema de satélites.
 * <p>
 * Contiene la información estratégica y operativa de la misión, incluyendo
 * su visión, objetivos, metas, estrategia, fechas de inicio y fin, y el
 * jefe responsable de su ejecución.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Jefe
 * @see Documento
 */
public class Mision implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Identificador único de la misión. */
    private String id;

    /** Nombre del presidente que autoriza la misión. */
    private String presidente;

    /** Sede principal donde se ejecuta la misión. */
    private String sede;

    /** Jerarquía de mando dentro de la misión. */
    private String jerarquia;

    /** Visión a largo plazo de la misión. */
    private String vision;

    /** Objetivo principal de la misión. */
    private String objetivo;

    /** Metas específicas de la misión. */
    private String metas;

    /** Estrategia definida para alcanzar los objetivos. */
    private String estrategia;

    /** Año de inicio de la misión. */
    private int fechainicio;

    /** Año de finalización previsto de la misión. */
    private int fechafinal;

    /** Jefe responsable de la misión. */
    private Jefe jefe;

    /**
     * Construye un objeto {@code Mision} con todos sus atributos inicializados.
     *
     * @param id          Identificador único de la misión.
     * @param presidente  Nombre del presidente autorizador.
     * @param sede        Sede de la misión.
     * @param jerarquia   Jerarquía de mando.
     * @param vision      Visión a largo plazo.
     * @param objetivo    Objetivo principal.
     * @param metas       Metas específicas.
     * @param estrategia  Estrategia de ejecución.
     * @param fechainicio Año de inicio.
     * @param fechafinal  Año de finalización.
     * @param jefe        Jefe responsable de la misión.
     */
    public Mision(String id, String presidente, String sede, String jerarquia,
            String vision, String objetivo, String metas, String estrategia,
            int fechainicio, int fechafinal, Jefe jefe) {
        this.id = id;
        this.presidente = presidente;
        this.sede = sede;
        this.jerarquia = jerarquia;
        this.vision = vision;
        this.objetivo = objetivo;
        this.metas = metas;
        this.estrategia = estrategia;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.jefe = jefe;
    }

    /**
     * Calcula la duración total de la misión en años.
     *
     * @return Número de años entre {@code fechafinal} y {@code fechainicio}.
     */
    public int calcularDuracion() {
        return fechafinal - fechainicio;
    }

    /**
     * Retorna el identificador único de la misión.
     *
     * @return ID de la misión.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único de la misión.
     *
     * @param id ID de la misión.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el nombre del presidente autorizador.
     *
     * @return Nombre del presidente.
     */
    public String getPresidente() { return presidente; }

    /**
     * Establece el nombre del presidente autorizador.
     *
     * @param presidente Nombre del presidente.
     */
    public void setPresidente(String presidente) { this.presidente = presidente; }

    /**
     * Retorna la sede de la misión.
     *
     * @return Sede principal de la misión.
     */
    public String getSede() { return sede; }

    /**
     * Establece la sede de la misión.
     *
     * @param sede Sede principal de la misión.
     */
    public void setSede(String sede) { this.sede = sede; }

    /**
     * Retorna la jerarquía de mando de la misión.
     *
     * @return Jerarquía de la misión.
     */
    public String getJerarquia() { return jerarquia; }

    /**
     * Establece la jerarquía de mando de la misión.
     *
     * @param jerarquia Jerarquía de la misión.
     */
    public void setJerarquia(String jerarquia) { this.jerarquia = jerarquia; }

    /**
     * Retorna la visión a largo plazo de la misión.
     *
     * @return Visión de la misión.
     */
    public String getVision() { return vision; }

    /**
     * Establece la visión a largo plazo de la misión.
     *
     * @param vision Visión de la misión.
     */
    public void setVision(String vision) { this.vision = vision; }

    /**
     * Retorna el objetivo principal de la misión.
     *
     * @return Objetivo de la misión.
     */
    public String getObjetivo() { return objetivo; }

    /**
     * Establece el objetivo principal de la misión.
     *
     * @param objetivo Objetivo de la misión.
     */
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    /**
     * Retorna las metas específicas de la misión.
     *
     * @return Metas de la misión.
     */
    public String getMetas() { return metas; }

    /**
     * Establece las metas específicas de la misión.
     *
     * @param metas Metas de la misión.
     */
    public void setMetas(String metas) { this.metas = metas; }

    /**
     * Retorna la estrategia de ejecución de la misión.
     *
     * @return Estrategia de la misión.
     */
    public String getEstrategia() { return estrategia; }

    /**
     * Establece la estrategia de ejecución de la misión.
     *
     * @param estrategia Estrategia de la misión.
     */
    public void setEstrategia(String estrategia) { this.estrategia = estrategia; }

    /**
     * Retorna el año de inicio de la misión.
     *
     * @return Año de inicio.
     */
    public int getFechainicio() { return fechainicio; }

    /**
     * Establece el año de inicio de la misión.
     *
     * @param fechainicio Año de inicio.
     */
    public void setFechainicio(int fechainicio) { this.fechainicio = fechainicio; }

    /**
     * Retorna el año de finalización de la misión.
     *
     * @return Año de finalización.
     */
    public int getFechafinal() { return fechafinal; }

    /**
     * Establece el año de finalización de la misión.
     *
     * @param fechafinal Año de finalización.
     */
    public void setFechafinal(int fechafinal) { this.fechafinal = fechafinal; }

    /**
     * Retorna el jefe responsable de la misión.
     *
     * @return Objeto {@link Jefe} responsable.
     */
    public Jefe getJefe() { return jefe; }

    /**
     * Establece el jefe responsable de la misión.
     *
     * @param jefe Objeto {@link Jefe} responsable.
     */
    public void setJefe(Jefe jefe) { this.jefe = jefe; }

    /**
     * Retorna una representación en cadena del objeto {@code Mision}.
     *
     * @return Cadena con id, sede, objetivo y duración en años.
     */
    @Override
    public String toString() {
        return "Mision [id=" + id + ", sede=" + sede
                + ", objetivo=" + objetivo + ", duracion=" + calcularDuracion() + " anios]";
    }
}
