package co.edu.poli.contexto5.servicios;

/**
 * Clase de utilidad que centraliza todas las validaciones de datos
 * para objetos Personal. Cada metodo lanza PersonalException si
 * el valor suministrado no cumple las reglas de negocio.
 * 
 * PersonalException vive en el mismo paquete, por lo tanto
 * no se necesita import.
 */
public class ValidadorPersonal {

    // ── Constantes de longitud ────────────────────────────────────────────────
    private static final int MAX_CEDULA = 15;
    private static final int MAX_NOMBRE = 60;
    private static final int MAX_CARGO  = 40;
    private static final int MIN_EDAD   = 18;
    private static final int MAX_EDAD   = 100;

    // ── Constructor privado: clase estatica ───────────────────────────────────
    private ValidadorPersonal() {}

    // =========================================================================
    // CEDULA
    // =========================================================================

    /**
     * Valida que la cedula no sea nula/vacia, que solo contenga digitos y
     * que su longitud no supere MAX_CEDULA caracteres.
     *
     * @param cedula Valor a validar.
     * @throws PersonalException si la cedula es invalida.
     */
    public static void validarCedula(String cedula) throws PersonalException {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new PersonalException(
                "La cedula no puede estar vacia.", "cedula");
        }
        if (cedula.length() > MAX_CEDULA) {
            throw new PersonalException(
                "La cedula no puede superar " + MAX_CEDULA + " caracteres.", "cedula");
        }
        if (!cedula.matches("\\d+")) {
            throw new PersonalException(
                "La cedula solo puede contener digitos numericos (sin letras ni espacios).",
                "cedula");
        }
    }

    // =========================================================================
    // NOMBRE
    // =========================================================================

    /**
     * Valida que el nombre no sea nulo/vacio, que solo contenga letras y
     * espacios (incluye tildes y enie), y que no supere MAX_NOMBRE caracteres.
     *
     * @param nombre Valor a validar.
     * @throws PersonalException si el nombre es invalido.
     */
    public static void validarNombre(String nombre) throws PersonalException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new PersonalException(
                "El nombre no puede estar vacio.", "nombre");
        }
        if (nombre.length() > MAX_NOMBRE) {
            throw new PersonalException(
                "El nombre no puede superar " + MAX_NOMBRE + " caracteres.", "nombre");
        }
        if (!nombre.matches("[\\p{L} ]+")) {
            throw new PersonalException(
                "El nombre solo puede contener letras y espacios (sin numeros ni simbolos).",
                "nombre");
        }
    }

    // =========================================================================
    // CARGO
    // =========================================================================

    /**
     * Valida que el cargo no sea nulo/vacio y no supere MAX_CARGO caracteres.
     * Permite letras, digitos y espacios (ej. "Analista Jr 1").
     *
     * @param cargo Valor a validar.
     * @throws PersonalException si el cargo es invalido.
     */
    public static void validarCargo(String cargo) throws PersonalException {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new PersonalException(
                "El cargo no puede estar vacio.", "cargo");
        }
        if (cargo.length() > MAX_CARGO) {
            throw new PersonalException(
                "El cargo no puede superar " + MAX_CARGO + " caracteres.", "cargo");
        }
        if (!cargo.matches("[\\p{L}\\d ]+")) {
            throw new PersonalException(
                "El cargo solo puede contener letras, numeros y espacios.", "cargo");
        }
    }

    // =========================================================================
    // EDAD
    // =========================================================================

    /**
     * Valida que la edad este en el rango [MIN_EDAD, MAX_EDAD].
     *
     * @param edad Valor a validar.
     * @throws PersonalException si la edad esta fuera de rango.
     */
    public static void validarEdad(int edad) throws PersonalException {
        if (edad < MIN_EDAD || edad > MAX_EDAD) {
            throw new PersonalException(
                "La edad debe estar entre " + MIN_EDAD + " y " + MAX_EDAD + " anios.",
                "edad");
        }
    }

    // =========================================================================
    // SEXO
    // =========================================================================

    /**
     * Valida que el sexo sea 'M' o 'F' (mayuscula o minuscula).
     *
     * @param sexo Valor a validar.
     * @throws PersonalException si el sexo es distinto de M/F.
     */
    public static void validarSexo(char sexo) throws PersonalException {
        char s = Character.toUpperCase(sexo);
        if (s != 'M' && s != 'F') {
            throw new PersonalException(
                "El sexo solo puede ser 'M' (Masculino) o 'F' (Femenino).", "sexo");
        }
    }

    // =========================================================================
    // CAMPO GENERICO NO VACIO
    // =========================================================================

    /**
     * Valida que un campo de texto no sea nulo ni este vacio.
     *
     * @param valor       Valor a validar.
     * @param nombreCampo Nombre descriptivo del campo para el mensaje de error.
     * @throws PersonalException si el campo esta vacio.
     */
    public static void validarNoVacio(String valor, String nombreCampo)
            throws PersonalException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new PersonalException(
                "El campo '" + nombreCampo + "' no puede estar vacio.", nombreCampo);
        }
    }
}