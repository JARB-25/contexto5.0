package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Representa el capital financiero asociado a un satélite en el sistema.
 * <p>
 * Almacena información sobre la inversión, deuda, gestores y el modo
 * de uso de los recursos económicos dentro del proyecto espacial.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Satelite
 */
public class Capital implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** País o entidad de procedencia del capital. */
    private String origen;

    /** País o entidad receptora del capital. */
    private String destino;

    /** Nombres de los gestores financieros responsables. */
    private String gestores;

    /** Nombres de los contadores encargados del capital. */
    private String contadores;

    /** Nombres de los supervisores del capital. */
    private String supervisores;

    /** Nombre del presidente que autoriza el capital. */
    private String presidente;

    /** Monto total invertido en el proyecto. */
    private double inversion;

    /** Monto total de deuda acumulada. */
    private double deuda;

    /** Número o referencia de la factura asociada. */
    private String factura;

    /** Descripción del modo de uso asignado al capital. */
    private String mododeuso;

    /**
     * Construye un objeto {@code Capital} con todos sus atributos inicializados.
     *
     * @param origen       País o entidad de donde proviene el capital.
     * @param destino      País o entidad que recibe el capital.
     * @param gestores     Nombres de los gestores financieros.
     * @param contadores   Nombres de los contadores responsables.
     * @param supervisores Nombres de los supervisores.
     * @param presidente   Nombre del presidente autorizador.
     * @param inversion    Monto total invertido.
     * @param deuda        Monto total de la deuda.
     * @param factura      Referencia de la factura.
     * @param mododeuso    Descripción del modo de uso del capital.
     */
    public Capital(String origen, String destino, String gestores, String contadores,
            String supervisores, String presidente, double inversion,
            double deuda, String factura, String mododeuso) {
        this.origen = origen;
        this.destino = destino;
        this.gestores = gestores;
        this.contadores = contadores;
        this.supervisores = supervisores;
        this.presidente = presidente;
        this.inversion = inversion;
        this.deuda = deuda;
        this.factura = factura;
        this.mododeuso = mododeuso;
    }

    /**
     * Retorna el origen del capital.
     *
     * @return País o entidad de origen del capital.
     */
    public String getOrigen() { return origen; }

    /**
     * Establece el origen del capital.
     *
     * @param origen País o entidad de origen del capital.
     */
    public void setOrigen(String origen) { this.origen = origen; }

    /**
     * Retorna el destino del capital.
     *
     * @return País o entidad destino del capital.
     */
    public String getDestino() { return destino; }

    /**
     * Establece el destino del capital.
     *
     * @param destino País o entidad destino del capital.
     */
    public void setDestino(String destino) { this.destino = destino; }

    /**
     * Retorna los gestores financieros del capital.
     *
     * @return Nombres de los gestores.
     */
    public String getGestores() { return gestores; }

    /**
     * Establece los gestores financieros del capital.
     *
     * @param gestores Nombres de los gestores.
     */
    public void setGestores(String gestores) { this.gestores = gestores; }

    /**
     * Retorna los contadores responsables del capital.
     *
     * @return Nombres de los contadores.
     */
    public String getContadores() { return contadores; }

    /**
     * Establece los contadores responsables del capital.
     *
     * @param contadores Nombres de los contadores.
     */
    public void setContadores(String contadores) { this.contadores = contadores; }

    /**
     * Retorna los supervisores del capital.
     *
     * @return Nombres de los supervisores.
     */
    public String getSupervisores() { return supervisores; }

    /**
     * Establece los supervisores del capital.
     *
     * @param supervisores Nombres de los supervisores.
     */
    public void setSupervisores(String supervisores) { this.supervisores = supervisores; }

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
     * Retorna el monto total de inversión.
     *
     * @return Valor de la inversión.
     */
    public double getInversion() { return inversion; }

    /**
     * Establece el monto total de inversión.
     *
     * @param inversion Valor de la inversión.
     */
    public void setInversion(double inversion) { this.inversion = inversion; }

    /**
     * Retorna el monto total de la deuda.
     *
     * @return Valor de la deuda.
     */
    public double getDeuda() { return deuda; }

    /**
     * Establece el monto total de la deuda.
     *
     * @param deuda Valor de la deuda.
     */
    public void setDeuda(double deuda) { this.deuda = deuda; }

    /**
     * Retorna la referencia de la factura asociada.
     *
     * @return Número o código de la factura.
     */
    public String getFactura() { return factura; }

    /**
     * Establece la referencia de la factura asociada.
     *
     * @param factura Número o código de la factura.
     */
    public void setFactura(String factura) { this.factura = factura; }

    /**
     * Retorna el modo de uso asignado al capital.
     *
     * @return Descripción del modo de uso.
     */
    public String getMododeuso() { return mododeuso; }

    /**
     * Establece el modo de uso asignado al capital.
     *
     * @param mododeuso Descripción del modo de uso.
     */
    public void setMododeuso(String mododeuso) { this.mododeuso = mododeuso; }

    /**
     * Retorna una representación en cadena del objeto {@code Capital}.
     *
     * @return Cadena con origen, destino, inversión y deuda.
     */
    @Override
    public String toString() {
        return "Capital [origen=" + origen + ", destino=" + destino
                + ", inversion=" + inversion + ", deuda=" + deuda + "]";
    }
}
