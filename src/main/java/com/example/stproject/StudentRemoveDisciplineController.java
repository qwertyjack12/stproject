package com.example.stproject;

import com.example.zp.svc.services.studentService.StudentServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentRemoveDisciplineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField disciplineNameButton;

    @FXML
    private TextField idStudentButton;

    @FXML
    private Button removeStudentDsiciplineButton;

    private void clearInputData(){
        disciplineNameButton.clear();
        idStudentButton.clear();
    }
    @FXML
    void initialize() {
        removeStudentDsiciplineButton.setOnAction(event -> {
            int idStudent = Integer.parseInt(idStudentButton.getText().trim());
            String discipline = disciplineNameButton.getText().trim();

            StudentServiceProject.removeDiscipline(idStudent, discipline);
            clearInputData();
        });
    }

}
