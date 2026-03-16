package co.edu.poli.contexto5.modelo;

public class Jefe {

    private Satelite satelite;

    public Jefe(Satelite satelite) {
        this.satelite = satelite;
    }

    public Satelite getSatelite() { return satelite; }
    public void setSatelite(Satelite satelite) { this.satelite = satelite; }

    @Override
    public String toString() {
        return "Jefe [satelite=" + (satelite != null ? satelite.getNombre() : "null") + "]";
    }
}
