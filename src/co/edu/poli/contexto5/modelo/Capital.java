package co.edu.poli.contexto5.modelo;

public class Capital {

    private String origen;
    private String destino;
    private String gestores;
    private String contadores;
    private String supervisores;
    private String presidente;
    private double inversion;
    private double deuda;
    private String factura;
    private String mododeuso;

    public Capital(String origen, String destino, String gestores, String contadores,
            String supervisores, String presidente, double inversion,
            double deuda, String factura, String mododeuso) {
        this.origen = origen;
        this.destino = destino;
        this.gestores = gestores;
        this.contadores = contadores;
        this.supervisores = supervisores;
        this.presidente = presidente;
        this.inversion = inversion;
        this.deuda = deuda;
        this.factura = factura;
        this.mododeuso = mododeuso;
    }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getGestores() { return gestores; }
    public void setGestores(String gestores) { this.gestores = gestores; }

    public String getContadores() { return contadores; }
    public void setContadores(String contadores) { this.contadores = contadores; }

    public String getSupervisores() { return supervisores; }
    public void setSupervisores(String supervisores) { this.supervisores = supervisores; }

    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }

    public double getInversion() { return inversion; }
    public void setInversion(double inversion) { this.inversion = inversion; }

    public double getDeuda() { return deuda; }
    public void setDeuda(double deuda) { this.deuda = deuda; }

    public String getFactura() { return factura; }
    public void setFactura(String factura) { this.factura = factura; }

    public String getMododeuso() { return mododeuso; }
    public void setMododeuso(String mododeuso) { this.mododeuso = mododeuso; }

    @Override
    public String toString() {
        return "Capital [origen=" + origen + ", destino=" + destino
                + ", inversion=" + inversion + ", deuda=" + deuda + "]";
    }
}
