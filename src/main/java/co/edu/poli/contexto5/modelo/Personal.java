package co.edu.poli.contexto5.modelo;

import java.io.Serializable;

/**
 * Clase abstracta que representa al personal del sistema de mantenimiento de satélites.
 * <p>
 * <b>Punto 1 - Clase abstracta:</b> Es la clase de mayor jerarquía dentro del
 * sistema de personal. Al ser abstracta, no puede instanciarse directamente;
 * obliga a las subclases a implementar el método {@link #realizarLabor()}.
 * </p>
 * <p>
 * Extiende de {@link Empleado} e implementa {@link Serializable} para
 * permitir la persistencia de sus instancias en archivos binarios.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Empleado
 * @see co.edu.poli.contexto5.servicios.ImplementacionOperacionCRUD
 */
public abstract class Personal extends Empleado implements Serializable {

    /** Identificador de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Número de cédula del personal (actúa como identificador único). */
    private String cedula;

    /** Nombre completo del personal. */
    private String nombre;

    /** Cargo o rol que desempeña el personal en la misión. */
    private String cargo;

    /** Código o nombre de la misión asignada al personal. */
    private String misionasignada;

    /** Nivel profesional del personal (junior, senior, etc.). */
    private String nivelprofesional;

    /** Año de nacimiento del personal. */
    private int anionacimiento;

    /** Descripción de las responsabilidades del personal. */
    private String responsabilidades;

    /** Tipo de contrato laboral del personal. */
    private String tipodecontrato;

    /** Beneficios laborales del personal. */
    private String beneficios;

    /** Autorizaciones de acceso o nivel de clearance del personal. */
    private String autorizaciones;

    /** Sexo del personal ('M' o 'F'). */
    private char sexo;

    /** Código de barras de identificación del personal. */
    private String codigobarras;

    /** Campo o área profesional del personal. */
    private String campoprofesional;

    /** Sueldo mensual del personal. */
    private double sueldo;

    /**
     * Construye un objeto {@code Personal} con todos sus atributos inicializados.
     *
     * @param cedula            Número de cédula (identificador único).
     * @param nombre            Nombre completo.
     * @param cargo             Cargo o rol en la misión.
     * @param misionasignada    Código o nombre de la misión asignada.
     * @param nivelprofesional  Nivel profesional.
     * @param anionacimiento    Año de nacimiento.
     * @param responsabilidades Descripción de responsabilidades.
     * @param tipodecontrato    Tipo de contrato laboral.
     * @param beneficios        Beneficios laborales.
     * @param autorizaciones    Autorizaciones de acceso.
     * @param sexo              Sexo del personal ('M' o 'F').
     * @param codigobarras      Código de barras de identificación.
     * @param campoprofesional  Área profesional.
     * @param sueldo            Sueldo mensual.
     */
    public Personal(String cedula, String nombre, String cargo, String misionasignada,
            String nivelprofesional, int anionacimiento, String responsabilidades,
            String tipodecontrato, String beneficios, String autorizaciones,
            char sexo, String codigobarras, String campoprofesional, double sueldo) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.cargo = cargo;
        this.misionasignada = misionasignada;
        this.nivelprofesional = nivelprofesional;
        this.anionacimiento = anionacimiento;
        this.responsabilidades = responsabilidades;
        this.tipodecontrato = tipodecontrato;
        this.beneficios = beneficios;
        this.autorizaciones = autorizaciones;
        this.sexo = sexo;
        this.codigobarras = codigobarras;
        this.campoprofesional = campoprofesional;
        this.sueldo = sueldo;
    }

    /**
     * Define la labor específica que realiza el personal en el sistema.
     * <p>
     * <b>Punto 1 - Método abstracto:</b> Cada subclase de {@code Personal}
     * debe proporcionar su propia implementación de este método, describiendo
     * la función concreta que desempeña dentro del mantenimiento de satélites.
     * </p>
     *
     * @return Descripción de la labor específica del personal.
     */
    public abstract String realizarLabor();

    /**
     * Retorna información detallada del personal.
     * <p>
     * <b>Punto 3 - Sobreescritura (Override):</b> Reemplaza el comportamiento
     * del método {@code obtenerInformacion()} de {@link Empleado}, proporcionando
     * datos específicos del personal como nombre, cédula, cargo y misión.
     * </p>
     *
     * @return Cadena con nombre, cédula, cargo y misión del personal.
     */
    @Override
    public String obtenerInformacion() {
        return "Personal: " + nombre
                + " | Cedula: " + cedula
                + " | Cargo: " + cargo
                + " | Mision: " + misionasignada;
    }

    /**
     * Calcula la nómina del personal con solo el sueldo base.
     * <p>
     * <b>Punto 3 - Sobrecarga (Overload):</b> Primer método {@code calcularNomina}
     * que recibe únicamente el sueldo como parámetro.
     * </p>
     *
     * @param sueldo Sueldo base del personal.
     * @return Valor del sueldo sin bonificaciones.
     */
    public double calcularNomina(double sueldo) {
        return sueldo;
    }

    /**
     * Calcula la nómina del personal con sueldo base más bono adicional.
     * <p>
     * <b>Punto 3 - Sobrecarga (Overload):</b> Segundo método {@code calcularNomina}
     * que recibe el sueldo y un bono como parámetros.
     * </p>
     *
     * @param sueldo Sueldo base del personal.
     * @param bono   Bonificación adicional.
     * @return Suma del sueldo base y la bonificación.
     */
    public double calcularNomina(double sueldo, double bono) {
        return sueldo + bono;
    }

    /**
     * Retorna el número de cédula del personal.
     *
     * @return Cédula del personal.
     */
    public String getCedula() { return cedula; }

    /**
     * Establece el número de cédula del personal.
     *
     * @param cedula Cédula del personal.
     */
    public void setCedula(String cedula) { this.cedula = cedula; }

    /**
     * Retorna el nombre completo del personal.
     *
     * @return Nombre del personal.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre completo del personal.
     *
     * @param nombre Nombre del personal.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna el cargo del personal.
     *
     * @return Cargo o rol del personal.
     */
    public String getCargo() { return cargo; }

    /**
     * Establece el cargo del personal.
     *
     * @param cargo Cargo o rol del personal.
     */
    public void setCargo(String cargo) { this.cargo = cargo; }

    /**
     * Retorna la misión asignada al personal.
     *
     * @return Código o nombre de la misión asignada.
     */
    public String getMisionasignada() { return misionasignada; }

    /**
     * Establece la misión asignada al personal.
     *
     * @param misionasignada Código o nombre de la misión asignada.
     */
    public void setMisionasignada(String misionasignada) { this.misionasignada = misionasignada; }

    /**
     * Retorna el nivel profesional del personal.
     *
     * @return Nivel profesional.
     */
    public String getNivelprofesional() { return nivelprofesional; }

    /**
     * Establece el nivel profesional del personal.
     *
     * @param nivelprofesional Nivel profesional.
     */
    public void setNivelprofesional(String nivelprofesional) { this.nivelprofesional = nivelprofesional; }

    /**
     * Retorna el año de nacimiento del personal.
     *
     * @return Año de nacimiento.
     */
    public int getAnionacimiento() { return anionacimiento; }

    /**
     * Establece el año de nacimiento del personal.
     *
     * @param anionacimiento Año de nacimiento.
     */
    public void setAnionacimiento(int anionacimiento) { this.anionacimiento = anionacimiento; }

    /**
     * Retorna las responsabilidades del personal.
     *
     * @return Descripción de responsabilidades.
     */
    public String getResponsabilidades() { return responsabilidades; }

    /**
     * Establece las responsabilidades del personal.
     *
     * @param responsabilidades Descripción de responsabilidades.
     */
    public void setResponsabilidades(String responsabilidades) { this.responsabilidades = responsabilidades; }

    /**
     * Retorna el tipo de contrato laboral del personal.
     *
     * @return Tipo de contrato.
     */
    public String getTipodecontrato() { return tipodecontrato; }

    /**
     * Establece el tipo de contrato laboral del personal.
     *
     * @param tipodecontrato Tipo de contrato.
     */
    public void setTipodecontrato(String tipodecontrato) { this.tipodecontrato = tipodecontrato; }

    /**
     * Retorna los beneficios laborales del personal.
     *
     * @return Beneficios laborales.
     */
    public String getBeneficios() { return beneficios; }

    /**
     * Establece los beneficios laborales del personal.
     *
     * @param beneficios Beneficios laborales.
     */
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }

    /**
     * Retorna las autorizaciones de acceso del personal.
     *
     * @return Autorizaciones del personal.
     */
    public String getAutorizaciones() { return autorizaciones; }

    /**
     * Establece las autorizaciones de acceso del personal.
     *
     * @param autorizaciones Autorizaciones del personal.
     */
    public void setAutorizaciones(String autorizaciones) { this.autorizaciones = autorizaciones; }

    /**
     * Retorna el sexo del personal.
     *
     * @return Sexo del personal ('M' o 'F').
     */
    public char getSexo() { return sexo; }

    /**
     * Establece el sexo del personal.
     *
     * @param sexo Sexo del personal ('M' o 'F').
     */
    public void setSexo(char sexo) { this.sexo = sexo; }

    /**
     * Retorna el código de barras de identificación del personal.
     *
     * @return Código de barras.
     */
    public String getCodigobarras() { return codigobarras; }

    /**
     * Establece el código de barras de identificación del personal.
     *
     * @param codigobarras Código de barras.
     */
    public void setCodigobarras(String codigobarras) { this.codigobarras = codigobarras; }

    /**
     * Retorna el campo o área profesional del personal.
     *
     * @return Área profesional.
     */
    public String getCampoprofesional() { return campoprofesional; }

    /**
     * Establece el campo o área profesional del personal.
     *
     * @param campoprofesional Área profesional.
     */
    public void setCampoprofesional(String campoprofesional) { this.campoprofesional = campoprofesional; }

    /**
     * Retorna el sueldo mensual del personal.
     *
     * @return Sueldo mensual.
     */
    public double getSueldo() { return sueldo; }

    /**
     * Establece el sueldo mensual del personal.
     *
     * @param sueldo Sueldo mensual.
     */
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    /**
     * Retorna una representación en cadena del objeto {@code Personal}.
     *
     * @return Cadena con cédula, nombre, cargo y sueldo.
     */
    @Override
    public String toString() {
        return "personal [cedula=" + cedula + ", nombre=" + nombre
                + ", cargo=" + cargo + ", sueldo=" + sueldo + "]";
    }
}
