package com.example.stproject.studentControllers;

import com.example.zp.svc.services.studentService.StudentServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentAddDisciplineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addStudentDsiciplineButton;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField disciplineNameButton;

    @FXML
    private TextField gradeValueButton;

    @FXML
    private TextField idStudentButton;

    @FXML
    private TextField typeGradeButton;

    private void clearInputData(){
        disciplineNameButton.clear();
        typeGradeButton.clear();
        gradeValueButton.clear();
        idStudentButton.clear();
    }
    @FXML
    void initialize() {
        addStudentDsiciplineButton.setOnAction(event -> {
            int idStudent = Integer.parseInt(idStudentButton.getText().trim());
            String discipline = disciplineNameButton.getText().trim();
            String typeGrade = typeGradeButton.getText().trim();
            int grade = Integer.parseInt(gradeValueButton.getText().trim());

            StudentServiceProject.addDiscipline(discipline, typeGrade, grade, idStudent);
            clearInputData();
        });
    }
}
