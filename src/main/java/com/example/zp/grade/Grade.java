package com.example.zp.grade;

import java.io.Serializable;

/**
 * Абстрактный класс оценки со свойством value
 *
 * @author Zelenin
 * @version 1.0
 */

public abstract class Grade implements Serializable {
    /**
     * Поле значение
     */
    protected Integer value;

    /**
     * Функция получения значения поля {@link Grade#value}
     *
     * @return позвращает значение оценки
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Процедура определения значения оценки {@link Grade#value}
     *
     * @param value - значение оценки
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}
