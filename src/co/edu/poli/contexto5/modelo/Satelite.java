package co.edu.poli.contexto5.modelo;

public class Satelite {

    /*
     * PUNTO 2 y 4 - ATRIBUTO ESTATICO
     * En UML se representa SUBRAYADO en el diagrama de clases.
     * Es compartido por TODOS los objetos de la clase Satelite.
     */
    private static String agenciaEspacial = "NASA";

    private String nombre;
    private String id;
    private String material;
    private String manual;
    private String funcion;
    private String encargado;
    private String departamento;
    private String localizacion;
    private String tamano;
    private String transporte;
    private double capital;
    private Capital capitalObj;

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

    // Getter y Setter del atributo estático (acceso por clase)
    public static String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    public static void setAgenciaEspacial(String nuevaAgencia) {
        agenciaEspacial = nuevaAgencia;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getManual() { return manual; }
    public void setManual(String manual) { this.manual = manual; }

    public String getFuncion() { return funcion; }
    public void setFuncion(String funcion) { this.funcion = funcion; }

    public String getEncargado() { return encargado; }
    public void setEncargado(String encargado) { this.encargado = encargado; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }

    public String getTransporte() { return transporte; }
    public void setTransporte(String transporte) { this.transporte = transporte; }

    public double getCapital() { return capital; }
    public void setCapital(double capital) { this.capital = capital; }

    public Capital getCapitalObj() { return capitalObj; }
    public void setCapitalObj(Capital capitalObj) { this.capitalObj = capitalObj; }

    @Override
    public String toString() {
        return "Satelite [nombre=" + nombre + ", id=" + id
                + ", funcion=" + funcion + ", agenciaEspacial=" + agenciaEspacial + "]";
    }
}
