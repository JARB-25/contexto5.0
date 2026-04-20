package co.edu.poli.contexto5.servicios;

/**
 * Excepcion personalizada para el Sistema de Gestion de Personal.
 * Se lanza cuando los datos de un Personal son invalidos.
 */
public class PersonalException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String campo;

    public PersonalException(String mensaje, String campo) {
        super(mensaje);
        this.campo = campo;
    }

    public PersonalException(String mensaje, String campo, Throwable causa) {
        super(mensaje, causa);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    @Override
    public String toString() {
        return "PersonalException [campo=" + campo + "] -> " + getMessage();
    }
}