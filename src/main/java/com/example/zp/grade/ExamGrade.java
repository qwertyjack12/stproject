package com.example.zp.grade;

import java.io.Serializable;

/**
 * Класс оценки за экзамен со свойством value
 *
 * @author Zelenin
 * @version 1.0
 */

public class ExamGrade extends Grade implements Serializable {

    /**
     * Конструктор - создание нового объекта с определенным значением
     *
     * @param value - значение оценка
     * @see ExamGrade#ExamGrade(Integer)
     */
    public ExamGrade(Integer value) {
        this.value = value;
    }

    /**
     * Переопределение функции toString базового класса Object
     */
    @Override
    public String toString() {
        return switch (value) {
            case 1, 2 -> "bad";
            case 3 -> "it's okay";
            case 4 -> "good";
            case 5 -> "excellent";
            default -> "what?";
        };
    }
}
