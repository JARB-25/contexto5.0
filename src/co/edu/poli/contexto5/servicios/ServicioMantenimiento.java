package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Maquinaria;

public class ServicioMantenimiento extends Maquinaria {

    private String supervisor;
    private String mantenimientoasignado;

    public ServicioMantenimiento(double peso, String marca, String color, String material,
            String tamano, double preciofabrica, double aniofabricacion,
            String tipo, String nivelseguridad, String modoempleado,
            int anioctual, String personalautorizado,
            String supervisor, String mantenimientoasignado) {
        super(peso, marca, color, material, tamano, preciofabrica, aniofabricacion,
                tipo, nivelseguridad, modoempleado, anioctual, personalautorizado);
        this.supervisor = supervisor;
        this.mantenimientoasignado = mantenimientoasignado;
    }

    public String method(String type) {
        return "Servicio tipo: " + type + " | Supervisor: " + supervisor;
    }

    public String getSupervisor() { return supervisor; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    public String getMantenimientoasignado() { return mantenimientoasignado; }
    public void setMantenimientoasignado(String m) { this.mantenimientoasignado = m; }

    @Override
    public String toString() {
        return "ServicioMantenimiento [supervisor=" + supervisor
                + ", mantenimientoasignado=" + mantenimientoasignado + "]";
    }
}
