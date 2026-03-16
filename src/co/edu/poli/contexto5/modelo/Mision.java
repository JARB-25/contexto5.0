package co.edu.poli.contexto5.modelo;

public class Mision {

    private String id;
    private String presidente;
    private String sede;
    private String jerarquia;
    private String vision;
    private String objetivo;
    private String metas;
    private String estrategia;
    private int fechainicio;
    private int fechafinal;
    private Jefe jefe;

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

    public int calcularDuracion() {
        return fechafinal - fechainicio;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }

    public String getSede() { return sede; }
    public void setSede(String sede) { this.sede = sede; }

    public String getJerarquia() { return jerarquia; }
    public void setJerarquia(String jerarquia) { this.jerarquia = jerarquia; }

    public String getVision() { return vision; }
    public void setVision(String vision) { this.vision = vision; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getMetas() { return metas; }
    public void setMetas(String metas) { this.metas = metas; }

    public String getEstrategia() { return estrategia; }
    public void setEstrategia(String estrategia) { this.estrategia = estrategia; }

    public int getFechainicio() { return fechainicio; }
    public void setFechainicio(int fechainicio) { this.fechainicio = fechainicio; }

    public int getFechafinal() { return fechafinal; }
    public void setFechafinal(int fechafinal) { this.fechafinal = fechafinal; }

    public Jefe getJefe() { return jefe; }
    public void setJefe(Jefe jefe) { this.jefe = jefe; }

    @Override
    public String toString() {
        return "Mision [id=" + id + ", sede=" + sede
                + ", objetivo=" + objetivo + ", duracion=" + calcularDuracion() + " anios]";
    }
}
