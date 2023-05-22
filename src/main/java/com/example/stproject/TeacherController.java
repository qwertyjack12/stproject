package com.example.stproject;

import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button addDisciplineTeacherButton;
    @FXML
    private Button addGroupTeacherButton;
    @FXML
    private Button addTeacherButton;
    @FXML
    private Button exitTeacherButton;
    @FXML
    private Button removeTeacherButton;
    @FXML
    private Button showGroupsTeacherButton;
    @FXML
    private Button showTeacherButton;

    @FXML
    void initialize() {
        addTeacherButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-teacher-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.showAndWait();
        });

        removeTeacherButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("remove-teacher-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.showAndWait();
        });

        addDisciplineTeacherButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-discipline-teacher-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.showAndWait();
        });

        addGroupTeacherButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-group-teacher-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.showAndWait();
        });

        showTeacherButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = TeacherServiceProject.getTeachers();
            textArea.setText(content);
        });

        showGroupsTeacherButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = String.valueOf(TeacherServiceProject.getTeachersDisciplines());
            textArea.setText(content);
        });

    }

}