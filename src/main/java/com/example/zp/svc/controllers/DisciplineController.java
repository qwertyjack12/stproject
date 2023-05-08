package com.example.zp.svc.controllers;

import com.example.zp.svc.services.disciplineService.DisciplineService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisciplineController {

    private final DisciplineService disciplineService;
    private final Scanner scanner;
    public final ExecutorService service;

    public DisciplineController(DisciplineService disciplineService, Scanner scanner){
        this.disciplineService = disciplineService;
        this.scanner = scanner;
        service = Executors.newFixedThreadPool(2);
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
                disciplineService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                disciplineService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setDiscipline() {
        System.out.print("id of discipline: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();

        disciplineService.setDiscipline(id, name);
    }

    public void getDisciplines() {
        disciplineService.getDisciplines();
    }

}
