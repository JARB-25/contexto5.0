package co.edu.poli.contexto5.modelo;

public class TecnicoSatelite extends Personal {
    private static final long serialVersionUID = 1L;

    public TecnicoSatelite(String cedula, String nombre, String cargo,
                           String misionasignada, String nivelprofesional,
                           int anionacimiento, String responsabilidades,
                           String tipodecontrato, String beneficios,
                           String autorizaciones, char sexo,
                           String codigobarras, String campoprofesional,
                           double sueldo) {
        super(cedula, nombre, cargo, misionasignada, nivelprofesional,
              anionacimiento, responsabilidades, tipodecontrato, beneficios,
              autorizaciones, sexo, codigobarras, campoprofesional, sueldo);
    }

    @Override
    public String realizarLabor() {
        return "Técnico de satélites — " + getCargo();
    }
}