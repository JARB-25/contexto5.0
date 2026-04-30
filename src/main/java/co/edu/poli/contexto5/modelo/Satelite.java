package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa un satélite gestionado dentro del sistema espacial.
 * <p>
 * Contiene los datos técnicos, administrativos y financieros del satélite.
 * Incluye un atributo estático {@code agenciaEspacial} que es compartido
 * por todos los objetos de esta clase (Punto 2 y 4 - Atributo estático,
 * representado subrayado en el diagrama UML).
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Capital
 * @see Jefe
 */
public class Satelite implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre de la agencia espacial responsable.
     * <p>
     * <b>Punto 2 y 4 - Atributo estático:</b> Es compartido por TODOS los
     * objetos de la clase {@code Satelite}. En UML se representa subrayado
     * en el diagrama de clases.
     * </p>
     */
    private static String agenciaEspacial = "NASA";

    /** Nombre identificador del satélite. */
    private String nombre;

    /** Identificador único del satélite. */
    private String id;

    /** Material principal con el que está fabricado el satélite. */
    private String material;

    /** Referencia al manual técnico del satélite. */
    private String manual;

    /** Función o propósito principal del satélite. */
    private String funcion;

    /** Nombre del encargado responsable del satélite. */
    private String encargado;

    /** Departamento responsable de la gestión del satélite. */
    private String departamento;

    /** Localización actual o área de cobertura del satélite. */
    private String localizacion;

    /** Tamaño o dimensiones del satélite. */
    private String tamano;

    /** Medio de transporte utilizado para el lanzamiento. */
    private String transporte;

    /** Capital económico asignado al satélite. */
    private double capital;

    /** Objeto {@link Capital} con el detalle financiero del satélite. */
    private Capital capitalObj;

    /**
     * Construye un objeto {@code Satelite} con todos sus atributos inicializados.
     *
     * @param nombre       Nombre del satélite.
     * @param id           Identificador único.
     * @param material     Material de fabricación.
     * @param manual       Referencia al manual técnico.
     * @param funcion      Función o propósito.
     * @param encargado    Nombre del encargado.
     * @param departamento Departamento responsable.
     * @param localizacion Localización o área de cobertura.
     * @param tamano       Tamaño o dimensiones.
     * @param transporte   Medio de transporte para el lanzamiento.
     * @param capital      Capital económico asignado.
     * @param capitalObj   Detalle financiero del capital.
     */
    public Satelite(String nombre, String id, String material, String manual,
            String funcion, String encargado, String departamento,
            String localizacion, String tamano, String transporte,
            double capital, Capital capitalObj) {
        this.nombre = nombre;
        this.id = id;
        this.material = material;
        this.manual = manual;
        this.funcion = funcion;
        this.encargado = encargado;
        this.departamento = departamento;
        this.localizacion = localizacion;
        this.tamano = tamano;
        this.transporte = transporte;
        this.capital = capital;
        this.capitalObj = capitalObj;
    }

    /**
     * Retorna el nombre de la agencia espacial (atributo de clase).
     *
     * @return Nombre de la agencia espacial.
     */
    public static String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    /**
     * Establece el nombre de la agencia espacial (atributo de clase).
     * <p>
     * Al ser estático, el cambio aplica para todos los objetos {@code Satelite}.
     * </p>
     *
     * @param nuevaAgencia Nuevo nombre de la agencia espacial.
     */
    public static void setAgenciaEspacial(String nuevaAgencia) {
        agenciaEspacial = nuevaAgencia;
    }

    /**
     * Retorna el nombre del satélite.
     *
     * @return Nombre del satélite.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del satélite.
     *
     * @param nombre Nombre del satélite.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna el identificador único del satélite.
     *
     * @return ID del satélite.
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único del satélite.
     *
     * @param id ID del satélite.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el material de fabricación del satélite.
     *
     * @return Material del satélite.
     */
    public String getMaterial() { return material; }

    /**
     * Establece el material de fabricación del satélite.
     *
     * @param material Material del satélite.
     */
    public void setMaterial(String material) { this.material = material; }

    /**
     * Retorna la referencia al manual técnico del satélite.
     *
     * @return Manual técnico.
     */
    public String getManual() { return manual; }

    /**
     * Establece la referencia al manual técnico del satélite.
     *
     * @param manual Manual técnico.
     */
    public void setManual(String manual) { this.manual = manual; }

    /**
     * Retorna la función o propósito principal del satélite.
     *
     * @return Función del satélite.
     */
    public String getFuncion() { return funcion; }

    /**
     * Establece la función o propósito principal del satélite.
     *
     * @param funcion Función del satélite.
     */
    public void setFuncion(String funcion) { this.funcion = funcion; }

    /**
     * Retorna el nombre del encargado del satélite.
     *
     * @return Nombre del encargado.
     */
    public String getEncargado() { return encargado; }

    /**
     * Establece el nombre del encargado del satélite.
     *
     * @param encargado Nombre del encargado.
     */
    public void setEncargado(String encargado) { this.encargado = encargado; }

    /**
     * Retorna el departamento responsable del satélite.
     *
     * @return Departamento responsable.
     */
    public String getDepartamento() { return departamento; }

    /**
     * Establece el departamento responsable del satélite.
     *
     * @param departamento Departamento responsable.
     */
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    /**
     * Retorna la localización del satélite.
     *
     * @return Localización o área de cobertura.
     */
    public String getLocalizacion() { return localizacion; }

    /**
     * Establece la localización del satélite.
     *
     * @param localizacion Localización o área de cobertura.
     */
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    /**
     * Retorna el tamaño del satélite.
     *
     * @return Tamaño o dimensiones.
     */
    public String getTamano() { return tamano; }

    /**
     * Establece el tamaño del satélite.
     *
     * @param tamano Tamaño o dimensiones.
     */
    public void setTamano(String tamano) { this.tamano = tamano; }

    /**
     * Retorna el medio de transporte para el lanzamiento del satélite.
     *
     * @return Medio de transporte.
     */
    public String getTransporte() { return transporte; }

    /**
     * Establece el medio de transporte para el lanzamiento del satélite.
     *
     * @param transporte Medio de transporte.
     */
    public void setTransporte(String transporte) { this.transporte = transporte; }

    /**
     * Retorna el capital económico asignado al satélite.
     *
     * @return Capital económico.
     */
    public double getCapital() { return capital; }

    /**
     * Establece el capital económico asignado al satélite.
     *
     * @param capital Capital económico.
     */
    public void setCapital(double capital) { this.capital = capital; }

    /**
     * Retorna el objeto con el detalle financiero del capital.
     *
     * @return Objeto {@link Capital} con el detalle financiero.
     */
    public Capital getCapitalObj() { return capitalObj; }

    /**
     * Establece el objeto con el detalle financiero del capital.
     *
     * @param capitalObj Objeto {@link Capital} con el detalle financiero.
     */
    public void setCapitalObj(Capital capitalObj) { this.capitalObj = capitalObj; }

    /**
     * Retorna una representación en cadena del objeto {@code Satelite}.
     *
     * @return Cadena con nombre, id, función y agencia espacial.
     */
    @Override
    public String toString() {
        return "Satelite [nombre=" + nombre + ", id=" + id
                + ", funcion=" + funcion + ", agenciaEspacial=" + agenciaEspacial + "]";
    }
}
