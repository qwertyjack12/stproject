package com.example.stproject.groupControllers;

import com.example.zp.svc.services.groupService.GroupServiceProject;
import com.example.zp.svc.services.studentService.StudentServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupRemoveStudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idGroupButton;

    @FXML
    private TextField idStudentButton;

    @FXML
    private Button removeButton;

    private void clearInputData(){
        idGroupButton.clear();
        idStudentButton.clear();
    }

    @FXML
    void initialize() {
        removeButton.setOnAction(event -> {
            int idGroup = Integer.parseInt(idGroupButton.getText().trim());
            int idStudent = Integer.parseInt(idStudentButton.getText().trim());

            GroupServiceProject.removeStudentInGroup(idGroup, StudentServiceProject.getStudent(idStudent));
            clearInputData();
        });
    }

}
