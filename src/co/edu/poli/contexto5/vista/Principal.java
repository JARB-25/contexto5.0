package co.edu.poli.contexto5.vista;

import co.edu.poli.contexto5.servicios.PersonalException;
import co.edu.poli.contexto5.modelo.Personal;
import co.edu.poli.contexto5.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto5.servicios.OperacionCRUD;
import co.edu.poli.contexto5.servicios.ServicioArchivo;
import co.edu.poli.contexto5.servicios.ValidadorPersonal;

import java.util.Scanner;

/**
 * Clase principal del Sistema de Gestion de Personal.
 *
 * Control de excepciones aplicado:
 *  - NumberFormatException   -> lectura del numero de opcion del menu
 *  - PersonalException       -> validacion de cedula, nombre y cargo
 *  - ClassCastException      -> cast de OperacionCRUD a Implementacion
 *  - NullPointerException    -> acceso a atributos de Personal null
 *  - Exception generica      -> errores inesperados en cada operacion
 */
public class Principal {

    public static void main(String[] args) {

        OperacionCRUD menu = new ImplementacionOperacionCRUD();
        ServicioArchivo servicioArchivo = new ServicioArchivo();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Personal personalConsultado = null;

        do {
            System.out.println("\n+---------------------------------------------------------+");
            System.out.println("|         SISTEMA DE GESTION DE PERSONAL                 |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|  1. CREAR      - Registrar nuevo personal               |");
            System.out.println("|  2. LEER       - Consultar personal por cedula          |");
            System.out.println("|  3. ACTUALIZAR - Modificar personal por cedula          |");
            System.out.println("|  4. ELIMINAR   - Eliminar personal por cedula           |");
            System.out.println("|  5. GUARDAR    - Serializar arreglo en archivo          |");
            System.out.println("|  6. CARGAR     - Deserializar arreglo desde archivo     |");
            System.out.println("|  7. SALIR                                               |");
            System.out.println("+---------------------------------------------------------+");
            System.out.print("  Seleccione una opcion: ");

            // ── Lectura segura del numero de opcion ───────────────────────────
            try {
                // try-catch #1 | NumberFormatException
                // El usuario escribe texto en lugar de un numero (ej. "dos", "?")
                String lineaOpcion = scanner.nextLine().trim();
                if (lineaOpcion.isEmpty()) {
                    System.out.println("  [!] Debe ingresar un numero de opcion.");
                    continue;
                }
                opcion = Integer.parseInt(lineaOpcion);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Opcion invalida: ingrese un numero entero del 1 al 7.");
                continue;
            }

            switch (opcion) {

                // ── CASE 1: CREAR ─────────────────────────────────────────────
                case 1:
                    System.out.println("\n--- CREAR PERSONAL ---");
                    try {
                        System.out.print("  Cedula : ");
                        final String cCedula = scanner.nextLine().trim();
                        ValidadorPersonal.validarCedula(cCedula); // throws PersonalException

                        System.out.print("  Nombre : ");
                        final String cNombre = scanner.nextLine().trim();
                        ValidadorPersonal.validarNombre(cNombre); // throws PersonalException

                        System.out.print("  Cargo  : ");
                        final String cCargo = scanner.nextLine().trim();
                        ValidadorPersonal.validarCargo(cCargo);   // throws PersonalException

                        final String cLabor = cCargo;

                        Personal nuevo = new Personal(
                                cCedula, cNombre, cCargo, "", "",
                                0, "", "", "", "",
                                'M', "", "", 0) {
                            @Override
                            public String realizarLabor() { return cLabor; }
                        };
                        System.out.println("\n  " + menu.crear(nuevo));

                    } catch (PersonalException e) {
                        // try-catch #2 | PersonalException en CREAR
                        // Cedula con letras, nombre con numeros, cargo vacio, etc.
                        System.out.println("  [!] Dato invalido en '" + e.getCampo()
                                + "': " + e.getMessage());
                    } catch (Exception e) {
                        // try-catch #3 | Exception generica en CREAR
                        // Error inesperado al instanciar o registrar el Personal
                        System.out.println("  [!] Error inesperado al crear: " + e.getMessage());
                    }
                    break;

                // ── CASE 2: LEER ──────────────────────────────────────────────
                case 2:
                    System.out.println("\n--- CONSULTAR PERSONAL ---");
                    try {
                        System.out.print("  Ingrese la cedula: ");
                        String cedBuscar = scanner.nextLine().trim();
                        ValidadorPersonal.validarCedula(cedBuscar); // throws PersonalException

                        personalConsultado = menu.leer(cedBuscar);
                        if (personalConsultado != null) {
                            System.out.println("\n  +-----------------------------------------------+");
                            System.out.println("  | RESULTADO DE CONSULTA                         |");
                            System.out.println("  +-----------------------------------------------+");
                            System.out.println("  | Cedula : " + personalConsultado.getCedula());
                            System.out.println("  | Nombre : " + personalConsultado.getNombre());
                            System.out.println("  | Cargo  : " + personalConsultado.getCargo());
                            System.out.println("  +-----------------------------------------------+");
                        } else {
                            System.out.println("  [!] No se encontro personal con cedula: " + cedBuscar);
                        }

                    } catch (PersonalException e) {
                        // try-catch #4 | PersonalException en LEER
                        // Cedula vacia o con caracteres no numericos
                        System.out.println("  [!] Dato invalido en '" + e.getCampo()
                                + "': " + e.getMessage());
                    } catch (NullPointerException e) {
                        // try-catch #5 | NullPointerException en LEER
                        // Acceso a getCedula/getNombre/getCargo sobre objeto null
                        System.out.println("  [!] Error al leer los datos del registro.");
                    }
                    break;

                // ── CASE 3: ACTUALIZAR ────────────────────────────────────────
                case 3:
                    System.out.println("\n--- ACTUALIZAR PERSONAL ---");
                    try {
                        System.out.print("  Cedula a modificar: ");
                        String cedActualizar = scanner.nextLine().trim();
                        ValidadorPersonal.validarCedula(cedActualizar); // throws PersonalException

                        if (menu.leer(cedActualizar) == null) {
                            System.out.println("  [!] No se encontro personal con esa cedula.");
                            break;
                        }

                        System.out.println("  Personal encontrado. Ingrese los nuevos datos:");
                        System.out.print("  Nuevo nombre : ");
                        final String aNombre = scanner.nextLine().trim();
                        ValidadorPersonal.validarNombre(aNombre); // throws PersonalException

                        System.out.print("  Nuevo cargo  : ");
                        final String aCargo = scanner.nextLine().trim();
                        ValidadorPersonal.validarCargo(aCargo);   // throws PersonalException

                        final String aLabor   = aCargo;
                        final String finalCed = cedActualizar;

                        Personal actualizado = new Personal(
                                finalCed, aNombre, aCargo, "", "",
                                0, "", "", "", "",
                                'M', "", "", 0) {
                            @Override
                            public String realizarLabor() { return aLabor; }
                        };
                        System.out.println("\n  " + menu.actualizar(cedActualizar, actualizado));

                    } catch (PersonalException e) {
                        // try-catch #6 | PersonalException en ACTUALIZAR
                        // Nuevo nombre con numeros, cargo invalido, cedula con letras
                        System.out.println("  [!] Dato invalido en '" + e.getCampo()
                                + "': " + e.getMessage());
                    } catch (Exception e) {
                        // try-catch #7 | Exception generica en ACTUALIZAR
                        // Error inesperado al construir o guardar el Personal actualizado
                        System.out.println("  [!] Error inesperado al actualizar: " + e.getMessage());
                    }
                    break;

                // ── CASE 4: ELIMINAR ──────────────────────────────────────────
                case 4:
                    System.out.println("\n--- ELIMINAR PERSONAL ---");
                    try {
                        System.out.print("  Ingrese la cedula a eliminar: ");
                        String cedEliminar = scanner.nextLine().trim();
                        ValidadorPersonal.validarCedula(cedEliminar); // throws PersonalException

                        System.out.println("\n  " + menu.eliminar(cedEliminar));

                    } catch (PersonalException e) {
                        // try-catch #8 | PersonalException en ELIMINAR
                        // Cedula vacia o con letras al intentar eliminar
                        System.out.println("  [!] Dato invalido en '" + e.getCampo()
                                + "': " + e.getMessage());
                    } catch (Exception e) {
                        // try-catch #9 | Exception generica en ELIMINAR
                        // Error inesperado durante la eliminacion
                        System.out.println("  [!] Error inesperado al eliminar: " + e.getMessage());
                    }
                    break;

                // ── CASE 5: GUARDAR (SERIALIZAR) ──────────────────────────────
                case 5:
                    System.out.println("\n--- GUARDAR EN ARCHIVO (SERIALIZAR) ---");
                    try {
                        Personal[] lista = ((ImplementacionOperacionCRUD) menu).getListaPersonal();
                        if (lista == null || contarRegistros(lista) == 0) {
                            System.out.println("  [!] No hay registros en memoria para guardar.");
                            break;
                        }
                        System.out.println("  " + servicioArchivo.serializar(lista));

                    } catch (ClassCastException e) {
                        // try-catch #10 | ClassCastException en GUARDAR
                        // Cast fallido de OperacionCRUD a ImplementacionOperacionCRUD
                        System.out.println("  [!] Error interno al acceder a la lista de personal.");
                    } catch (Exception e) {
                        // try-catch #11 | Exception/IOException en GUARDAR
                        // Error al escribir el archivo personal.dat en disco
                        System.out.println("  [!] Error al guardar el archivo: " + e.getMessage());
                    }
                    break;

                // ── CASE 6: CARGAR (DESERIALIZAR) ─────────────────────────────
                case 6:
                    System.out.println("\n--- CARGAR DESDE ARCHIVO (DESERIALIZAR) ---");
                    try {
                        Personal[] arregloCargado = servicioArchivo.deserializar();
                        if (arregloCargado != null) {
                            ((ImplementacionOperacionCRUD) menu).setListaPersonal(arregloCargado);
                            System.out.println("  Arreglo cargado exitosamente. Registros: "
                                    + contarRegistros(arregloCargado));
                        } else {
                            System.out.println("  No se pudo cargar. Verifique que exista 'personal.dat'.");
                        }

                    } catch (ClassCastException e) {
                        // try-catch #12 | ClassCastException en CARGAR
                        // Tipo incompatible al asignar el arreglo deserializado
                        System.out.println("  [!] Error de tipo al cargar la lista.");
                    } catch (Exception e) {
                        // try-catch #13 | IOException/ClassNotFoundException en CARGAR
                        // Archivo .dat inexistente, corrupto o clase incompatible
                        System.out.println("  [!] Error al cargar el archivo: " + e.getMessage());
                    }
                    break;

                // ── CASE 7: SALIR ─────────────────────────────────────────────
                case 7:
                    System.out.println("\n  Saliendo del sistema. Hasta luego!");
                    break;

                default:
                    System.out.println("  [!] Opcion no valida. Elija entre 1 y 7.");
            }

        } while (opcion != 7);

        scanner.close();
        System.out.println("\n=========================================================");
        System.out.println("  SISTEMA CERRADO                                         ");
        System.out.println("=========================================================");
    }

    /**
     * Cuenta los registros no nulos dentro del arreglo.
     *
     * @param arreglo El arreglo de Personal a recorrer.
     * @return Numero de posiciones con objetos (no null).
     */
    private static int contarRegistros(Personal[] arreglo) {
        if (arreglo == null) return 0;
        int count = 0;
        for (Personal p : arreglo) {
            if (p != null) count++;
        }
        return count;
    }
}