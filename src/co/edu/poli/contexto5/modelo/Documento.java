package co.edu.poli.contexto5.modelo;

public class Documento {

    private String id;
    private String fecha;
    private String categoria;
    private String tipo;
    private String encargado;
    private String solucion;
    private String lugar;
    private String plan;
    private String problema;
    private String objetivo;
    private String propuesta;
    private String firma;
    private String estado;
    private Mision mision;

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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEncargado() { return encargado; }
    public void setEncargado(String encargado) { this.encargado = encargado; }

    public String getSolucion() { return solucion; }
    public void setSolucion(String solucion) { this.solucion = solucion; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }

    public String getProblema() { return problema; }
    public void setProblema(String problema) { this.problema = problema; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getPropuesta() { return propuesta; }
    public void setPropuesta(String propuesta) { this.propuesta = propuesta; }

    public String getFirma() { return firma; }
    public void setFirma(String firma) { this.firma = firma; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Mision getMision() { return mision; }
    public void setMision(Mision mision) { this.mision = mision; }

    @Override
    public String toString() {
        return "Documento [id=" + id + ", fecha=" + fecha
                + ", categoria=" + categoria + ", estado=" + estado + "]";
    }
}
