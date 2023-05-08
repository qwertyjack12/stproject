package com.example.zp.svc.controllers;

import com.example.zp.svc.services.disciplineService.DisciplineService;
import com.example.zp.svc.services.studentService.StudentService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentController {

    private final StudentService studentService;
    private final DisciplineService disciplineService;
    private final Scanner scanner;
    private final ExecutorService service;

    public StudentController(StudentService studentService, DisciplineService disciplineService, Scanner scanner){
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.scanner = scanner;
        this.service = Executors.newSingleThreadExecutor();
    }

    public int listenInt() {
        return scanner.nextInt();
    }
    public String listenStr() {
        return scanner.next();
    }
    public void saveChanges(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                studentService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                studentService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setStudent() {
        System.out.print("id of student: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Login: ");
        String login = listenStr();
        System.out.print("Password: ");
        String password = listenStr();

        studentService.setStudent(id, name, login, password);
    }

    public void addDiscipline() {
        disciplineService.getDisciplines();
        System.out.print("Number discipline: ");
        Integer disciplineKey = listenInt();
        if (!disciplineService.checkDisciplineKey(disciplineKey)){
            return;
        }

        System.out.print("Type grade (exam/offset): ");
        String typeGrade = listenStr();
        if ((!typeGrade.equals("exam")) & (!typeGrade.equals("offset"))){
            System.out.println("Wrong type grade input!");
            return;
        }

        System.out.print("Value grade: ");
        int value = listenInt();
        if ((value < 1) | (value > 5)){
            System.out.println("Wrong value grade input!");
            return;
        }

        studentService.getStudents();
        System.out.print("Number student: ");
        Integer studentKey = listenInt();
        if (!studentService.checkStudentKey(studentKey)){
            return;
        }

        studentService.addDiscipline(disciplineService.getDiscipline(disciplineKey).getName(), typeGrade, value, studentKey);
    }

    public void getStudentsRating() {
        studentService.getStudents();
        studentService.getStudentsRating();
    }

    public void getStudentGrades() {
        studentService.getStudents();
        System.out.print("Number student: ");
        Integer studentKey = listenInt();
        if (!studentService.checkStudentKey(studentKey)){
            return;
        }

        studentService.getStudentGrades(studentKey);
    }

    public void getStudents() {
        studentService.getStudents();
    }

    public void removeStudent() {
        studentService.getStudents();
        System.out.print("id of student: ");
        int key = listenInt();
        if (!studentService.checkStudentKey(key)){
            return;
        }
        studentService.removeStudent(key);
    }

}
