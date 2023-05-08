package com.example.zp.svc.view;

public interface View {
    int listen();

    void init();
    void saveChanges();
    void readData();
    void closeThread();

    void showMenu();

    void showStudents();

    void showTeachers();

    void showGroups();

    void showDisciplines();
}
