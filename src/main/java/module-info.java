module com.example.stproject {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.stproject to javafx.fxml;
    exports com.example.stproject;
}