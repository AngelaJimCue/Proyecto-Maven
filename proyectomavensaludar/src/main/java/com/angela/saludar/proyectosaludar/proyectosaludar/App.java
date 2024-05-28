package com.angela.saludar.proyectosaludar.proyectosaludar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;



public class App extends Application {

    private static Scene scene;

    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("paginaprincipal"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Aplicación de Saludo, World y PDF");
        stage.show();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }    
    static void setRoot(String fxml, String texto) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();
        if (fxml.equals("paginasaludo")) {
            PaginaSaludoController controller = loader.getController();
            controller.setTextoPaginaSaludo(texto);
        }
        scene.setRoot(root);
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}