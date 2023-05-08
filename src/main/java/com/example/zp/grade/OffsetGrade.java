package com.example.zp.grade;

import java.io.Serializable;

/**
 * Класс оценки за зачет со свойством value
 *
 * @author Zelenin
 * @version 1.0
 */


public class OffsetGrade extends Grade implements Serializable {
    /**
     * Конструктор - создание нового объекта с определенным значением
     *
     * @param value - значение оценка
     * @see OffsetGrade#OffsetGrade(Integer)
     */
    public OffsetGrade(Integer value) {
        this.value = value;
    }
    /**
     * Переопределение функции toString базового класса Object
     */
    @Override
    public String toString(){
        return switch (value) {
            case 1, 2 -> "not offset";
            case 3, 4, 5 -> "offset";
            default -> "what?";
        };
    }
}
