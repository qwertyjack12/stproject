package com.example.stproject;

import com.example.zp.svc.services.groupService.GroupServiceProject;
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

public class GroupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addGroupButton;

    @FXML
    private Button addStudentGroupButton;


    @FXML
    private Button removeGroupButton;

    @FXML
    private Button removeStudentsGroupButton;

    @FXML
    private Button showStudentButton;

    @FXML
    private Button showGroupButton;

    @FXML
    void initialize() {
        addGroupButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-group-view.fxml"));

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

        removeGroupButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("remove-group-view.fxml"));

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

        showGroupButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = GroupServiceProject.getGroups();
            textArea.setText(content);
        });

        showStudentButton.setOnAction(event -> {
            TextArea textArea = HelloController.textArea;
            String content = String.valueOf(GroupServiceProject.getStudents());
            textArea.setText(content);
        });

        addStudentGroupButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("add-student-group-view.fxml"));

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

        removeStudentsGroupButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("remove-student-group-view.fxml"));

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