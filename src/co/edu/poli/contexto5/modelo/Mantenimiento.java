package co.edu.poli.contexto5.modelo;

public class Mantenimiento {

    private String nit;
    private String fecha;
    private String gerente;
    private String supervisor;
    private String personal;
    private String herramientas;
    private String justificacion;
    private String propuesta;
    private double capital;
    private Documento[] documento;

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

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getGerente() { return gerente; }
    public void setGerente(String gerente) { this.gerente = gerente; }

    public String getSupervisor() { return supervisor; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    public String getPersonal() { return personal; }
    public void setPersonal(String personal) { this.personal = personal; }

    public String getHerramientas() { return herramientas; }
    public void setHerramientas(String herramientas) { this.herramientas = herramientas; }

    public String getJustificacion() { return justificacion; }
    public void setJustificacion(String justificacion) { this.justificacion = justificacion; }

    public String getPropuesta() { return propuesta; }
    public void setPropuesta(String propuesta) { this.propuesta = propuesta; }

    public double getCapital() { return capital; }
    public void setCapital(double capital) { this.capital = capital; }

    public Documento[] getDocumento() { return documento; }
    public void setDocumento(Documento[] documento) { this.documento = documento; }

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
