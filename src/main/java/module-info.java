module co.edu.poli.actividad9 {
    requires javafx.controls;
    requires javafx.fxml;
 
    opens co.edu.poli.contexto5.vista       to javafx.fxml;
    opens co.edu.poli.contexto5.controller  to javafx.fxml;
    opens co.edu.poli.contexto5.modelo      to javafx.fxml, javafx.base;
    opens co.edu.poli.contexto5.servicios   to javafx.fxml;
 
    exports co.edu.poli.contexto5.vista;
    exports co.edu.poli.contexto5.controller;
}
 