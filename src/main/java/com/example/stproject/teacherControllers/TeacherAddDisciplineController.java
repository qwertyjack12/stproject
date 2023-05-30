package com.example.stproject.teacherControllers;

import com.example.zp.svc.services.disciplineService.DisciplineServiceProject;
import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAddDisciplineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backWindowButton;

    @FXML
    private TextField idDisciplineButton;

    @FXML
    private TextField idTeacherButton;

    private void clearInputData(){
        idTeacherButton.clear();
        idDisciplineButton.clear();
    }
    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            int idTeacher = Integer.parseInt(idTeacherButton.getText().trim());
            int idDiscipline = Integer.parseInt(idDisciplineButton.getText().trim());

            TeacherServiceProject.addTeacherDiscipline(DisciplineServiceProject.getDiscipline(idDiscipline), idTeacher);
            clearInputData();
        });
    }

}
