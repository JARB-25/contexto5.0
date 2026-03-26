package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Personal;

/*
 * PUNTO 1 - INTERFAZ OperacionCRUD
 * Define el contrato de las operaciones CRUD sobre objetos de tipo
 * Personal (super super clase / clase de mayor jerarquia).
 * La busqueda, modificacion y eliminacion se realizan por cedula (ID).
 */
public interface OperacionCRUD {

    // Crear: inserta en el primer null del arreglo (con agregacion infinita)
    public String crear(Personal p);

    // Leer: consulta por cedula (ID del objeto)
    public Personal leer(String cedula);

    // Actualizar: modifica el registro que tenga la cedula indicada
    public String actualizar(String cedula, Personal p);

    // Eliminar: borra el registro que tenga la cedula indicada
    public String eliminar(String cedula);
}
