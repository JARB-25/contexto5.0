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
                "SAT-001", "Ingenieria Aeroespacial", 4500000.0);


        arregloEmpleados[1] = new Personal(
                "2030405060", "Maria Torres", "Analista de Orbitas",
                "MISION-BETA", "Mid", 1995,
                "Calculo de trayectorias", "Fijo",
                "Salud + ARL", "NIVEL-2", 'F',
                "SAT-002", "Astrofisica", 3800000.0);

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
    }
}
