package com.example.zp.users;

import com.example.zp.discipline.Discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс студента со свойствами login и password
 *
 * @author Zelenin
 * @version 1.0
 */

public class Student extends User implements StudentInterface, Serializable {

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name     - name
     * @param login    - login
     * @param password - password
     * @see Student#Student(int, String, String, String)
     */
    public Student(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.list = new ArrayList<>();
    }

    /**
     * Переопределение функции append_discipline интерфейса StudentInterface
     */
    @Override
    public void appendDiscipline(Discipline<?> discipline) {
        list.add(discipline);
    }

    /**
     * Переопределение функции remove_discipline интерфейса StudentInterface
     */
    @Override
    public void removeDiscipline(Discipline<?> discipline) {
        list.remove(discipline);
    }

    /**
     * Переопределение функции remove_discipline интерфейса StudentInterface
     */
    @Override
    public void removeDiscipline(int index) {
        list.remove(index);
    }

    @Override
    public double getRating() {
        double total = 0;
        for (Discipline<?> discipline : list) {
            total += discipline.getGrade().getValue();
        }
        if (list.size() != 0) {
            return total / list.size();
        }else {
            return total;
        }
    }

    @Override
    public String getStudentGrades() {
        List<String> output = new ArrayList<>();
        for (Discipline<?> discipline : list) {
            output.add(discipline.getName() + " " + discipline.getGrade().getValue() + " " + discipline.getGrade().toString());
        }

        if (output.size() != 0){
            return output.toString();
        }
        else {
            return "haven't grades";
        }
    }
}
