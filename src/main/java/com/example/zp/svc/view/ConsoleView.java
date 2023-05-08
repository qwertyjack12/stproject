package com.example.zp.svc.view;

import com.example.zp.svc.controllers.*;

import java.util.Scanner;

public class ConsoleView implements View {
    private  final DisciplineController disciplineController;
    private  final GroupController groupController;
    private  final StudentController studentController;
    private  final TeacherController teacherController;
    private boolean flag;

    public ConsoleView(DisciplineController disciplineController, GroupController groupController, StudentController studentController, TeacherController teacherController) {
        this.flag = true;
        this.disciplineController = disciplineController;
        this.groupController = groupController;
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    @Override
    public int listen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void init() {
        while (this.flag) {
            showMenu();
        }
    }

    @Override
    public void saveChanges() {
        disciplineController.saveChanges();
        groupController.saveChanges();
        studentController.saveChanges();
        teacherController.saveChanges();
    }

    @Override
    public void readData() {
        disciplineController.readData();
        groupController.readData();
        studentController.readData();
        teacherController.readData();
    }

    @Override
    public void closeThread() {
        disciplineController.closeThread();
        groupController.closeThread();
        studentController.closeThread();
        teacherController.closeThread();
    }

    @Override
    public void showMenu() {

        System.out.println("Menu:");
        System.out.println("-> 1: Student");
        System.out.println("-> 2: Teacher");
        System.out.println("-> 3: Group");
        System.out.println("-> 4: Discipline");
        System.out.println("-> 5: Save");
        System.out.println("-> 0: Close app");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                this.flag = false;
                this.closeThread();
                return;
            }
            case 1 -> showStudents();
            case 2 -> showTeachers();
            case 3 -> showGroups();
            case 4 -> showDisciplines();
            case 5 -> this.saveChanges();
            default -> showMenu();
        }

    }

    @Override
    public void showStudents() {
        System.out.println("Students Menu:");
        System.out.println("-> 1: Add Student");
        System.out.println("-> 2: Remove Student");
        System.out.println("-> 3: Add discipline for Student");
        System.out.println("-> 4: Show rating for any Students");
        System.out.println("-> 5: Show Student grades");
        System.out.println("-> 6: Show Students");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> studentController.setStudent();
            case 2 -> studentController.removeStudent();
            case 3 -> studentController.addDiscipline();
            case 4 -> studentController.getStudentsRating();
            case 5 -> studentController.getStudentGrades();
            case 6 -> studentController.getStudents();
            default -> showMenu();
        }
    }

    @Override
    public void showTeachers() {
        System.out.println("Teachers Menu:");
        System.out.println("-> 1: Add Teacher");
        System.out.println("-> 2: Remove Teacher");
        System.out.println("-> 3: Add discipline for Teacher");
        System.out.println("-> 4: Add group for Teacher");
        System.out.println("-> 5: Show groups for any Teachers");
        System.out.println("-> 6: Show Teachers");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> teacherController.setTeacher();
            case 2 -> teacherController.removeTeacher();
            case 3 -> teacherController.addTeacherDiscipline();
            case 4 -> teacherController.addTeacherGroup();
            case 5 -> teacherController.getTeachersDisciplines();
            case 6 -> teacherController.getTeachers();
            default -> showMenu();
        }
    }

    @Override
    public void showGroups() {
        System.out.println("Groups Menu:");
        System.out.println("-> 1: Add Group");
        System.out.println("-> 2: Remove Group");
        System.out.println("-> 3: Remove student in Group");
        System.out.println("-> 4: Add students for Group");
        System.out.println("-> 5: Show rating any Groups");
        System.out.println("-> 6: Show Groups");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> groupController.setGroup();
            case 2 -> groupController.removeGroup();
            case 3 -> groupController.removeStudentInGroup();
            case 4 -> groupController.addStudent();
            case 5 -> groupController.getGroupsRating();
            case 6 -> groupController.getGroups();
            default -> showMenu();
        }
    }

    @Override
    public void showDisciplines() {
        System.out.println("Disciplines Menu:");
        System.out.println("-> 1: Add Discipline");
        System.out.println("-> 2: Show Disciplines");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> disciplineController.setDiscipline();
            case 2 -> disciplineController.getDisciplines();
            default -> showMenu();
        }
    }
}
