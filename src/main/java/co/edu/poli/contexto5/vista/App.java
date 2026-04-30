package co.edu.poli.contexto5.vista;

import co.edu.poli.contexto5.controller.PrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        URL url = App.class.getResource("/co/edu/poli/actividad9/primary.fxml");
        if (url == null) {
            throw new IOException("No se encontró primary.fxml");
        }

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        // Obtener el controller para poder llamar guardarTodo() al cerrar
        PrimaryController controller = loader.getController();

        scene = new Scene(root, 1100, 750);
        stage.setTitle("SatControl — Gestión de Satélites");
        stage.setScene(scene);

        // Guardar datos automáticamente cuando el usuario cierra la ventana
        stage.setOnCloseRequest(event -> controller.guardarTodo());

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL url = App.class.getResource("/co/edu/poli/actividad9/" + fxml + ".fxml");
        if (url == null) {
            throw new IOException("No se encontró el FXML: " + fxml + ".fxml");
        }
        return new FXMLLoader(url).load();
    }

    public static void main(String[] args) {
        launch();
    }
}