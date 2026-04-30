package co.edu.poli.contexto5.controller;

import java.io.IOException;

import co.edu.poli.contexto5.vista.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    public void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}