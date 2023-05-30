package com.example.stproject.teacherControllers;

import com.example.zp.svc.services.disciplineService.DisciplineServiceProject;
import com.example.zp.svc.services.groupService.GroupServiceProject;
import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAddGroupController {

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
    private TextField idGroupButton;

    @FXML
    private TextField idTeacherButton;

    private void clearInputData(){
        idTeacherButton.clear();
        idGroupButton.clear();
        idDisciplineButton.clear();
    }

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            int idTeacher = Integer.parseInt(idTeacherButton.getText().trim());
            int idGroup = Integer.parseInt(idGroupButton.getText().trim());
            int idDiscipline = Integer.parseInt(idDisciplineButton.getText().trim());

            TeacherServiceProject.addTeacherGroup(idTeacher, DisciplineServiceProject.getDiscipline(idDiscipline), GroupServiceProject.getGroup(idGroup));
            clearInputData();
        });
    }

}
