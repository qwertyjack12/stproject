package com.example.zp.svc.controllers;

import com.example.zp.svc.services.groupService.GroupService;
import com.example.zp.svc.services.studentService.StudentService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GroupController {

    private final GroupService groupService;
    private final StudentService studentService;
    private final Scanner scanner;
    private final ExecutorService service;

    public GroupController(GroupService groupService, StudentService studentService, Scanner scanner){
        this.groupService = groupService;
        this.studentService = studentService;
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
                groupService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                groupService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setGroup() {
        System.out.print("id of group: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();

        groupService.setGroup(id, name);
    }

    public void removeGroup() {
        groupService.getGroups();
        System.out.print("id of group: ");
        int key = listenInt();
        if (!groupService.checkGroupKey(key)){
            return;
        }
        groupService.removeGroup(key);
    }

    public void removeStudentInGroup() {
        groupService.getGroups();
        System.out.print("Number group: ");
        Integer keyGroup = listenInt();
        if (!groupService.checkGroupKey(keyGroup)){
            return;
        }

        studentService.getStudents();
        System.out.print("Number student: ");
        Integer keyStudent = listenInt();
        if (!studentService.checkStudentKey(keyStudent)){
            return;
        }

        groupService.removeStudentInGroup(keyGroup, studentService.getStudent(keyStudent));
    }

    public void addStudent() {
        groupService.getGroups();
        System.out.print("Number group: ");
        Integer keyGroup = listenInt();
        if (!groupService.checkGroupKey(keyGroup)){
            return;
        }

        studentService.getStudents();
        System.out.print("Number student: ");
        Integer keyStudent = listenInt();
        if (!studentService.checkStudentKey(keyStudent)){
            return;
        }

        groupService.addStudent(studentService.getStudent(keyStudent), keyGroup);
    }

    public void getGroupsRating() {
        groupService.getGroups();
        groupService.getGroupsRating();
    }

    public void getGroups() {
        groupService.getGroups();
    }

}
