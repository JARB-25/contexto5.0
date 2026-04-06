package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Personal;

/**
 * Implementación concreta de la interfaz {@link OperacionCRUD}.
 * <p>
 * <b>Punto 1:</b> Gestiona un arreglo de tipo {@link Personal}
 * (superclase de mayor jerarquía) con capacidad inicial de 2 posiciones.
 * </p>
 * <p>
 * <b>Punto 2 - Lógica CRUD:</b>
 * <ul>
 *   <li><b>Crear:</b> Inserta en la primera posición {@code null} de izquierda a derecha.</li>
 *   <li><b>Agregación infinita:</b> Si el arreglo está lleno, se duplica su capacidad automáticamente.</li>
 *   <li><b>Leer:</b> Búsqueda por cédula (ID del objeto).</li>
 *   <li><b>Actualizar:</b> Reemplaza el objeto cuya cédula coincida.</li>
 *   <li><b>Eliminar:</b> Pone en {@code null} la posición del objeto eliminado.</li>
 * </ul>
 * Todas las operaciones incluyen validaciones de entrada.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see OperacionCRUD
 * @see Personal
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

    /**
     * Arreglo interno de tipo {@link Personal} con capacidad inicial de 2.
     * <p>
     * <b>Punto 1:</b> Tipo declarado como la superclase de mayor jerarquía
     * ({@link Personal}), lo que permite almacenar cualquier subclase.
     * </p>
     */
    private Personal[] listaPersonal = new Personal[2];

    /**
     * Registra un nuevo objeto {@link Personal} en el sistema.
     * <p>
     * Busca la primera posición {@code null} de izquierda a derecha.
     * Si el arreglo está lleno, aplica <b>agregación infinita</b>:
     * crea un nuevo arreglo de doble capacidad, copia los datos existentes
     * y añade el nuevo objeto.
     * </p>
     * <p>Validaciones aplicadas:</p>
     * <ul>
     *   <li>El objeto no puede ser {@code null}.</li>
     *   <li>La cédula no puede ser vacía ni {@code null}.</li>
     *   <li>No se permiten cédulas duplicadas.</li>
     * </ul>
     *
     * @param p Objeto {@link Personal} a registrar.
     * @return Mensaje con el resultado de la operación y la posición de inserción,
     *         o un mensaje de error si la validación falla.
     */
    @Override
    public String crear(Personal p) {

        if (p == null) {
            return "Error: no se puede registrar un objeto nulo.";
        }

        if (p.getCedula() == null || p.getCedula().trim().isEmpty()) {
            return "Error: la cedula del personal no puede estar vacia.";
        }

        for (Personal existente : listaPersonal) {
            if (existente != null && existente.getCedula().equals(p.getCedula())) {
                return "Error: ya existe un registro con la cedula " + p.getCedula() + ".";
            }
        }

        for (int i = 0; i < listaPersonal.length; i++) {
            if (listaPersonal[i] == null) {
                listaPersonal[i] = p;
                return "Personal registrado con exito en la posicion [" + i + "]. "
                     + "Cedula: " + p.getCedula() + " | Nombre: " + p.getNombre();
            }
        }

        // Agregación infinita: duplicar capacidad
        Personal[] listaNueva = new Personal[listaPersonal.length * 2];
        System.arraycopy(listaPersonal, 0, listaNueva, 0, listaPersonal.length);

        int posicionNueva = listaPersonal.length;
        listaNueva[posicionNueva] = p;
        listaPersonal = listaNueva;

        return "Arreglo expandido a capacidad " + listaPersonal.length + ". "
             + "Personal registrado en posicion [" + posicionNueva + "]. "
             + "Cedula: " + p.getCedula() + " | Nombre: " + p.getNombre();
    }

    /**
     * Busca y retorna el objeto {@link Personal} cuya cédula coincida con la indicada.
     * <p>Validaciones aplicadas:</p>
     * <ul>
     *   <li>La cédula no puede ser vacía ni {@code null}.</li>
     *   <li>Se verifica que existan registros antes de buscar.</li>
     * </ul>
     *
     * @param cedula Cédula del personal a buscar.
     * @return El objeto {@link Personal} encontrado, o {@code null} si no existe
     *         o si ocurre un error de validación.
     */
    @Override
    public Personal leer(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            System.out.println("Error: la cedula de busqueda no puede estar vacia.");
            return null;
        }

        boolean hayRegistros = false;
        for (Personal p : listaPersonal) {
            if (p != null) { hayRegistros = true; break; }
        }
        if (!hayRegistros) {
            System.out.println("Aviso: no hay registros en el sistema.");
            return null;
        }

        for (Personal p : listaPersonal) {
            if (p != null && p.getCedula().equals(cedula)) {
                return p;
            }
        }

        System.out.println("Aviso: no se encontro ningun registro con cedula " + cedula + ".");
        return null;
    }

    /**
     * Reemplaza el objeto {@link Personal} cuya cédula coincida con la indicada.
     * <p>Validaciones aplicadas:</p>
     * <ul>
     *   <li>La cédula de búsqueda no puede ser vacía ni {@code null}.</li>
     *   <li>El objeto de reemplazo no puede ser {@code null}.</li>
     * </ul>
     *
     * @param cedula Cédula del registro a actualizar.
     * @param p      Nuevo objeto {@link Personal} con los datos actualizados.
     * @return Mensaje con el resultado de la actualización, indicando el nombre
     *         anterior y el nuevo, o un mensaje de error si falla.
     */
    @Override
    public String actualizar(String cedula, Personal p) {

        if (cedula == null || cedula.trim().isEmpty()) {
            return "Error: la cedula de busqueda no puede estar vacia.";
        }

        if (p == null) {
            return "Error: el objeto de reemplazo no puede ser nulo.";
        }

        for (int i = 0; i < listaPersonal.length; i++) {
            if (listaPersonal[i] != null && listaPersonal[i].getCedula().equals(cedula)) {
                String nombreAnterior = listaPersonal[i].getNombre();
                listaPersonal[i] = p;
                return "Actualizacion exitosa. Cedula: " + cedula
                     + " | Anterior: " + nombreAnterior
                     + " -> Nuevo: " + p.getNombre();
            }
        }

        return "Error: no se encontro un registro con cedula " + cedula + ".";
    }

    /**
     * Elimina el registro del personal cuya cédula coincida con la indicada,
     * poniendo en {@code null} esa posición del arreglo para que quede disponible.
     * <p>Validaciones aplicadas:</p>
     * <ul>
     *   <li>La cédula no puede ser vacía ni {@code null}.</li>
     * </ul>
     *
     * @param cedula Cédula del personal a eliminar.
     * @return Mensaje indicando la cédula, nombre y posición liberada,
     *         o un mensaje de error si no se encuentra el registro.
     */
    @Override
    public String eliminar(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            return "Error: la cedula no puede estar vacia.";
        }

        for (int i = 0; i < listaPersonal.length; i++) {
            if (listaPersonal[i] != null && listaPersonal[i].getCedula().equals(cedula)) {
                String nombre = listaPersonal[i].getNombre();
                listaPersonal[i] = null;
                return "Eliminado con exito. Cedula: " + cedula
                     + " | Nombre: " + nombre
                     + " | Posicion [" + i + "] liberada.";
            }
        }

        return "Error: no se encontro un registro con cedula " + cedula + ".";
    }

    /**
     * Retorna el arreglo completo de personal almacenado en el sistema.
     * <p>
     * Utilizado principalmente por {@link ServicioArchivo} para la persistencia.
     * </p>
     *
     * @return Arreglo de objetos {@link Personal}.
     */
    public Personal[] getListaPersonal() {
        return listaPersonal;
    }

    /**
     * Reemplaza el arreglo interno de personal con el arreglo proporcionado.
     * <p>
     * Utilizado principalmente por {@link ServicioArchivo} al restaurar
     * datos desde un archivo binario.
     * </p>
     *
     * @param listaPersonal Nuevo arreglo de objetos {@link Personal}.
     */
    public void setListaPersonal(Personal[] listaPersonal) {
        this.listaPersonal = listaPersonal;
    }
}
