package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Empleado;
import co.edu.poli.contexto5.modelo.Personal;

/*
 * ServicioPersonal - clase de servicios que implementa POLIMORFISMO (Punto 2).
 *
 * POLIMORFISMO: la supersuperclase "Empleado" se usa como tipo de referencia
 * tanto en parametros como en retorno, permitiendo trabajar con cualquier
 * objeto que sea Empleado o subclase suya (personal, etc.).
 */
public class ServicioPersonal {

    /*
     * PUNTO 2 - METODO POLIMORFISMO: recibe un parametro de tipo Empleado
     * (supersuperclase). Puede recibir un objeto Empleado, personal, o
     * cualquier otra subclase futura. Imprime su informacion usando
     * el metodo sobreescrito de cada objeto (ligadura dinamica).
     */
    public void mostrarInformacionEmpleado(Empleado emp) {
        System.out.println("  [Polimorfismo - parametro Empleado]");
        System.out.println("  Tipo real del objeto : " + emp.getClass().getSimpleName());
        System.out.println("  obtenerInformacion() : " + emp.obtenerInformacion());
    }

    /*
     * PUNTO 2 - METODO POLIMORFISMO: retorna tipo Empleado (supersuperclase).
     * Internamente crea un objeto "personal" (subclase), pero lo devuelve
     * como Empleado. Quien recibe el resultado solo conoce la interfaz
     * de Empleado -> polimorfismo de retorno.
     */
    public Empleado crearEmpleadoEstandar() {
        // Personal es abstracta: se usa clase anonima que implementa realizarLabor()
        Personal nuevoPersonal = new Personal(
                "9999999999",
                "Empleado Estandar",
                "Tecnico de Satelites",
                "MISION-DEFAULT",
                "Junior",
                2000,
                "Mantenimiento basico",
                "Temporal",
                "Salud",
                "NIVEL-1",
                'M',
                "STD-000",
                "Ingenieria",
                2000000.0
        ) {
            @Override
            public String realizarLabor() {
                return "Ejecutando tareas estandar de mantenimiento de satelites";
            }
        };
        // Se retorna como Empleado (supersuperclase) -> polimorfismo
        return nuevoPersonal;
    }
}
