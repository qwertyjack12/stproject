package com.example.stproject;

import com.example.zp.svc.services.studentService.StudentServiceProject;
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

public class StudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addDisciplineStudentButton;

    @FXML
    private Button addStudentButton;

    @FXML
    private Button exitStudentButton;

    @FXML
    private Button removeDisciplineStudentButton;

    @FXML
    private Button removeStudentButton;

    @FXML
    private Button showGradesStudentButton;

    @FXML
    private Button showRatingStudentButton;

    @FXML
    private Button showStudentButton;

    @FXML
    void initialize() {
        addStudentButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-student-view.fxml"));

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

        removeStudentButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("remove-student-view.fxml"));

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

        showStudentButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = StudentServiceProject.getStudents();
            textArea.setText(content);
        });

        showGradesStudentButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            StringBuilder content = StudentServiceProject.getStudentsGrades();
            textArea.setText(String.valueOf(content));
        });

        showRatingStudentButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            StringBuilder content = StudentServiceProject.getStudentsRating();
            textArea.setText(String.valueOf(content));
        });

        addDisciplineStudentButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-discipline-student-view.fxml"));

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

        removeDisciplineStudentButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("remove-discipline-student-view.fxml"));

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
