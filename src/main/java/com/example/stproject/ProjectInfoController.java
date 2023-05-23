package com.example.stproject;

import com.example.zp.svc.services.studentService.StudentServiceProject;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPain;

    @FXML
    private AnchorPane anchorPanePrint;

    @FXML
    private Button findButton;

    @FXML
    private TextField idStudent;

    @FXML
    private Button printButton;

    @FXML
    private TextArea printTextArea;

    @FXML
    void initialize() {
        findButton.setOnAction(event -> {
            int id = Integer.parseInt(idStudent.getText().trim());
            StringBuilder stringBuilder = new StringBuilder();
            String gradesContent = StudentServiceProject.getStudent(id).getStudentGrades();
            String nameContent = StudentServiceProject.getStudent(id).getName();
            String ratingContent = String.valueOf(StudentServiceProject.getStudent(id).getRating());
            stringBuilder.append("Name of student: ");
            stringBuilder.append(nameContent);
            stringBuilder.append("\nGrades of student:\n");
            stringBuilder.append(gradesContent);
            stringBuilder.append("\nRating of student: ");
            stringBuilder.append(ratingContent);
            printTextArea.setText(String.valueOf(stringBuilder));
        });

        printButton.setOnAction(event -> {
            PrinterJob job = PrinterJob.createPrinterJob();
            job.showPageSetupDialog(null);
            job.showPrintDialog(null);
            if (job != null) {
                boolean success = job.printPage(anchorPanePrint);
                if (success) {
                    job.endJob();
                }
            }
        });
    }

}
