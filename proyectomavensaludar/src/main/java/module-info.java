module com.angela.saludar.proyectosaludar.proyectosaludar {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires org.apache.poi.ooxml;
	requires itext;
	requires itextpdf;

    opens com.angela.saludar.proyectosaludar.proyectosaludar to javafx.fxml;
    exports com.angela.saludar.proyectosaludar.proyectosaludar;
}
