package co.edu.poli.contexto5.vista;

import co.edu.poli.contexto5.modelo.Personal;
import co.edu.poli.contexto5.servicios.OperacionCRUD;
import co.edu.poli.contexto5.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto5.servicios.ServicioArchivo;
import java.util.Scanner;

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

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("  [!] Ingrese un numero valido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {

                case 1: // ── CREAR ─────────────────────────────────────────────
                    System.out.println("\n--- CREAR PERSONAL ---");
                    System.out.print("  Cedula : "); final String cCedula = scanner.nextLine().trim();
                    System.out.print("  Nombre : "); final String cNombre = scanner.nextLine().trim();
                    System.out.print("  Cargo  : "); final String cCargo = scanner.nextLine().trim();
                    final String cLabor = cCargo;

                    Personal nuevo = new Personal(
                            cCedula, cNombre, cCargo, "", "",
                            0, "", "", "", "",
                            'M', "", "", 0) {
                        @Override
                        public String realizarLabor() { return cLabor; }
                    };
                    System.out.println("\n  " + menu.crear(nuevo));
                    break;

                case 2: // ── LEER ──────────────────────────────────────────────
                    System.out.println("\n--- CONSULTAR PERSONAL ---");
                    System.out.print("  Ingrese la cedula: ");
                    String cedBuscar = scanner.nextLine().trim();
                    personalConsultado = menu.leer(cedBuscar);
                    if (personalConsultado != null) {
                        System.out.println("\n  +-----------------------------------------------+");
                        System.out.println("  | RESULTADO DE CONSULTA                         |");
                        System.out.println("  +-----------------------------------------------+");
                        System.out.println("  | Cedula : " + personalConsultado.getCedula());
                        System.out.println("  | Nombre : " + personalConsultado.getNombre());
                        System.out.println("  | Cargo  : " + personalConsultado.getCargo());
                        System.out.println("  +-----------------------------------------------+");
                    }
                    break;

                case 3: // ── ACTUALIZAR ────────────────────────────────────────
                    System.out.println("\n--- ACTUALIZAR PERSONAL ---");
                    System.out.print("  Cedula a modificar: ");
                    String cedActualizar = scanner.nextLine().trim();

                    if (menu.leer(cedActualizar) == null) {
                        System.out.println("  [!] No se encontro personal con esa cedula.");
                        break;
                    }
                    System.out.println("  Personal encontrado. Ingrese los nuevos datos:");
                    System.out.print("  Nuevo nombre : "); final String aNombre = scanner.nextLine().trim();
                    System.out.print("  Nuevo cargo  : "); final String aCargo = scanner.nextLine().trim();
                    final String aLabor = aCargo;
                    final String finalCed = cedActualizar;

                    Personal actualizado = new Personal(
                            finalCed, aNombre, aCargo, "", "",
                            0, "", "", "", "",
                            'M', "", "", 0) {
                        @Override
                        public String realizarLabor() { return aLabor; }
                    };
                    System.out.println("\n  " + menu.actualizar(cedActualizar, actualizado));
                    break;

                case 4: // ── ELIMINAR ──────────────────────────────────────────
                    System.out.println("\n--- ELIMINAR PERSONAL ---");
                    System.out.print("  Ingrese la cedula a eliminar: ");
                    String cedEliminar = scanner.nextLine().trim();
                    System.out.println("\n  " + menu.eliminar(cedEliminar));
                    break;

                case 5: // ── GUARDAR (SERIALIZAR) ──────────────────────────────
                    System.out.println("\n--- GUARDAR EN ARCHIVO (SERIALIZAR) ---");
                    System.out.println("  " + servicioArchivo.serializar(
                            ((ImplementacionOperacionCRUD) menu).getListaPersonal()));
                    break;

                case 6: // ── CARGAR (DESERIALIZAR) ─────────────────────────────
                    System.out.println("\n--- CARGAR DESDE ARCHIVO (DESERIALIZAR) ---");
                    Personal[] arregloCargado = servicioArchivo.deserializar();
                    if (arregloCargado != null) {
                        ((ImplementacionOperacionCRUD) menu).setListaPersonal(arregloCargado);
                        System.out.println("  Arreglo cargado exitosamente. "
                                + "Registros en memoria: " + contarRegistros(arregloCargado));
                    } else {
                        System.out.println("  No se pudo cargar el archivo. "
                                + "Verifique que exista 'personal.dat'.");
                    }
                    break;

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
        int count = 0;
        for (Personal p : arreglo) {
            if (p != null) count++;
        }
        return count;
    }
}
