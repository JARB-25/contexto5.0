package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa el sistema de control del proyecto espacial.
 * <p>
 * <b>Punto 3 - Clase final:</b> La palabra reservada {@code final} antes de
 * {@code class} impide que cualquier otra clase pueda extender de
 * {@code SistemaControl}. Un intento de {@code class X extends SistemaControl}
 * generaría un error de compilación.
 * </p>
 * <p>
 * Contiene el identificador inmutable del sistema, su estado operativo y
 * el responsable a cargo.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 */
public final class SistemaControl implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único e inmutable del sistema de control.
     * <p>
     * <b>Punto 3 - Atributo final:</b> Una vez asignado en el constructor,
     * su valor NO puede modificarse. Cualquier intento de reasignación
     * generaría un error de compilación.
     * </p>
     */
    private final String SISTEMA_ID;

    /** Estado operativo actual del sistema (activo, inactivo, en mantenimiento). */
    private String estado;

    /** Nombre del responsable a cargo del sistema de control. */
    private String responsable;

    /**
     * Construye un objeto {@code SistemaControl} con todos sus atributos inicializados.
     * <p>
     * El atributo final {@code SISTEMA_ID} se asigna una única vez aquí.
     * </p>
     *
     * @param sistemaId   Identificador único e inmutable del sistema.
     * @param estado      Estado operativo inicial del sistema.
     * @param responsable Nombre del responsable a cargo.
     */
    public SistemaControl(String sistemaId, String estado, String responsable) {
        this.SISTEMA_ID  = sistemaId;
        this.estado      = estado;
        this.responsable = responsable;
    }

    /**
     * Verifica y retorna el estado actual del sistema de control.
     * <p>
     * <b>Punto 3 - Método final:</b> Aunque {@code SistemaControl} es ya una
     * clase {@code final} (nadie puede heredarla), este método se declara
     * explícitamente como {@code final} para ilustrar el concepto: ningún
     * hipotético hijo podría hacer {@code @Override} de {@code verificarSistema()}.
     * </p>
     *
     * @return Cadena con el ID del sistema, su estado y el responsable.
     */
    public final String verificarSistema() {
        return "Sistema [" + SISTEMA_ID + "] | Estado: " + estado
                + " | Responsable: " + responsable;
    }

    /**
     * Retorna el identificador único del sistema.
     *
     * @return ID del sistema de control.
     */
    public String getSistemaId()    { return SISTEMA_ID; }

    /**
     * Retorna el estado operativo del sistema.
     *
     * @return Estado actual del sistema.
     */
    public String getEstado()       { return estado; }

    /**
     * Establece el estado operativo del sistema.
     *
     * @param e Nuevo estado del sistema.
     */
    public void setEstado(String e) { this.estado = e; }

    /**
     * Retorna el nombre del responsable del sistema.
     *
     * @return Nombre del responsable.
     */
    public String getResponsable()  { return responsable; }

    /**
     * Establece el nombre del responsable del sistema.
     *
     * @param r Nombre del nuevo responsable.
     */
    public void setResponsable(String r) { this.responsable = r; }

    /**
     * Retorna una representación en cadena del objeto {@code SistemaControl}.
     *
     * @return Cadena con el ID y estado del sistema.
     */
    @Override
    public String toString() {
        return "SistemaControl [id=" + SISTEMA_ID + ", estado=" + estado + "]";
    }
}
