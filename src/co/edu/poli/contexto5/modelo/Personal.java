package co.edu.poli.contexto5.modelo;

public class Personal extends Empleado {

    private String cedula;
    private String nombre;
    private String cargo;
    private String misionasignada;
    private String nivelprofesional;
    private int anionacimiento;
    private String responsabilidades;
    private String tipodecontrato;
    private String beneficios;
    private String autorizaciones;
    private char sexo;
    private String codigobarras;
    private String campoprofesional;
    private double sueldo;

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

    /*
     * PUNTO 3 - SOBREESCRITURA (Override)
     * Reemplaza el comportamiento del metodo obtenerInformacion() de Empleado
     */
    @Override
    public String obtenerInformacion() {
        return "Personal: " + nombre
                + " | Cedula: " + cedula
                + " | Cargo: " + cargo
                + " | Mision: " + misionasignada;
    }

    /*
     * PUNTO 3 - SOBRECARGA (Overload)
     * Mismo nombre "calcularNomina", distintos parametros
     */
    public double calcularNomina(double sueldo) {
        return sueldo;
    }

    public double calcularNomina(double sueldo, double bono) {
        return sueldo + bono;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getMisionasignada() { return misionasignada; }
    public void setMisionasignada(String misionasignada) { this.misionasignada = misionasignada; }

    public String getNivelprofesional() { return nivelprofesional; }
    public void setNivelprofesional(String nivelprofesional) { this.nivelprofesional = nivelprofesional; }

    public int getAnionacimiento() { return anionacimiento; }
    public void setAnionacimiento(int anionacimiento) { this.anionacimiento = anionacimiento; }

    public String getResponsabilidades() { return responsabilidades; }
    public void setResponsabilidades(String responsabilidades) { this.responsabilidades = responsabilidades; }

    public String getTipodecontrato() { return tipodecontrato; }
    public void setTipodecontrato(String tipodecontrato) { this.tipodecontrato = tipodecontrato; }

    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }

    public String getAutorizaciones() { return autorizaciones; }
    public void setAutorizaciones(String autorizaciones) { this.autorizaciones = autorizaciones; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public String getCodigobarras() { return codigobarras; }
    public void setCodigobarras(String codigobarras) { this.codigobarras = codigobarras; }

    public String getCampoprofesional() { return campoprofesional; }
    public void setCampoprofesional(String campoprofesional) { this.campoprofesional = campoprofesional; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return "personal [cedula=" + cedula + ", nombre=" + nombre
                + ", cargo=" + cargo + ", sueldo=" + sueldo + "]";
    }
}
