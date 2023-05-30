package com.example.stproject.teacherControllers;

import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addTeacherButton;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idButton;

    @FXML
    private TextField loginButton;

    @FXML
    private TextField nameButton;

    @FXML
    private TextField passwordButton;

    private void clearInputData(){
        idButton.clear();
        nameButton.clear();
        loginButton.clear();
        passwordButton.clear();
    }
    @FXML
    void initialize() {
        addTeacherButton.setOnAction(event -> {
            int id = Integer.parseInt(idButton.getText().trim());
            String name = nameButton.getText().trim();
            String login = loginButton.getText().trim();
            String password = passwordButton.getText().trim();

            TeacherServiceProject.setTeacher(id, name, login, password);
            clearInputData();
        });
    }

}
