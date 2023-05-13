package com.example.stproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button disciplineButton;

    @FXML
    private Button exitProgramButton;

    @FXML
    private Button groupButton;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Button studentButton;

    @FXML
    private Button teacherButton;

    @FXML
    void initialize() {
        exitProgramButton.setOnAction(event -> {
            System.out.println("exit button");
        });

    }

}
