package co.edu.poli.contexto5.controller;

import co.edu.poli.contexto5.modelo.Capital;
import co.edu.poli.contexto5.modelo.Mantenimiento;
import co.edu.poli.contexto5.modelo.Personal;
import co.edu.poli.contexto5.modelo.Satelite;
import co.edu.poli.contexto5.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto5.servicios.ServicioArchivo;
import co.edu.poli.contexto5.servicios.ServicioArchivoMantenimiento;
import co.edu.poli.contexto5.servicios.ServicioMantenimiento;
import co.edu.poli.contexto5.modelo.TecnicoSatelite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Controlador principal de la interfaz SatControl.
 * Gestiona CRUD de Mantenimiento, CRUD de Personal y vista de Satélites precargados.
 */
public class PrimaryController {

    // ══════════════════════════════════════════════════
    // SERVICIOS
    // ══════════════════════════════════════════════════
    private final ServicioMantenimiento servicioMant = new ServicioMantenimiento();
    private final ServicioArchivoMantenimiento archivoMant = new ServicioArchivoMantenimiento();
    private final ImplementacionOperacionCRUD servicioPersonal = new ImplementacionOperacionCRUD();
    private final ServicioArchivo archivoPersonal = new ServicioArchivo();

    // ══════════════════════════════════════════════════
    // TABLA MANTENIMIENTO
    // ══════════════════════════════════════════════════
    @FXML private TableView<Mantenimiento> tablaMant;
    @FXML private TableColumn<Mantenimiento, String> colMantNit;
    @FXML private TableColumn<Mantenimiento, String> colMantFecha;
    @FXML private TableColumn<Mantenimiento, String> colMantGerente;
    @FXML private TableColumn<Mantenimiento, String> colMantSupervisor;
    @FXML private TableColumn<Mantenimiento, String> colMantSatelite;
    @FXML private TableColumn<Mantenimiento, String> colMantHerramientas;
    @FXML private TableColumn<Mantenimiento, String> colMantJustificacion;
    @FXML private TableColumn<Mantenimiento, String> colMantPropuesta;
    @FXML private TableColumn<Mantenimiento, Double> colMantCapital;

    // Panel y campos CRUD Mantenimiento
    @FXML private VBox panelMant;
    @FXML private Label lblTituloMant;
    @FXML private TextField tfMantNit;
    @FXML private HBox rowsMant;
    @FXML private TextField tfMantFecha;
    @FXML private TextField tfMantGerente;
    @FXML private TextField tfMantSupervisor;
    @FXML private TextField tfMantHerramientas;
    @FXML private TextField tfMantJustificacion;
    @FXML private TextField tfMantPropuesta;
    @FXML private TextField tfMantCapital;
    @FXML private ComboBox<String> cbMantSatelite;
    @FXML private Button btnAccionMant;
    @FXML private Label lblResultMant;

    // ══════════════════════════════════════════════════
    // TABLA PERSONAL
    // ══════════════════════════════════════════════════
    @FXML private TableView<Personal> tablaPersonal;
    @FXML private TableColumn<Personal, String> colPerCedula;
    @FXML private TableColumn<Personal, String> colPerNombre;
    @FXML private TableColumn<Personal, String> colPerCargo;
    @FXML private TableColumn<Personal, String> colPerMision;
    @FXML private TableColumn<Personal, String> colPerNivel;
    @FXML private TableColumn<Personal, String> colPerContrato;
    @FXML private TableColumn<Personal, Double> colPerSueldo;

    // Panel y campos CRUD Personal
    @FXML private VBox panelPer;
    @FXML private Label lblTituloPer;
    @FXML private TextField tfPerCedula;
    @FXML private HBox rowsPer;
    @FXML private TextField tfPerNombre;
    @FXML private TextField tfPerCargo;
    @FXML private TextField tfPerMision;
    @FXML private TextField tfPerNivel;
    @FXML private TextField tfPerContrato;
    @FXML private TextField tfPerSueldo;
    @FXML private TextField tfPerAnio;
    @FXML private TextField tfPerSexo;
    @FXML private TextField tfPerResponsabilidades;
    @FXML private TextField tfPerBeneficios;
    @FXML private TextField tfPerAutorizaciones;
    @FXML private TextField tfPerCodigoBarras;
    @FXML private TextField tfPerCampo;
    @FXML private Button btnAccionPer;
    @FXML private Label lblResultPer;

    // ══════════════════════════════════════════════════
    // TABLA SATÉLITES
    // ══════════════════════════════════════════════════
    @FXML private TableView<Satelite> tablaSat;
    @FXML private TableColumn<Satelite, String> colSatId;
    @FXML private TableColumn<Satelite, String> colSatNombre;
    @FXML private TableColumn<Satelite, String> colSatFuncion;
    @FXML private TableColumn<Satelite, String> colSatEncargado;
    @FXML private TableColumn<Satelite, String> colSatDpto;
    @FXML private TableColumn<Satelite, String> colSatLoc;
    @FXML private TableColumn<Satelite, Double> colSatCapital;
    @FXML private Label lblTotalSatelites;

    // ══════════════════════════════════════════════════
    // ESTADO DEL PANEL (qué acción se está haciendo)
    // ══════════════════════════════════════════════════
    private String modoPanelMant = "crear";   // crear | consultar | actualizar | eliminar
    private String modoPanelPer  = "crear";

    // ══════════════════════════════════════════════════
    // DATOS PRECARGADOS
    // ══════════════════════════════════════════════════
    private final ObservableList<Satelite> satelitesPrecargados = FXCollections.observableArrayList();

    // ══════════════════════════════════════════════════
    // INITIALIZE
    // ══════════════════════════════════════════════════
    @FXML
    public void initialize() {
        configurarTablaMantenimiento();
        configurarTablaPersonal();
        configurarTablaSatelites();
        cargarSatelitesPrecargados();
        cargarDatosDesdeArchivo();

        // Paneles ocultos al inicio
        panelMant.setVisible(false);
        panelMant.setManaged(false);
        panelPer.setVisible(false);
        panelPer.setManaged(false);
    }

    // ══════════════════════════════════════════════════
    // CONFIGURACIÓN DE TABLAS
    // ══════════════════════════════════════════════════
    private void configurarTablaMantenimiento() {
        colMantNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        colMantFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colMantGerente.setCellValueFactory(new PropertyValueFactory<>("gerente"));
        colMantSupervisor.setCellValueFactory(new PropertyValueFactory<>("supervisor"));
        colMantSatelite.setCellValueFactory(new PropertyValueFactory<>("personal")); // reutilizamos personal para guardar ID satélite
        colMantHerramientas.setCellValueFactory(new PropertyValueFactory<>("herramientas"));
        colMantJustificacion.setCellValueFactory(new PropertyValueFactory<>("justificacion"));
        colMantPropuesta.setCellValueFactory(new PropertyValueFactory<>("propuesta"));
        colMantCapital.setCellValueFactory(new PropertyValueFactory<>("capital"));
    }

    private void configurarTablaPersonal() {
        colPerCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colPerNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPerCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colPerMision.setCellValueFactory(new PropertyValueFactory<>("misionasignada"));
        colPerNivel.setCellValueFactory(new PropertyValueFactory<>("nivelprofesional"));
        colPerContrato.setCellValueFactory(new PropertyValueFactory<>("tipodecontrato"));
        colPerSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
    }

    private void configurarTablaSatelites() {
        colSatId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSatNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colSatFuncion.setCellValueFactory(new PropertyValueFactory<>("funcion"));
        colSatEncargado.setCellValueFactory(new PropertyValueFactory<>("encargado"));
        colSatDpto.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colSatLoc.setCellValueFactory(new PropertyValueFactory<>("localizacion"));
        colSatCapital.setCellValueFactory(new PropertyValueFactory<>("capital"));
    }

    // ══════════════════════════════════════════════════
    // DATOS PRECARGADOS
    // ══════════════════════════════════════════════════
    /** Capital genérico reutilizable para satélites precargados. */
    private static Capital capitalGenerico() {
        return new Capital("NASA", "Global", "Gestores NASA", "Contadores NASA",
                "Supervisores NASA", "Presidente NASA", 0.0, 0.0, "N/A", "Operacional");
    }

    private void cargarSatelitesPrecargados() {
        satelitesPrecargados.addAll(
            new Satelite("Alpha-1",  "SAT-001", "Titanio",   "M-A1",  "Observación meteorológica", "Dra. Martínez", "Meteorología",   "Órbita baja 550km",    "Mediano", "Falcon-9",   120_000_000, capitalGenerico()),
            new Satelite("Beta-2",   "SAT-002", "Aluminio",  "M-B2",  "Comunicaciones globales",   "Ing. Herrera",  "Comunicaciones", "Órbita geoestacionaria","Grande",  "Ariane-5",   250_000_000, capitalGenerico()),
            new Satelite("Gamma-3",  "SAT-003", "Compuesto", "M-G3",  "Navegación GPS",            "Dr. Cifuentes", "Navegación",     "Órbita media 20000km", "Pequeño", "Atlas-V",     95_000_000, capitalGenerico()),
            new Satelite("Delta-4",  "SAT-004", "Acero",     "M-D4",  "Reconocimiento militar",    "Cnel. Vargas",  "Defensa",        "Órbita polar 700km",   "Grande",  "Delta-IV",   310_000_000, capitalGenerico()),
            new Satelite("Épsilon-5","SAT-005", "Titanio",   "M-E5",  "Investigación científica",  "Dra. Rojas",    "Ciencia",        "Órbita elíptica",      "Mediano", "Soyuz",      175_000_000, capitalGenerico()),
            new Satelite("Zeta-6",   "SAT-006", "Aluminio",  "M-Z6",  "Vigilancia ambiental",      "Ing. Pedraza",  "Ambiente",       "Órbita baja 480km",    "Pequeño", "Vega",        80_000_000, capitalGenerico())
        );

        tablaSat.setItems(satelitesPrecargados);
        lblTotalSatelites.setText("Total de satélites registrados: " + satelitesPrecargados.size());

        // Poblar ComboBox de mantenimiento con los IDs de satélites
        ObservableList<String> idsSat = FXCollections.observableArrayList();
        for (Satelite s : satelitesPrecargados) {
            idsSat.add(s.getId() + " — " + s.getNombre());
        }
        cbMantSatelite.setItems(idsSat);
    }

    private void cargarDatosDesdeArchivo() {
        // Cargar personal desde archivo
        Personal[] persArray = archivoPersonal.deserializar();
        if (persArray != null) {
            servicioPersonal.setListaPersonal(persArray);
        }
        refrescarTablaPersonal();

        // Cargar mantenimientos desde archivo
        Mantenimiento[] mantArray = archivoMant.deserializar();
        if (mantArray != null) {
            servicioMant.setListaMantenimiento(mantArray);
            refrescarTablaMantenimiento();
        } else {
            // Solo precarga ejemplos si el archivo no existe (primera ejecucion)
            servicioMant.crear(new Mantenimiento("NIT-001", "2025-03-15", "Carlos Mendez", "Ana Lopez",
                    "SAT-001 - Alpha-1", "Multimetro, Soldador", "Fallo en panel solar", "Reemplazo de celdas", 45000.0, null));
            servicioMant.crear(new Mantenimiento("NIT-002", "2025-04-20", "Laura Gomez", "Pedro Diaz",
                    "SAT-003 - Gamma-3", "Osciloscopio, Laptop", "Deriva de senal GPS", "Recalibracion total", 62000.0, null));
            servicioMant.crear(new Mantenimiento("NIT-003", "2025-05-10", "Jorge Rios", "Maria Pinto",
                    "SAT-005 - Epsilon-5", "Sonda termica, Drill", "Sobrecalentamiento", "Instalacion disipador", 88000.0, null));
            archivoMant.serializar(servicioMant.getListaMantenimiento());
            refrescarTablaMantenimiento();
        }
    }

    /**
     * Persiste todos los datos en archivo. Llamado desde App al cerrar la ventana.
     */
    public void guardarTodo() {
        archivoPersonal.serializar(servicioPersonal.getListaPersonal());
        archivoMant.serializar(servicioMant.getListaMantenimiento());
    }

    // ══════════════════════════════════════════════════
    // REFRESH DE TABLAS
    // ══════════════════════════════════════════════════
    private void refrescarTablaMantenimiento() {
        ObservableList<Mantenimiento> lista = FXCollections.observableArrayList();
        for (Mantenimiento m : servicioMant.getListaMantenimiento()) {
            if (m != null) lista.add(m);
        }
        tablaMant.setItems(lista);
    }

    private void refrescarTablaPersonal() {
        ObservableList<Personal> lista = FXCollections.observableArrayList();
        for (Personal p : servicioPersonal.getListaPersonal()) {
            if (p != null) lista.add(p);
        }
        tablaPersonal.setItems(lista);
    }

    // ══════════════════════════════════════════════════
    // ABRIR PANEL MANTENIMIENTO
    // ══════════════════════════════════════════════════
    @FXML private void abrirCrearMant()      { abrirPanelMant("crear",      "➕ Registrar Mantenimiento", true,  "Registrar"); }
    @FXML private void abrirConsultarMant()  { abrirPanelMant("consultar",  "🔍 Consultar Mantenimiento", false, "Consultar"); }
    @FXML private void abrirActualizarMant() { abrirPanelMant("actualizar", "✏️ Actualizar Mantenimiento", true,  "Actualizar"); }
    @FXML private void abrirEliminarMant()   { abrirPanelMant("eliminar",   "🗑️ Eliminar Mantenimiento",  false, "Eliminar"); }

    private void abrirPanelMant(String modo, String titulo, boolean mostrarCampos, String textoBtn) {
        modoPanelMant = modo;
        lblTituloMant.setText(titulo);
        btnAccionMant.setText(textoBtn);
        rowsMant.setVisible(mostrarCampos);
        rowsMant.setManaged(mostrarCampos);
        cbMantSatelite.setVisible(mostrarCampos);
        cbMantSatelite.setManaged(mostrarCampos);
        limpiarCamposMant();
        panelMant.setVisible(true);
        panelMant.setManaged(true);
    }

    @FXML private void cerrarPanelMant() {
        panelMant.setVisible(false);
        panelMant.setManaged(false);
        limpiarCamposMant();
    }

    // ══════════════════════════════════════════════════
    // EJECUTAR ACCIÓN MANTENIMIENTO
    // ══════════════════════════════════════════════════
    @FXML
    private void ejecutarAccionMant() {
        String nit = tfMantNit.getText().trim();
        String resultado;

        switch (modoPanelMant) {
            case "crear":
                String satCrear = cbMantSatelite.getValue() != null ? cbMantSatelite.getValue() : "";
                Mantenimiento mCrear = new Mantenimiento(
                        nit, tfMantFecha.getText().trim(), tfMantGerente.getText().trim(),
                        tfMantSupervisor.getText().trim(), satCrear,
                        tfMantHerramientas.getText().trim(), tfMantJustificacion.getText().trim(),
                        tfMantPropuesta.getText().trim(), parsearDouble(tfMantCapital.getText()), null);
                resultado = servicioMant.crear(mCrear);
                archivoMant.serializar(servicioMant.getListaMantenimiento());
                refrescarTablaMantenimiento();
                break;
            case "consultar":
                Mantenimiento mConsultar = servicioMant.leer(nit);
                resultado = mConsultar != null ? mConsultar.toString() : "No se encontró registro con NIT: " + nit;
                break;
            case "actualizar":
                String satActualizar = cbMantSatelite.getValue() != null ? cbMantSatelite.getValue() : "";
                Mantenimiento mActualizar = new Mantenimiento(
                        nit, tfMantFecha.getText().trim(), tfMantGerente.getText().trim(),
                        tfMantSupervisor.getText().trim(), satActualizar,
                        tfMantHerramientas.getText().trim(), tfMantJustificacion.getText().trim(),
                        tfMantPropuesta.getText().trim(), parsearDouble(tfMantCapital.getText()), null);
                resultado = servicioMant.actualizar(nit, mActualizar);
                archivoMant.serializar(servicioMant.getListaMantenimiento());
                refrescarTablaMantenimiento();
                break;
            case "eliminar":
                resultado = servicioMant.eliminar(nit);
                archivoMant.serializar(servicioMant.getListaMantenimiento());
                refrescarTablaMantenimiento();
                break;
            default:
                resultado = "Modo desconocido.";
                break;
        }

        lblResultMant.setText(resultado);
    }

    // ══════════════════════════════════════════════════
    // ABRIR PANEL PERSONAL
    // ══════════════════════════════════════════════════
    @FXML private void abrirCrearPer()      { abrirPanelPer("crear",      "➕ Registrar Personal", true,  "Registrar"); }
    @FXML private void abrirConsultarPer()  { abrirPanelPer("consultar",  "🔍 Consultar Personal", false, "Consultar"); }
    @FXML private void abrirActualizarPer() { abrirPanelPer("actualizar", "✏️ Actualizar Personal", true,  "Actualizar"); }
    @FXML private void abrirEliminarPer()   { abrirPanelPer("eliminar",   "🗑️ Eliminar Personal",  false, "Eliminar"); }

    private void abrirPanelPer(String modo, String titulo, boolean mostrarCampos, String textoBtn) {
        modoPanelPer = modo;
        lblTituloPer.setText(titulo);
        btnAccionPer.setText(textoBtn);
        rowsPer.setVisible(mostrarCampos);
        rowsPer.setManaged(mostrarCampos);
        limpiarCamposPer();
        panelPer.setVisible(true);
        panelPer.setManaged(true);
    }

    @FXML private void cerrarPanelPer() {
        panelPer.setVisible(false);
        panelPer.setManaged(false);
        limpiarCamposPer();
    }

    // ══════════════════════════════════════════════════
    // EJECUTAR ACCIÓN PERSONAL
    // ══════════════════════════════════════════════════
    @FXML
    private void ejecutarAccionPer() {
        String cedula = tfPerCedula.getText().trim();
        String resultado;

        switch (modoPanelPer) {
            case "crear":
                Personal pCrear = crearPersonalDesdeCampos(cedula);
                resultado = servicioPersonal.crear(pCrear);
                archivoPersonal.serializar(servicioPersonal.getListaPersonal());
                refrescarTablaPersonal();
                break;
            case "consultar":
                Personal pConsultar = servicioPersonal.leer(cedula);
                resultado = pConsultar != null ? pConsultar.obtenerInformacion()
                        : "No se encontró personal con cédula: " + cedula;
                break;
            case "actualizar":
                Personal pActualizar = crearPersonalDesdeCampos(cedula);
                resultado = servicioPersonal.actualizar(cedula, pActualizar);
                archivoPersonal.serializar(servicioPersonal.getListaPersonal());
                refrescarTablaPersonal();
                break;
            case "eliminar":
                resultado = servicioPersonal.eliminar(cedula);
                archivoPersonal.serializar(servicioPersonal.getListaPersonal());
                refrescarTablaPersonal();
                break;
            default:
                resultado = "Modo desconocido.";
                break;
        }

        lblResultPer.setText(resultado);
    }

    // ══════════════════════════════════════════════════
    // HELPERS
    // ══════════════════════════════════════════════════

    /** Instancia Personal via clase anónima (Personal es abstracta). */
    private Personal crearPersonalDesdeCampos(String cedula) {
        String nombre  = tfPerNombre.getText().trim();
        String cargo   = tfPerCargo.getText().trim();
        String mision  = tfPerMision.getText().trim();
        String nivel   = tfPerNivel.getText().trim();
        String contrato= tfPerContrato.getText().trim();
        double sueldo  = parsearDouble(tfPerSueldo.getText());
        int anio       = parsearInt(tfPerAnio.getText(), 2000);
        char sexo      = tfPerSexo.getText().isEmpty() ? 'M' : tfPerSexo.getText().toUpperCase().charAt(0);
        String resp    = tfPerResponsabilidades.getText().trim();
        String benef   = tfPerBeneficios.getText().trim();
        String autor   = tfPerAutorizaciones.getText().trim();
        String codigo  = tfPerCodigoBarras.getText().trim();
        String campo   = tfPerCampo.getText().trim();

        return new TecnicoSatelite(cedula, nombre, cargo, mision, nivel, anio, resp, contrato,
                            benef, autor, sexo, codigo, campo, sueldo);
   }

    private double parsearDouble(String texto) {
        try { return Double.parseDouble(texto.trim()); }
        catch (NumberFormatException e) { return 0.0; }
    }

    private int parsearInt(String texto, int defecto) {
        try { return Integer.parseInt(texto.trim()); }
        catch (NumberFormatException e) { return defecto; }
    }

    private void limpiarCamposMant() {
        tfMantNit.clear(); tfMantFecha.clear(); tfMantGerente.clear();
        tfMantSupervisor.clear(); tfMantHerramientas.clear();
        tfMantJustificacion.clear(); tfMantPropuesta.clear();
        tfMantCapital.clear(); cbMantSatelite.setValue(null);
        lblResultMant.setText("");
    }

    private void limpiarCamposPer() {
        tfPerCedula.clear(); tfPerNombre.clear(); tfPerCargo.clear();
        tfPerMision.clear(); tfPerNivel.clear(); tfPerContrato.clear();
        tfPerSueldo.clear(); tfPerAnio.clear(); tfPerSexo.clear();
        tfPerResponsabilidades.clear(); tfPerBeneficios.clear();
        tfPerAutorizaciones.clear(); tfPerCodigoBarras.clear();
        tfPerCampo.clear(); lblResultPer.setText("");
    }
}