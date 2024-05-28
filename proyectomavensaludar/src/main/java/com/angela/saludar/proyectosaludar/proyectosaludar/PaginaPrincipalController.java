package com.angela.saludar.proyectosaludar.proyectosaludar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PaginaPrincipalController {
	@FXML
	private Button paginaprincipalsaludarButton;
	@FXML
	private Button salirButton;
	@FXML
    private TextField textopaginaprincipal;
	
    @FXML
    private void cambiarpaginasaludo() throws IOException {
    	 String texto = textopaginaprincipal.getText(); 
         App.setRoot("paginasaludo", texto); 
    }
    
    @FXML
    private void salirBotton() {
        Platform.exit(); //o también Systemctl.exit()
    }
    
    @FXML
    private void crearDocumentoWord() {
        String texto = textopaginaprincipal.getText();
     
        String filePath = "C:\\Users\\angelaClase\\Desktop/hola.docx";
        try {
            XWPFDocument document = new XWPFDocument();

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(texto);
            
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
                generarAlertaWord();
            }
            System.out.println("Documento Word creado correctamente: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    private void crearDocumentoPDF() {
    	String texto = textopaginaprincipal.getText();
        String filePath = "C:\\Users\\angelaClase\\Desktop" + File.separator + "hola.pdf";

        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph(texto));

            document.close();
            generarAlertaPDF();
            System.out.println("Documento PDF creado correctamente: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado. Verifique la ruta de salida.");
            e.printStackTrace();
        } catch (DocumentException e) {
            System.err.println("Error al crear el documento PDF. Verifique el contenido del documento.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Se ha producido un error inesperado al crear el documento PDF.");
            e.printStackTrace();
        }
    }

	private void generarAlertaWord() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Mensaje");
		alert.setContentText("Documento de Word creado correctamente.");
		alert.showAndWait();
	}
    
	private void generarAlertaPDF() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Mensaje");
		alert.setContentText("Documento de PDF creado correctamente.");
		alert.showAndWait();
	}
}
