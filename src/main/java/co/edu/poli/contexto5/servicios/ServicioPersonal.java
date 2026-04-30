package co.edu.poli.contexto5.servicios;

import co.edu.poli.contexto5.modelo.Empleado;
import co.edu.poli.contexto5.modelo.Personal;

/**
 * Servicio que gestiona operaciones sobre el personal usando polimorfismo.
 * <p>
 * <b>Punto 2 - Polimorfismo:</b> La superclase {@link Empleado} se usa como
 * tipo de referencia tanto en parámetros como en retorno, permitiendo trabajar
 * con cualquier objeto que sea {@link Empleado} o una subclase suya.
 * Esto habilita la ligadura dinámica: el método real ejecutado en tiempo de
 * ejecución depende del tipo concreto del objeto, no del tipo declarado.
 * </p>
 *
 * @author Poliedro
 * @version 1.0
 * @see Empleado
 * @see Personal
 */
public class ServicioPersonal {

    /**
     * Muestra la información de un empleado usando polimorfismo de parámetro.
     * <p>
     * <b>Punto 2 - Polimorfismo de parámetro:</b> Recibe un objeto de tipo
     * {@link Empleado} (superclase). Puede recibir un {@code Empleado},
     * un {@code Personal}, o cualquier otra subclase futura.
     * Imprime la información usando el método sobreescrito de cada objeto
     * (ligadura dinámica): si el objeto real es {@code Personal}, se invoca
     * su versión de {@code obtenerInformacion()}.
     * </p>
     *
     * @param emp Objeto de tipo {@link Empleado} o cualquier subclase.
     */
    public void mostrarInformacionEmpleado(Empleado emp) {
        System.out.println("  [Polimorfismo - parametro Empleado]");
        System.out.println("  Tipo real del objeto : " + emp.getClass().getSimpleName());
        System.out.println("  obtenerInformacion() : " + emp.obtenerInformacion());
    }

    /**
     * Crea y retorna un empleado estándar usando polimorfismo de retorno.
     * <p>
     * <b>Punto 2 - Polimorfismo de retorno:</b> El tipo de retorno declarado
     * es {@link Empleado} (superclase), pero internamente se crea un objeto
     * {@link Personal} (subclase) mediante una clase anónima que implementa
     * el método abstracto {@code realizarLabor()}. Quien recibe el resultado
     * solo conoce la interfaz de {@code Empleado}.
     * </p>
     *
     * @return Un objeto {@link Empleado} que internamente es una instancia
     *         anónima de {@link Personal} con valores predeterminados.
     */
    public Empleado crearEmpleadoEstandar() {
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
            /**
             * Implementación de la labor estándar del empleado creado
             * mediante clase anónima.
             *
             * @return Descripción de la labor estándar de mantenimiento.
             */
            @Override
            public String realizarLabor() {
                return "Ejecutando tareas estandar de mantenimiento de satelites";
            }
        };
        // Se retorna como Empleado (superclase) -> polimorfismo de retorno
        return nuevoPersonal;
    }
}
