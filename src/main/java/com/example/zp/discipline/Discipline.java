package com.example.zp.discipline;

import com.example.zp.grade.Grade;

import java.io.Serializable;

/**
 * Класс дисциплины со свойствам name и grade
 *
 * @author Zelenin
 * @version 1.0
 */

public class Discipline<T extends Grade> implements Serializable{
    protected int id;
    /**
     * Поле название дисциплины
     */
    protected String name;
    /**
     * Поле оценки по дисциплине
     */
    protected T grade;


    public Discipline(){
        this.name = "Excuse me Discipline?";
    }


    /**
     * Конструктор - создание нового объекта с определенным значениямия
     *
     * @param name  - название дисциплины
     * @param grade - оценка
     * @see Discipline#Discipline(String, Grade)
     */
    public Discipline(String name, T grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * Конструктор - создание нового объекта с определенным значениямия
     *
     * @param name - название дисциплины
     * @see Discipline#Discipline(int, String)
     */
    public Discipline(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Discipline#name}
     *
     * @return возвращает название производителя
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения названия{@link Discipline#name}
     *
     * @param name - название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Discipline#grade}
     *
     * @return возвращает оценку
     */
    public T getGrade() {
        return grade;
    }

    /**
     * Процедура определения названия{@link Discipline#grade}
     *
     * @param grade - оценка
     */
    public void setGrade(T grade) {
        this.grade = grade;
    }

    /**
     * Переопределение функции  toString базового класса Object
     */
    @Override
    public String toString() {
        return "Discipline: " + this.getName();
    }

}
