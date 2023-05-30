module com.example.stproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires com.google.gson;
            
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.stproject to javafx.fxml;
    exports com.example.stproject;
    exports com.example.stproject.server;
    opens com.example.stproject.server to javafx.fxml;
    exports com.example.stproject.disciplineControllers;
    opens com.example.stproject.disciplineControllers to javafx.fxml;
    exports com.example.stproject.groupControllers;
    opens com.example.stproject.groupControllers to javafx.fxml;
    exports com.example.stproject.studentControllers;
    opens com.example.stproject.studentControllers to javafx.fxml;
    exports com.example.stproject.teacherControllers;
    opens com.example.stproject.teacherControllers to javafx.fxml;
}