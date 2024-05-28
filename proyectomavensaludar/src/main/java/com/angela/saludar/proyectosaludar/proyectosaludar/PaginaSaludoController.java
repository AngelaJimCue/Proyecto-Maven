package com.angela.saludar.proyectosaludar.proyectosaludar;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PaginaSaludoController {
	@FXML
    private Button paginasaludoButton;
	@FXML
    private Label textopaginasaludo;

	
    @FXML
    private void cambiarpaginaprincipal() throws IOException {
        App.setRoot("paginaprincipal");
    }
    
    public void setTextoPaginaSaludo(String texto) {
        textopaginasaludo.setText("Hola " + texto + " !!");
    }
}