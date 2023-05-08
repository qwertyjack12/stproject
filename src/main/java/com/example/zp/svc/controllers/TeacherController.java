package com.example.zp.svc.controllers;

import com.example.zp.svc.services.disciplineService.DisciplineService;
import com.example.zp.svc.services.groupService.GroupService;
import com.example.zp.svc.services.teacherService.TeacherService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TeacherController {

    private final TeacherService teacherService;
    private final DisciplineService disciplineService;
    private final GroupService groupService;
    private final Scanner scanner;
    private final ExecutorService service;

    public TeacherController(TeacherService teacherService, DisciplineService disciplineService, GroupService groupService, Scanner scanner){
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.groupService = groupService;
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
                teacherService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                teacherService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setTeacher() {
        System.out.print("id of teacher: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Login: ");
        String login = listenStr();
        System.out.print("Password: ");
        String password = listenStr();

        teacherService.setTeacher(id, name, login, password);
    }

    public void removeTeacher() {
        System.out.print("id of teacher: ");
        int key = listenInt();
        if (!teacherService.checkTeacherKey(key)){
            return;
        }
        teacherService.removeTeacher(key);
    }

    public void addTeacherDiscipline() {
        teacherService.getTeachers();
        System.out.print("Number: ");
        Integer keyTeacher = listenInt();
        if (!teacherService.checkTeacherKey(keyTeacher)){
            return;
        }

        disciplineService.getDisciplines();
        System.out.print("Number: ");
        Integer keyDiscipline = listenInt();
        if (!disciplineService.checkDisciplineKey(keyDiscipline)){
            return;
        }

        teacherService.addTeacherDiscipline(disciplineService.getDiscipline(keyDiscipline), keyTeacher);
    }

    public void addTeacherGroup() {
        teacherService.getTeachers();
        System.out.print("Number: ");
        Integer keyTeacher = listenInt();
        if (!teacherService.checkTeacherKey(keyTeacher)){
            return;
        }

        disciplineService.getDisciplines();
        System.out.print("Number: ");
        Integer keyDiscipline = listenInt();
        if (!disciplineService.checkDisciplineKey(keyDiscipline)){
            return;
        }

        groupService.getGroups();
        System.out.print("Number: ");
        Integer keyGroup = listenInt();
        if (!groupService.checkGroupKey(keyGroup)){
            return;
        }

        teacherService.addTeacherGroup(keyTeacher, disciplineService.getDiscipline(keyDiscipline), groupService.getGroup(keyGroup));
    }

    public void getTeachersDisciplines() {
        teacherService.getTeachersDisciplines();
    }

    public void getTeachers() {
        teacherService.getTeachers();
    }

}
