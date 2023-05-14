package com.example.stproject;

import com.example.zp.svc.services.groupService.GroupServiceProject;
import com.example.zp.svc.services.studentService.StudentServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupAddStudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idGroupButton;

    @FXML
    private TextField idStudentButton;

    private void clearInputData(){
        idGroupButton.clear();
        idStudentButton.clear();
    }
    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            int idGroup = Integer.parseInt(idGroupButton.getText().trim());
            int idStudent = Integer.parseInt(idStudentButton.getText().trim());

            GroupServiceProject.addStudent(StudentServiceProject.getStudent(idStudent), idGroup);
            clearInputData();
        });
    }

}
