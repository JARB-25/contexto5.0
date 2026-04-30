package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Mantenimiento;

/**
 * Servicio CRUD para la gestión de registros de {@link Mantenimiento}.
 * <p>
 * Sigue el mismo patrón que {@link ImplementacionOperacionCRUD}:
 * arreglo dinámico con agregación infinita, búsqueda por NIT como ID único.
 * </p>
 *
 * @author Poliedro
 * @version 2.0
 */
public class ServicioMantenimiento {

    /** Arreglo interno de mantenimientos con capacidad inicial de 2. */
    private Mantenimiento[] listaMantenimiento = new Mantenimiento[2];

    /**
     * Registra un nuevo mantenimiento. Si el arreglo está lleno, duplica su capacidad.
     *
     * @param m Objeto {@link Mantenimiento} a registrar.
     * @return Mensaje con el resultado de la operación.
     */
    public String crear(Mantenimiento m) {
        if (m == null) return "Error: no se puede registrar un mantenimiento nulo.";
        if (m.getNit() == null || m.getNit().trim().isEmpty())
            return "Error: el NIT no puede estar vacío.";

        for (Mantenimiento existente : listaMantenimiento) {
            if (existente != null && existente.getNit().equals(m.getNit()))
                return "Error: ya existe un registro con NIT " + m.getNit() + ".";
        }

        for (int i = 0; i < listaMantenimiento.length; i++) {
            if (listaMantenimiento[i] == null) {
                listaMantenimiento[i] = m;
                return "Mantenimiento registrado con éxito en posición [" + i + "]. NIT: " + m.getNit();
            }
        }

        // Agregación infinita
        Mantenimiento[] nueva = new Mantenimiento[listaMantenimiento.length * 2];
        System.arraycopy(listaMantenimiento, 0, nueva, 0, listaMantenimiento.length);
        int pos = listaMantenimiento.length;
        nueva[pos] = m;
        listaMantenimiento = nueva;
        return "Arreglo expandido a " + listaMantenimiento.length
             + ". Mantenimiento registrado en posición [" + pos + "]. NIT: " + m.getNit();
    }

    /**
     * Busca un mantenimiento por NIT.
     *
     * @param nit NIT del registro a buscar.
     * @return El objeto {@link Mantenimiento} encontrado, o {@code null} si no existe.
     */
    public Mantenimiento leer(String nit) {
        if (nit == null || nit.trim().isEmpty()) {
            System.out.println("Error: el NIT de búsqueda no puede estar vacío.");
            return null;
        }
        for (Mantenimiento m : listaMantenimiento) {
            if (m != null && m.getNit().equals(nit)) return m;
        }
        System.out.println("Aviso: no se encontró registro con NIT " + nit + ".");
        return null;
    }

    /**
     * Reemplaza el mantenimiento cuyo NIT coincida.
     *
     * @param nit NIT del registro a actualizar.
     * @param m   Nuevo objeto con los datos actualizados.
     * @return Mensaje con el resultado de la actualización.
     */
    public String actualizar(String nit, Mantenimiento m) {
        if (nit == null || nit.trim().isEmpty()) return "Error: el NIT no puede estar vacío.";
        if (m == null) return "Error: el objeto de reemplazo no puede ser nulo.";

        for (int i = 0; i < listaMantenimiento.length; i++) {
            if (listaMantenimiento[i] != null && listaMantenimiento[i].getNit().equals(nit)) {
                listaMantenimiento[i] = m;
                return "Actualización exitosa. NIT: " + nit;
            }
        }
        return "Error: no se encontró registro con NIT " + nit + ".";
    }

    /**
     * Elimina el mantenimiento cuyo NIT coincida, liberando la posición del arreglo.
     *
     * @param nit NIT del registro a eliminar.
     * @return Mensaje con el resultado de la eliminación.
     */
    public String eliminar(String nit) {
        if (nit == null || nit.trim().isEmpty()) return "Error: el NIT no puede estar vacío.";

        for (int i = 0; i < listaMantenimiento.length; i++) {
            if (listaMantenimiento[i] != null && listaMantenimiento[i].getNit().equals(nit)) {
                listaMantenimiento[i] = null;
                return "Eliminado con éxito. NIT: " + nit + " | Posición [" + i + "] liberada.";
            }
        }
        return "Error: no se encontró registro con NIT " + nit + ".";
    }

    /**
     * Retorna el arreglo completo de mantenimientos.
     * Usado por {@link ServicioArchivoMantenimiento} para la persistencia.
     *
     * @return Arreglo de {@link Mantenimiento}.
     */
    public Mantenimiento[] getListaMantenimiento() {
        return listaMantenimiento;
    }

    /**
     * Reemplaza el arreglo interno. Usado al restaurar datos desde archivo.
     *
     * @param listaMantenimiento Nuevo arreglo de {@link Mantenimiento}.
     */
    public void setListaMantenimiento(Mantenimiento[] listaMantenimiento) {
        this.listaMantenimiento = listaMantenimiento;
    }
}