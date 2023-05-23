package com.example.stproject;

import com.example.zp.svc.services.disciplineService.DisciplineServiceProject;
import com.example.zp.svc.services.groupService.GroupServiceProject;
import com.example.zp.svc.services.studentService.StudentServiceProject;
import com.example.zp.svc.services.teacherService.TeacherServiceProject;
import javafx.application.Platform;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button projectInfoButton;

    @FXML
    private URL location;

    @FXML
    private TextArea outputWindow;

    public static TextArea textArea;

    @FXML
    private Button disciplineButton;

    @FXML
    private Button exitProgramButton;
    @FXML
    private Button groupButton;
    @FXML
    private Button saveChangesButton;
    @FXML
    private Button studentButton;
    @FXML
    private Button teacherButton;

    @FXML
    void initialize() {
        textArea = outputWindow;

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Runnable() {
            @Override
            public void run() {
                DisciplineServiceProject.readData();
                GroupServiceProject.readData();
                StudentServiceProject.readData();
                TeacherServiceProject.readData();
            }
        });

        saveChangesButton.setOnAction(event -> {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    DisciplineServiceProject.saveData();
                    GroupServiceProject.saveData();
                    StudentServiceProject.saveData();
                    TeacherServiceProject.saveData();
                }
            });
        });

        projectInfoButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("project-info-view.fxml"));
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

        exitProgramButton.setOnAction(event -> {
            service.shutdown();
            Platform.exit();
        });

        disciplineButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("discipline-view.fxml"));
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

        groupButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("group-view.fxml"));
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

        studentButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("student-view.fxml"));
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

        teacherButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("teacher-view.fxml"));
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
    }
}