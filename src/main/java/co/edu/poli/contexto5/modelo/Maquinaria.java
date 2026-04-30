package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa la maquinaria utilizada en el mantenimiento de satélites.
 * <p>
 * Almacena las características técnicas y administrativas de cada equipo,
 * incluyendo datos de fabricación, seguridad y los empleados autorizados
 * para operarla.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Empleado
 * @see co.edu.poli.contexto5.servicios.ServicioMantenimiento
 */
public class Maquinaria implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Peso de la maquinaria en kilogramos. */
    private double peso;

    /** Marca o fabricante de la maquinaria. */
    private String marca;

    /** Color de la maquinaria. */
    private String color;

    /** Material principal con el que está fabricada la maquinaria. */
    private String material;

    /** Tamaño o dimensiones de la maquinaria. */
    private String tamano;

    /** Precio de fábrica original de la maquinaria. */
    private double preciofabrica;

    /** Año de fabricación de la maquinaria. */
    private double aniofabricacion;

    /** Tipo o clasificación de la maquinaria. */
    private String tipo;

    /** Nivel de seguridad requerido para operar la maquinaria. */
    private String nivelseguridad;

    /** Modo de uso o forma en que el empleado debe operar la maquinaria. */
    private String modoempleado;

    /** Año actual para el cálculo del deterioro. */
    private int anioctual;

    /** Nombre(s) del personal autorizado para operar la maquinaria. */
    private String personalautorizado;

    /** Arreglo de empleados asociados a esta maquinaria. */
    private Empleado[] empleado;

    /**
     * Construye un objeto {@code Maquinaria} con todos sus atributos técnicos inicializados.
     *
     * @param peso               Peso de la maquinaria (kg).
     * @param marca              Marca o fabricante.
     * @param color              Color de la maquinaria.
     * @param material           Material principal de fabricación.
     * @param tamano             Tamaño o dimensiones.
     * @param preciofabrica      Precio original de fábrica.
     * @param aniofabricacion    Año de fabricación.
     * @param tipo               Tipo o clasificación de la maquinaria.
     * @param nivelseguridad     Nivel de seguridad requerido.
     * @param modoempleado       Modo de uso por parte del empleado.
     * @param anioctual          Año actual para cálculo de deterioro.
     * @param personalautorizado Personal autorizado para operar la maquinaria.
     */
    public Maquinaria(double peso, String marca, String color, String material,
            String tamano, double preciofabrica, double aniofabricacion,
            String tipo, String nivelseguridad, String modoempleado,
            int anioctual, String personalautorizado) {
        this.peso = peso;
        this.marca = marca;
        this.color = color;
        this.material = material;
        this.tamano = tamano;
        this.preciofabrica = preciofabrica;
        this.aniofabricacion = aniofabricacion;
        this.tipo = tipo;
        this.nivelseguridad = nivelseguridad;
        this.modoempleado = modoempleado;
        this.anioctual = anioctual;
        this.personalautorizado = personalautorizado;
    }

    /**
     * Calcula el nivel de deterioro de la maquinaria según los años transcurridos.
     * <p>
     * Fórmula: {@code preciofabrica - (0.5) * (anioctual - aniodefabrica)}
     * </p>
     *
     * @param aniodefabrica Año en que fue fabricada la maquinaria.
     * @return Valor entero que representa el deterioro acumulado.
     */
    public int calcularDeterioro(int aniodefabrica) {
        return (int) (preciofabrica - (0.5) * (anioctual - aniodefabrica));
    }

    /**
     * Retorna el peso de la maquinaria.
     *
     * @return Peso en kilogramos.
     */
    public double getPeso() { return peso; }

    /**
     * Establece el peso de la maquinaria.
     *
     * @param peso Peso en kilogramos.
     */
    public void setPeso(double peso) { this.peso = peso; }

    /**
     * Retorna la marca de la maquinaria.
     *
     * @return Marca o fabricante.
     */
    public String getMarca() { return marca; }

    /**
     * Establece la marca de la maquinaria.
     *
     * @param marca Marca o fabricante.
     */
    public void setMarca(String marca) { this.marca = marca; }

    /**
     * Retorna el color de la maquinaria.
     *
     * @return Color de la maquinaria.
     */
    public String getColor() { return color; }

    /**
     * Establece el color de la maquinaria.
     *
     * @param color Color de la maquinaria.
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Retorna el material principal de fabricación.
     *
     * @return Material de fabricación.
     */
    public String getMaterial() { return material; }

    /**
     * Establece el material principal de fabricación.
     *
     * @param material Material de fabricación.
     */
    public void setMaterial(String material) { this.material = material; }

    /**
     * Retorna el tamaño o dimensiones de la maquinaria.
     *
     * @return Tamaño de la maquinaria.
     */
    public String getTamano() { return tamano; }

    /**
     * Establece el tamaño o dimensiones de la maquinaria.
     *
     * @param tamano Tamaño de la maquinaria.
     */
    public void setTamano(String tamano) { this.tamano = tamano; }

    /**
     * Retorna el precio original de fábrica.
     *
     * @return Precio de fábrica.
     */
    public double getPreciofabrica() { return preciofabrica; }

    /**
     * Establece el precio original de fábrica.
     *
     * @param preciofabrica Precio de fábrica.
     */
    public void setPreciofabrica(double preciofabrica) { this.preciofabrica = preciofabrica; }

    /**
     * Retorna el año de fabricación de la maquinaria.
     *
     * @return Año de fabricación.
     */
    public double getAniofabricacion() { return aniofabricacion; }

    /**
     * Establece el año de fabricación de la maquinaria.
     *
     * @param aniofabricacion Año de fabricación.
     */
    public void setAniofabricacion(double aniofabricacion) { this.aniofabricacion = aniofabricacion; }

    /**
     * Retorna el tipo o clasificación de la maquinaria.
     *
     * @return Tipo de la maquinaria.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo o clasificación de la maquinaria.
     *
     * @param tipo Tipo de la maquinaria.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Retorna el nivel de seguridad requerido para operar la maquinaria.
     *
     * @return Nivel de seguridad.
     */
    public String getNivelseguridad() { return nivelseguridad; }

    /**
     * Establece el nivel de seguridad requerido para operar la maquinaria.
     *
     * @param nivelseguridad Nivel de seguridad.
     */
    public void setNivelseguridad(String nivelseguridad) { this.nivelseguridad = nivelseguridad; }

    /**
     * Retorna el modo de uso de la maquinaria por parte del empleado.
     *
     * @return Modo de uso del empleado.
     */
    public String getModoempleado() { return modoempleado; }

    /**
     * Establece el modo de uso de la maquinaria por parte del empleado.
     *
     * @param modoempleado Modo de uso del empleado.
     */
    public void setModoempleado(String modoempleado) { this.modoempleado = modoempleado; }

    /**
     * Retorna el año actual utilizado para cálculos de deterioro.
     *
     * @return Año actual.
     */
    public int getAnioctual() { return anioctual; }

    /**
     * Establece el año actual para cálculos de deterioro.
     *
     * @param anioctual Año actual.
     */
    public void setAnioctual(int anioctual) { this.anioctual = anioctual; }

    /**
     * Retorna el personal autorizado para operar la maquinaria.
     *
     * @return Nombre(s) del personal autorizado.
     */
    public String getPersonalautorizado() { return personalautorizado; }

    /**
     * Establece el personal autorizado para operar la maquinaria.
     *
     * @param p Nombre(s) del personal autorizado.
     */
    public void setPersonalautorizado(String p) { this.personalautorizado = p; }

    /**
     * Retorna el arreglo de empleados asociados a esta maquinaria.
     *
     * @return Arreglo de objetos {@link Empleado}.
     */
    public Empleado[] getEmpleado() { return empleado; }

    /**
     * Establece el arreglo de empleados asociados a esta maquinaria.
     *
     * @param empleado Arreglo de objetos {@link Empleado}.
     */
    public void setEmpleado(Empleado[] empleado) { this.empleado = empleado; }

    /**
     * Retorna una representación en cadena del objeto {@code Maquinaria}.
     *
     * @return Cadena con marca, tipo, precio de fábrica y año actual.
     */
    @Override
    public String toString() {
        return "Maquinaria [marca=" + marca + ", tipo=" + tipo
                + ", preciofabrica=" + preciofabrica + ", anioctual=" + anioctual + "]";
    }
}
