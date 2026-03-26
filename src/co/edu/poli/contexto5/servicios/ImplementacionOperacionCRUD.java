package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Personal;

/*
 * PUNTO 1 - CLASE ImplementacionOperacionCRUD
 * Implementa la interfaz OperacionCRUD.
 * Gestiona un arreglo de tamaño 2 de tipo Personal (super super clase).
 *
 * PUNTO 2 - LOGICA CRUD con:
 *   - Insercion en el primer null de izquierda a derecha.
 *   - Agregacion infinita: el arreglo se duplica automaticamente cuando se llena.
 *   - Consulta, modificacion y eliminacion por cedula (ID del objeto).
 *   - Validaciones en cada operacion.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

    // PUNTO 1: Arreglo inicial de tamaño 2 de tipo super super clase (Personal)
    private Personal[] listaPersonal = new Personal[2];

    // ──────────────────────────────────────────────────────────────────────────
    // CREAR
    // Inserta en el primer null de izquierda a derecha.
    // Si el arreglo esta lleno, lo duplica (agregacion infinita).
    // ──────────────────────────────────────────────────────────────────────────
    @Override
    public String crear(Personal p) {

        // Validacion: el objeto no puede ser null
        if (p == null) {
            return "Error: no se puede registrar un objeto nulo.";
        }

        // Validacion: cedula no puede ser null ni vacia
        if (p.getCedula() == null || p.getCedula().trim().isEmpty()) {
            return "Error: la cedula del personal no puede estar vacia.";
        }

        // Validacion: no permitir cedulas duplicadas
        for (Personal existente : listaPersonal) {
            if (existente != null && existente.getCedula().equals(p.getCedula())) {
                return "Error: ya existe un registro con la cedula " + p.getCedula() + ".";
            }
        }

        // Buscar el primer null de izquierda a derecha
        for (int i = 0; i < listaPersonal.length; i++) {
            if (listaPersonal[i] == null) {
                listaPersonal[i] = p;
                return "Personal registrado con exito en la posicion [" + i + "]. "
                     + "Cedula: " + p.getCedula() + " | Nombre: " + p.getNombre();
            }
        }

        // Arreglo lleno: AGREGACION INFINITA (duplicar capacidad)
        Personal[] listaNueva = new Personal[listaPersonal.length * 2];
        System.arraycopy(listaPersonal, 0, listaNueva, 0, listaPersonal.length);

        int posicionNueva = listaPersonal.length; // primera posicion libre del nuevo arreglo
        listaNueva[posicionNueva] = p;
        listaPersonal = listaNueva;

        return "Arreglo expandido a capacidad " + listaPersonal.length + ". "
             + "Personal registrado en posicion [" + posicionNueva + "]. "
             + "Cedula: " + p.getCedula() + " | Nombre: " + p.getNombre();
    }

    // ──────────────────────────────────────────────────────────────────────────
    // LEER
    // Busca por cedula (ID). Retorna el objeto o null si no existe.
    // ──────────────────────────────────────────────────────────────────────────
    @Override
    public Personal leer(String cedula) {

        // Validacion: cedula no puede ser null ni vacia
        if (cedula == null || cedula.trim().isEmpty()) {
            System.out.println("Error: la cedula de busqueda no puede estar vacia.");
            return null;
        }

        // Validacion: arreglo vacio
        boolean hayRegistros = false;
        for (Personal p : listaPersonal) {
            if (p != null) { hayRegistros = true; break; }
        }
        if (!hayRegistros) {
            System.out.println("Aviso: no hay registros en el sistema.");
            return null;
        }

        // Buscar por cedula
        for (Personal p : listaPersonal) {
            if (p != null && p.getCedula().equals(cedula)) {
                return p;
            }
        }

        System.out.println("Aviso: no se encontro ningun registro con cedula " + cedula + ".");
        return null;
    }

    // ──────────────────────────────────────────────────────────────────────────
    // ACTUALIZAR
    // Reemplaza el objeto cuya cedula coincida con la indicada.
    // ──────────────────────────────────────────────────────────────────────────
    @Override
    public String actualizar(String cedula, Personal p) {

        // Validacion: cedula de busqueda no puede ser null ni vacia
        if (cedula == null || cedula.trim().isEmpty()) {
            return "Error: la cedula de busqueda no puede estar vacia.";
        }

        // Validacion: el nuevo objeto no puede ser null
        if (p == null) {
            return "Error: el objeto de reemplazo no puede ser nulo.";
        }

        // Buscar y reemplazar
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

    // ──────────────────────────────────────────────────────────────────────────
    // ELIMINAR
    // Pone en null la posicion del objeto cuya cedula coincida.
    // Ese espacio quedara disponible para futuros creates.
    // ──────────────────────────────────────────────────────────────────────────
    @Override
    public String eliminar(String cedula) {

        // Validacion: cedula no puede ser null ni vacia
        if (cedula == null || cedula.trim().isEmpty()) {
            return "Error: la cedula no puede estar vacia.";
        }

        // Buscar y eliminar
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
}
