package com.example.stproject.teacherControllers;

import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherRemoveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idButton;

    @FXML
    private Button removeButton;
    private void clearInputData(){
        idButton.clear();
    }
    @FXML
    void initialize() {
        removeButton.setOnAction(event -> {
            int id = Integer.parseInt(idButton.getText().trim());

            TeacherServiceProject.removeTeacher(id);
            clearInputData();
        });

    }
}