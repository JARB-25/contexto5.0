package co.edu.poli.contexto5.modelo;

/*
 * PUNTO 3 - CLASE FINAL (no se puede heredar)
 * La palabra reservada "final" antes de "class" impide que cualquier otra
 * clase pueda extender de SistemaControl.
 * Intento de "class X extends SistemaControl" generaria un error de compilacion.
 */
public final class SistemaControl {

    /*
     * PUNTO 3 - ATRIBUTO FINAL (no se puede cambiar / constante)
     * Una vez asignado en el constructor (o en la declaracion), su valor
     * NO puede modificarse. Intentar hacer sistemaId = "otro" lanzaria
     * un error de compilacion.
     */
    private final String SISTEMA_ID;

    private String estado;
    private String responsable;

    public SistemaControl(String sistemaId, String estado, String responsable) {
        // El atributo final se asigna UNA SOLA VEZ aqui en el constructor
        this.SISTEMA_ID = sistemaId;
        this.estado     = estado;
        this.responsable = responsable;
    }

    /*
     * PUNTO 3 - METODO FINAL (no se puede sobreescribir)
     * Aunque SistemaControl es ya "final" (nadie puede heredarla), se
     * declara el metodo como "final" para ilustrar el concepto de forma
     * explicita: ningun hijo podria hacer @Override de verificarSistema().
     */
    public final String verificarSistema() {
        return "Sistema [" + SISTEMA_ID + "] | Estado: " + estado
                + " | Responsable: " + responsable;
    }

    public String getSistemaId()    { return SISTEMA_ID; }
    public String getEstado()       { return estado; }
    public void setEstado(String e) { this.estado = e; }
    public String getResponsable()  { return responsable; }
    public void setResponsable(String r) { this.responsable = r; }

    @Override
    public String toString() {
        return "SistemaControl [id=" + SISTEMA_ID + ", estado=" + estado + "]";
    }
}
