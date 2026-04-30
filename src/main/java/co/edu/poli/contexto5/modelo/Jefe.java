package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa al jefe responsable de un satélite en el sistema.
 * <p>
 * Asocia un objeto {@link Satelite} al jefe encargado de supervisar
 * y gestionar las operaciones del mismo.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Satelite
 * @see Mision
 */
public class Jefe implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Satélite bajo la responsabilidad de este jefe. */
    private Satelite satelite;

    /**
     * Construye un objeto {@code Jefe} con el satélite asignado.
     *
     * @param satelite Objeto {@link Satelite} que este jefe supervisa.
     */
    public Jefe(Satelite satelite) {
        this.satelite = satelite;
    }

    /**
     * Retorna el satélite asignado a este jefe.
     *
     * @return Objeto {@link Satelite} supervisado por el jefe.
     */
    public Satelite getSatelite() { return satelite; }

    /**
     * Establece el satélite asignado a este jefe.
     *
     * @param satelite Objeto {@link Satelite} a supervisar.
     */
    public void setSatelite(Satelite satelite) { this.satelite = satelite; }

    /**
     * Retorna una representación en cadena del objeto {@code Jefe}.
     *
     * @return Cadena con el nombre del satélite asignado.
     */
    @Override
    public String toString() {
        return "Jefe [satelite=" + (satelite != null ? satelite.getNombre() : "null") + "]";
    }
}
