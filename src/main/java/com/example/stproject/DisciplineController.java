package com.example.stproject;

import com.example.zp.svc.services.disciplineService.DisciplineServiceProject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisciplineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addDisciplineButton;

    @FXML
    private Button exitDisciplineButton;

    @FXML
    private Button showDisciplineButton;

    @FXML
    void initialize() {
        addDisciplineButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-discipline-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.showAndWait();
        });

        showDisciplineButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = DisciplineServiceProject.getDisciplines();
            textArea.setText(content);
        });

    }
}