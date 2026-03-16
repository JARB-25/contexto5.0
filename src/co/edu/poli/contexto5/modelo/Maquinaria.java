package co.edu.poli.contexto5.modelo;

public class Maquinaria {

    private double peso;
    private String marca;
    private String color;
    private String material;
    private String tamano;
    private double preciofabrica;
    private double aniofabricacion;
    private String tipo;
    private String nivelseguridad;
    private String modoempleado;
    private int anioctual;
    private String personalautorizado;
    private Empleado[] empleado;

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

    // Metodo del diagrama: preciofabrica - (0.5)*(anioctual - aniodefabrica)
    public int calcularDeterioro(int aniodefabrica) {
        return (int) (preciofabrica - (0.5) * (anioctual - aniodefabrica));
    }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }

    public double getPreciofabrica() { return preciofabrica; }
    public void setPreciofabrica(double preciofabrica) { this.preciofabrica = preciofabrica; }

    public double getAniofabricacion() { return aniofabricacion; }
    public void setAniofabricacion(double aniofabricacion) { this.aniofabricacion = aniofabricacion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNivelseguridad() { return nivelseguridad; }
    public void setNivelseguridad(String nivelseguridad) { this.nivelseguridad = nivelseguridad; }

    public String getModoempleado() { return modoempleado; }
    public void setModoempleado(String modoempleado) { this.modoempleado = modoempleado; }

    public int getAnioctual() { return anioctual; }
    public void setAnioctual(int anioctual) { this.anioctual = anioctual; }

    public String getPersonalautorizado() { return personalautorizado; }
    public void setPersonalautorizado(String p) { this.personalautorizado = p; }

    public Empleado[] getEmpleado() { return empleado; }
    public void setEmpleado(Empleado[] empleado) { this.empleado = empleado; }

    @Override
    public String toString() {
        return "Maquinaria [marca=" + marca + ", tipo=" + tipo
                + ", preciofabrica=" + preciofabrica + ", anioctual=" + anioctual + "]";
    }
}
