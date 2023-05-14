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

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            String filePath = "T:\\Java\\stproject\\src\\main\\resources\\com\\example\\stproject\\projectInfo.docx";

            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            DocPrintJob printJob = defaultPrintService.createPrintJob();

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(new File(filePath));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Doc doc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);

            PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
            attributes.add(MediaSizeName.ISO_A4);
            attributes.add(new Copies(1));

            try {
                printJob.print(doc, attributes);
            } catch (PrintException e) {
                throw new RuntimeException(e);
            }

            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
