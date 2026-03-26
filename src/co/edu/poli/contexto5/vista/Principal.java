package co.edu.poli.contexto5.vista;

import co.edu.poli.contexto5.modelo.Capital;
import co.edu.poli.contexto5.modelo.Documento;
import co.edu.poli.contexto5.modelo.Empleado;
import co.edu.poli.contexto5.modelo.Jefe;
import co.edu.poli.contexto5.modelo.Mantenimiento;
import co.edu.poli.contexto5.modelo.Mision;
import co.edu.poli.contexto5.modelo.Satelite;
import co.edu.poli.contexto5.modelo.SistemaControl;  
import co.edu.poli.contexto5.modelo.Personal;
import co.edu.poli.contexto5.servicios.ServicioPersonal;
import co.edu.poli.contexto5.servicios.OperacionCRUD;
import co.edu.poli.contexto5.servicios.ImplementacionOperacionCRUD;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("       CONTEXTO 5 - SISTEMA DE SATELITES                  ");
        System.out.println("==========================================================");

        // ══════════════════════════════════════════════════════════════
        // PUNTO 1 - ARREGLO DE TIPO SUPERSUPERCLASE (Empleado)
        //           con 5 posiciones y 3 objetos de subclases distintas.
        //           Impresion de SOBREESCRITURA de metodo.
        //
        // La supersuperclase es "Empleado".
        // La subclase directa es "personal" (extends Empleado).
        // El arreglo se declara como Empleado[] pero almacena objetos
        // de subclases -> UPCASTING (polimorfismo de arreglo).
        // Al llamar obtenerInformacion() se ejecuta la version
        // sobreescrita de cada objeto real (ligadura dinamica).
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== PUNTO 1: ARREGLO SUPERSUPERCLASE + OVERRIDE ==");

        Empleado[] arregloEmpleados = new Empleado[5];


        arregloEmpleados[0] = new Personal(
                "1020304050", "Carlos Ruiz", "Ingeniero Satelital",
                "MISION-ALPHA", "Senior", 1990,
                "Revision tecnica de modulos", "Indefinido",
                "Salud + Pension", "NIVEL-3", 'M',
                "SAT-001", "Ingenieria Aeroespacial", 4500000.0) {
            @Override
            public String realizarLabor() {
                return "Inspeccionando y calibrando modulos de orientacion del satelite";
            }
        };


        arregloEmpleados[1] = new Personal(
                "2030405060", "Maria Torres", "Analista de Orbitas",
                "MISION-BETA", "Mid", 1995,
                "Calculo de trayectorias", "Fijo",
                "Salud + ARL", "NIVEL-2", 'F',
                "SAT-002", "Astrofisica", 3800000.0) {
            @Override
            public String realizarLabor() {
                return "Calculando trayectorias y ventanas de lanzamiento orbital";
            }
        };

        // Posicion 2: objeto directo de la supersuperclase "Empleado"
        arregloEmpleados[2] = new Empleado();

        // Posiciones 3 y 4: null (arreglo de 5 posiciones)
        arregloEmpleados[3] = null;
        arregloEmpleados[4] = null;

        System.out.println("\nRecorriendo arreglo Empleado[5] - llamando obtenerInformacion():");
        System.out.println("(Subclase 'personal' ejecuta su @Override; Empleado base usa el original)");
        System.out.println();

        for (int i = 0; i < arregloEmpleados.length; i++) {
            System.out.print("  Posicion [" + i + "] -> ");
            if (arregloEmpleados[i] != null) {
                System.out.println(arregloEmpleados[i].obtenerInformacion());
            } else {
                System.out.println("(vacia / null)");
            }
        }

        // ══════════════════════════════════════════════════════════════
        // PUNTO 2 - DOS METODOS CON POLIMORFISMO (ServicioPersonal)
        //
        //   a) mostrarInformacionEmpleado(Empleado emp)
        //      -> recibe parametro de tipo supersuperclase Empleado.
        //   b) crearEmpleadoEstandar() -> Empleado
        //      -> retorna tipo supersuperclase Empleado.
        // Ambos se invocan desde main.
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== PUNTO 2: POLIMORFISMO (2 METODOS) =============");

        ServicioPersonal servicio = new ServicioPersonal();

        // --- Metodo a): recibe parametro Empleado ---
        System.out.println("\n>>> Metodo a) mostrarInformacionEmpleado(Empleado emp)");
        System.out.println("    Argumento: objeto 'personal' tratado como Empleado:");
        servicio.mostrarInformacionEmpleado(arregloEmpleados[0]);

        System.out.println();
        System.out.println("    Argumento: objeto Empleado base:");
        servicio.mostrarInformacionEmpleado(arregloEmpleados[2]);

        // --- Metodo b): retorna Empleado ---
        System.out.println("\n>>> Metodo b) crearEmpleadoEstandar() -> retorna Empleado");
        Empleado empRetornado = servicio.crearEmpleadoEstandar();
        System.out.println("  Tipo real recibido  : " + empRetornado.getClass().getSimpleName());
        System.out.println("  obtenerInformacion(): " + empRetornado.obtenerInformacion());
        System.out.println("  (retorna Empleado pero internamente es 'personal' -> polimorfismo)");

        // ══════════════════════════════════════════════════════════════
        // PUNTO 3 - ATRIBUTO FINAL, METODO FINAL Y CLASE FINAL
        //
        //  * ATRIBUTO final -> SistemaControl.SISTEMA_ID  (constante)
        //  * METODO   final -> SistemaControl.verificarSistema()
        //  * CLASE    final -> SistemaControl (no se puede heredar)
        //
        // Ver SistemaControl.java para los comentarios detallados.
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== PUNTO 3: final (atributo, metodo, clase) ======");

        SistemaControl sc = new SistemaControl("SC-001", "Activo", "Ing. Lopez");

        System.out.println("\n  Objeto de la clase FINAL SistemaControl:");
        System.out.println("  " + sc.verificarSistema()); // metodo final

        // sc.SISTEMA_ID = "otro"; // <-- ERROR de compilacion: atributo final
        System.out.println("\n  Atributo FINAL SISTEMA_ID = \"" + sc.getSistemaId()
                + "\" -> no puede reasignarse.");
        System.out.println("  Metodo verificarSistema() es 'final' -> no se puede sobreescribir.");
        System.out.println("  Clase SistemaControl es 'final'      -> no se puede heredar.");

        // ══════════════════════════════════════════════════════════════
        // SOBREESCRITURA Y SOBRECARGA (ya existia - sin cambios)
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== SOBREESCRITURA Y SOBRECARGA (existente) =======");

        Personal p1 = (Personal) arregloEmpleados[0];
        Empleado empleadoBase = new Empleado();

        System.out.println("\n>>> SOBREESCRITURA (Override)");
        System.out.println("Padre  - Empleado.obtenerInformacion(): " + empleadoBase.obtenerInformacion());
        System.out.println("Hija   - personal.obtenerInformacion(): " + p1.obtenerInformacion());

        System.out.println("\n>>> SOBRECARGA (Overload)");
        System.out.println("calcularNomina(sueldo)       => $" + p1.calcularNomina(4500000.0));
        System.out.println("calcularNomina(sueldo,bono)  => $" + p1.calcularNomina(4500000.0, 800000.0));

        // ══════════════════════════════════════════════════════════════
        // ATRIBUTO ESTATICO (ya existia - sin cambios)
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== ATRIBUTO ESTATICO (existente) =================");

        Capital cap = new Capital(
                "Colombia", "USA", "GestorA", "ContadorB",
                "SupervC", "PresidenteD", 5000000.0, 200000.0, "FAC-001", "Investigacion");

        Satelite sat1 = new Satelite("SATCOM-1", "S001", "Titanio", "Manual-A",
                "Comunicaciones", "Juan Lopez", "Dpto-TI", "Orbita-Baja",
                "Mediano", "Cohete", 1000000.0, cap);

        System.out.println("\nAntes de modificar -> agenciaEspacial = " + Satelite.getAgenciaEspacial());
        Satelite.setAgenciaEspacial("ESA - Agencia Espacial Europea");
        System.out.println("Despues de modificar (1 cambio afecta a todos):");
        System.out.println("  sat1: " + Satelite.getAgenciaEspacial());
        System.out.println("  sat2: " + Satelite.getAgenciaEspacial());
        System.out.println("  sat3: " + Satelite.getAgenciaEspacial());

        // ══════════════════════════════════════════════════════════════
        // OBJETOS TIPO REGISTRO (ya existia - sin cambios)
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== OBJETOS TIPO REGISTRO (existente) =============");

        Jefe jefe = new Jefe(sat1);
        Mision mision1 = new Mision("M001", "Dr. Lopez", "Bogota", "Alta",
                "Explorar orbita baja", "Revision tecnica completa",
                "Cero fallas en 12 meses", "Mantenimiento preventivo trimestral",
                2020, 2026, jefe);

        Documento doc1 = new Documento("D001", "2024-01-15", "Tecnico", "Preventivo",
                "Ing. Gomez", "Reparacion de modulo de orientacion", "Base-Bogota",
                "Plan-A", "Falla en sensor de orientacion", "Restablecer sensor",
                "Cambio de pieza electronica", "Ing. Director", "Cerrado", mision1);
        Documento doc2 = new Documento("D002", "2024-06-20", "Critico", "Correctivo",
                "Ing. Torres", "Reemplazo de panel solar danado", "Base-Medellin",
                "Plan-B", "Panel solar deteriorado por radiacion", "Reemplazar panel",
                "Instalacion de panel nuevo", "Ing. Director", "En proceso", mision1);
        Documento doc3 = new Documento("D003", "2024-11-05", "Rutinario", "Preventivo",
                "Ing. Ramirez", "Ajuste de antena directiva", "Base-Cali",
                "Plan-C", "Comunicacion intermitente con estacion base",
                "Reestablecer comunicacion", "Ajuste fisico de antena",
                "Ing. Director", "Programado", mision1);

        Mantenimiento registro1 = new Mantenimiento("900123456-1", "2024-01-15",
                "Dr. Martinez", "Ing. Gomez", "Carlos Ruiz",
                "Soldadora de precision, Multimetro digital",
                "Falla critica en sensor de orientacion del satelite SATCOM-1",
                "Reemplazar sensor y recalibrar sistema de orientacion",
                15000000.0, new Documento[]{doc1});
        Mantenimiento registro2 = new Mantenimiento("900123456-2", "2024-06-20",
                "Dr. Martinez", "Ing. Torres", "Maria Perez",
                "Taladro orbital, Pinza de presion, Kit de paneles",
                "Panel solar deteriorado por exceso de radiacion cosmica",
                "Instalar panel solar de repuesto modelo SP-400",
                22000000.0, new Documento[]{doc2});
        Mantenimiento registro3 = new Mantenimiento("900123456-3", "2024-11-05",
                "Dr. Martinez", "Ing. Lopez", "Pedro Suarez",
                "Osciloscopio, Cables coaxiales especiales, Analizador de espectro",
                "Comunicacion intermitente entre SATCOM-3 y estacion terrestre",
                "Ajuste fisico y electronico de antena directiva",
                8500000.0, new Documento[]{doc1, doc2, doc3});

        System.out.println(registro1);
        System.out.println(registro2);
        System.out.println(registro3);

        // ══════════════════════════════════════════════════════════════
        // PUNTO 1, 2 y 3 - OPERACIONES CRUD
        //
        // Se instancia ImplementacionOperacionCRUD a traves de la interfaz
        // OperacionCRUD (buena practica: programar hacia la interfaz).
        //
        // Como Personal es ahora ABSTRACTA, se crean instancias usando
        // clases anonimas que implementan el metodo abstracto realizarLabor().
        // Esto demuestra polimorfismo: el arreglo es de tipo Personal pero
        // almacena distintas "versiones" con comportamiento propio.
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n========== PUNTOS 1-2-3: OPERACIONES CRUD ===============");

        OperacionCRUD servicioCRUD = new ImplementacionOperacionCRUD();

        // --- Crear 3 objetos (el 3ro fuerza el redimensionamiento del arreglo) ---
        Personal pCRUD1 = new Personal(
                "1010101010", "Ana Restrepo", "Tecnico Satelital",
                "MISION-ALPHA", "Senior", 1990,
                "Reparacion de modulos de orientacion", "Indefinido",
                "Salud + Pension", "NIVEL-3", 'F',
                "CRUD-001", "Ingenieria Aeroespacial", 4500000.0) {
            @Override
            public String realizarLabor() {
                return "Realizando calibracion de sensores del satelite SATCOM-1";
            }
        };

        Personal pCRUD2 = new Personal(
                "2020202020", "Luis Mendoza", "Ingeniero de Orbitas",
                "MISION-BETA", "Mid", 1993,
                "Calculo de trayectorias y ventanas de lanzamiento", "Fijo",
                "Salud + ARL", "NIVEL-2", 'M',
                "CRUD-002", "Astrofisica", 3800000.0) {
            @Override
            public String realizarLabor() {
                return "Monitoreando la orbita geoestacionaria del satelite SATCOM-2";
            }
        };

        Personal pCRUD3 = new Personal(
                "3030303030", "Sofia Vargas", "Supervisora de Mision",
                "MISION-GAMMA", "Junior", 1998,
                "Coordinacion de equipos de mantenimiento", "Termino fijo",
                "Salud", "NIVEL-1", 'F',
                "CRUD-003", "Administracion Aeroespacial", 3200000.0) {
            @Override
            public String realizarLabor() {
                return "Gestionando recursos humanos para mantenimiento preventivo";
            }
        };

        // ── C: CREAR ──────────────────────────────────────────────────
        System.out.println("\n--- C (CREAR) ---");
        System.out.println(servicioCRUD.crear(pCRUD1)); // posicion [0]
        System.out.println(servicioCRUD.crear(pCRUD2)); // posicion [1]
        System.out.println(servicioCRUD.crear(pCRUD3)); // arreglo lleno -> se duplica
        System.out.println("\n  >> Validacion - objeto nulo:");
        System.out.println(servicioCRUD.crear(null));
        System.out.println("  >> Validacion - cedula duplicada:");
        System.out.println(servicioCRUD.crear(pCRUD1));

        // ── R: LEER ───────────────────────────────────────────────────
        System.out.println("\n--- R (LEER) ---");
        Personal personalConsultado = servicioCRUD.leer("2020202020");
        if (personalConsultado != null) {
        System.out.println("Encontrado -> " + personalConsultado);
            System.out.println("Labor      -> " + personalConsultado.realizarLabor());
        }
        System.out.println("  >> Validacion - cedula inexistente:");
        servicioCRUD.leer("9999999999");

        // ── U: ACTUALIZAR ─────────────────────────────────────────────
        System.out.println("\n--- U (ACTUALIZAR) ---");
        Personal pActualizado = new Personal(
                "2020202020", "Luis Mendoza", "Ingeniero Senior de Orbitas",
                "MISION-BETA", "Senior", 1993,
                "Calculo avanzado de trayectorias", "Indefinido",
                "Salud + ARL + Pension", "NIVEL-3", 'M',
                "CRUD-002", "Astrofisica Avanzada", 5500000.0) {
            @Override
            public String realizarLabor() {
                return "Liderando el equipo de calculo orbital para SATCOM-2 y SATCOM-3";
            }
        };
        System.out.println(servicioCRUD.actualizar("2020202020", pActualizado));
        System.out.println("  >> Validacion - ID inexistente:");
        System.out.println(servicioCRUD.actualizar("8888888888", pActualizado));
        System.out.println("  >> Validacion - objeto nulo:");
        System.out.println(servicioCRUD.actualizar("2020202020", null));

        // ── D: ELIMINAR ───────────────────────────────────────────────
        System.out.println("\n--- D (ELIMINAR) ---");
        System.out.println(servicioCRUD.eliminar("1010101010"));
        System.out.println("  >> Validacion - cedula inexistente:");
        System.out.println(servicioCRUD.eliminar("1010101010"));

        // ── Verificacion final: crear tras eliminar (debe ocupar posicion liberada) ──
        System.out.println("\n--- CREAR TRAS ELIMINAR (debe ocupar el primer null) ---");
        Personal pNuevo = new Personal(
                "4040404040", "Jorge Castillo", "Operador de Control",
                "MISION-DELTA", "Junior", 2000,
                "Monitoreo de sistemas en tiempo real", "Termino fijo",
                "Salud", "NIVEL-1", 'M',
                "CRUD-004", "Electronica", 2800000.0) {
            @Override
            public String realizarLabor() {
                return "Operando panel de control de la estacion terrestre";
            }
        };
        System.out.println(servicioCRUD.crear(pNuevo));

        System.out.println("\n=========================================================");
        System.out.println("  FIN DE PRUEBAS AUTOMATICAS                             ");
        System.out.println("=========================================================");

        // ══════════════════════════════════════════════════════════════
        // MENU INTERACTIVO CRUD
        // Permite al usuario operar el CRUD ingresando datos por consola.
        // Se usa una nueva instancia limpia del servicio para mayor claridad.
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n=========================================================");
        System.out.println("       MENU INTERACTIVO - GESTION DE PERSONAL            ");
        System.out.println("=========================================================");

        OperacionCRUD menu = new ImplementacionOperacionCRUD();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n+---------------------------------------------------------+");
            System.out.println("|         SISTEMA DE GESTION DE PERSONAL                 |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|  1. CREAR   - Registrar nuevo personal                 |");
            System.out.println("|  2. LEER    - Consultar personal por cedula             |");
            System.out.println("|  3. ACTUALIZAR - Modificar personal por cedula          |");
            System.out.println("|  4. ELIMINAR   - Eliminar personal por cedula           |");
            System.out.println("|  5. SALIR                                               |");
            System.out.println("+---------------------------------------------------------+");
            System.out.print("  Seleccione una opcion: ");

            // Validacion de entrada numerica
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            } else {
                System.out.println("  [!] Ingrese un numero valido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {

                case 1: // ── CREAR ────────────────────────────────────────────
                    System.out.println("\n--- CREAR PERSONAL ---");
                    System.out.print("  Cedula       : "); final String cCedula = scanner.nextLine().trim();
                    System.out.print("  Nombre       : "); final String cNombre = scanner.nextLine().trim();
                    System.out.print("  Cargo        : "); final String cCargo = scanner.nextLine().trim();
                    System.out.print("  Mision       : "); final String cMision = scanner.nextLine().trim();
                    System.out.print("  Nivel prof.  : "); final String cNivel = scanner.nextLine().trim();
                    System.out.print("  Anio nacim.  : ");
                    int cAnio = 0;
                    try { cAnio = Integer.parseInt(scanner.nextLine().trim()); }
                    catch (NumberFormatException e) { System.out.println("  [!] Anio invalido, se usara 2000."); cAnio = 2000; }
                    System.out.print("  Responsab.   : "); final String cResp = scanner.nextLine().trim();
                    System.out.print("  Tipo contrato: "); final String cContrato = scanner.nextLine().trim();
                    System.out.print("  Beneficios   : "); final String cBeneficios = scanner.nextLine().trim();
                    System.out.print("  Autorizacion : "); final String cAutor = scanner.nextLine().trim();
                    System.out.print("  Sexo (M/F)   : ");
                    String sexoStr = scanner.nextLine().trim();
                    final char cSexo = (sexoStr.length() > 0) ? Character.toUpperCase(sexoStr.charAt(0)) : 'M';
                    System.out.print("  Cod. barras  : "); final String cCodigo = scanner.nextLine().trim();
                    System.out.print("  Campo prof.  : "); final String cCampo = scanner.nextLine().trim();
                    System.out.print("  Sueldo       : ");
                    double cSueldo = 0;
                    try { cSueldo = Double.parseDouble(scanner.nextLine().trim()); }
                    catch (NumberFormatException e) { System.out.println("  [!] Sueldo invalido, se usara 0."); }
                    System.out.print("  Labor        : "); final String cLabor = scanner.nextLine().trim();
                    final int finalAnio = cAnio;
                    final double finalSueldo = cSueldo;

                    Personal nuevo = new Personal(
                            cCedula, cNombre, cCargo, cMision, cNivel,
                            finalAnio, cResp, cContrato, cBeneficios, cAutor,
                            cSexo, cCodigo, cCampo, finalSueldo) {
                        @Override
                        public String realizarLabor() { return cLabor; }
                    };
                    System.out.println("\n  " + menu.crear(nuevo));
                    break;

                case 2: // ── LEER ─────────────────────────────────────────────
                    System.out.println("\n--- CONSULTAR PERSONAL ---");
                    System.out.print("  Ingrese la cedula: ");
                    String cedBuscar = scanner.nextLine().trim();
                    personalConsultado = menu.leer(cedBuscar);
                    if (personalConsultado != null) {
                        System.out.println("\n  +-----------------------------------------------+");
                        System.out.println("  | RESULTADO DE CONSULTA                         |");
                        System.out.println("  +-----------------------------------------------+");
                        System.out.println("  | Cedula   : " + personalConsultado.getCedula());
                        System.out.println("  | Nombre   : " + personalConsultado.getNombre());
                        System.out.println("  | Cargo    : " + personalConsultado.getCargo());
                        System.out.println("  | Mision   : " + personalConsultado.getMisionasignada());
                        System.out.println("  | Nivel    : " + personalConsultado.getNivelprofesional());
                        System.out.println("  | Sueldo   : $" + personalConsultado.getSueldo());
                        System.out.println("  | Labor    : " + personalConsultado.realizarLabor());
                        System.out.println("  +-----------------------------------------------+");
                    }
                    break;

                case 3: // ── ACTUALIZAR ───────────────────────────────────────
                    System.out.println("\n--- ACTUALIZAR PERSONAL ---");
                    System.out.print("  Cedula a modificar: ");
                    String cedActualizar = scanner.nextLine().trim();

                    // Verificar que exista antes de pedir datos
                    if (menu.leer(cedActualizar) == null) {
                        System.out.println("  [!] No se encontro personal con esa cedula.");
                        break;
                    }
                    System.out.println("  Personal encontrado. Ingrese los nuevos datos:");
                    System.out.print("  Nuevo nombre       : "); final String aNombre = scanner.nextLine().trim();
                    System.out.print("  Nuevo cargo        : "); final String aCargo = scanner.nextLine().trim();
                    System.out.print("  Nueva mision       : "); final String aMision = scanner.nextLine().trim();
                    System.out.print("  Nuevo nivel prof.  : "); final String aNivel = scanner.nextLine().trim();
                    System.out.print("  Nuevo tipo contrato: "); final String aContrato = scanner.nextLine().trim();
                    System.out.print("  Nuevo sueldo       : ");
                    double aSueldo = 0;
                    try { aSueldo = Double.parseDouble(scanner.nextLine().trim()); }
                    catch (NumberFormatException e) { System.out.println("  [!] Sueldo invalido, se usara 0."); }
                    System.out.print("  Nueva labor        : "); final String aLabor = scanner.nextLine().trim();
                    final double finalASueldo = aSueldo;
                    final String finalCed = cedActualizar;

                    Personal actualizado = new Personal(
                            finalCed, aNombre, aCargo, aMision, aNivel,
                            0, "", aContrato, "", "", 'M', "", "", finalASueldo) {
                        @Override
                        public String realizarLabor() { return aLabor; }
                    };
                    System.out.println("\n  " + menu.actualizar(cedActualizar, actualizado));
                    break;

                case 4: // ── ELIMINAR ─────────────────────────────────────────
                    System.out.println("\n--- ELIMINAR PERSONAL ---");
                    System.out.print("  Ingrese la cedula a eliminar: ");
                    String cedEliminar = scanner.nextLine().trim();
                    System.out.println("\n  " + menu.eliminar(cedEliminar));
                    break;

                case 5:
                    System.out.println("\n  Saliendo del sistema. Hasta luego!");
                    break;

                default:
                    System.out.println("  [!] Opcion no valida. Elija entre 1 y 5.");
            }

        } while (opcion != 5);

        scanner.close();
        System.out.println("\n=========================================================");
        System.out.println("  SISTEMA CERRADO                                         ");
        System.out.println("=========================================================");
    }
}
