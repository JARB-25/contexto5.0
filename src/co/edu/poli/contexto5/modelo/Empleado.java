package co.edu.poli.contexto5.modelo;

public class Empleado {

    private Mantenimiento[] mantenimiento;

    public Empleado() {
    }

    public Empleado(Mantenimiento[] mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    /*
     * PUNTO 3 - SOBREESCRITURA
     * Este metodo sera sobreescrito (@Override) por la subclase "personal"
     */
    public String obtenerInformacion() {
        return "Empleado generico del sistema de satelites";
    }

    public Mantenimiento[] getMantenimiento() { return mantenimiento; }
    public void setMantenimiento(Mantenimiento[] mantenimiento) { this.mantenimiento = mantenimiento; }

    @Override
    public String toString() {
        return "Empleado [mantenimientos=" + (mantenimiento != null ? mantenimiento.length : 0) + "]";
    }
}
