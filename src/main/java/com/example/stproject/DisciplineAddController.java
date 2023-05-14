package com.example.stproject;

import com.example.zp.svc.services.disciplineService.DisciplineServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DisciplineAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addDisciplineButton;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idButton;

    @FXML
    private TextField nameButton;

    private void clearInputData(){
        idButton.clear();
        nameButton.clear();
    }
    @FXML
    void initialize() {
        addDisciplineButton.setOnAction(event -> {
            int id = Integer.parseInt(idButton.getText().trim());
            String name = nameButton.getText().trim();

            DisciplineServiceProject.setDiscipline(id, name);
            clearInputData();
        });
    }

}
