package com.example.zp.users;

import com.example.zp.discipline.Discipline;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Абстрактный класс пользователя со свойствами login и password
 *
 * @author Zelenin
 * @version 1.0
 */

public abstract class User implements Serializable {
    protected int id;
    /**
     * Поле логина
     */
    protected String login;

    /**
     * Поле пароля
     */
    protected String password;
    /**
     * Поле имени
     */
    protected String name;
    /**
     * Поле списка дисциплин
     */
    protected List<Discipline<?>> list;

    public List<Discipline<?>> getList() {
        return list;
    }

    public int getId() {
        return id;
    }
    /**
     * Процедура определения значения оценки {@link User#login}
     *
     * @param login - значение оценки
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Функция получения значения поля {@link User#login}
     *
     * @return позвращает login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Процедура определения значения оценки {@link User#password}
     *
     * @param password - значение password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Функция получения значения поля {@link User#password}
     *
     * @return позвращает password
     */
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Абстрактная функция hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode()) + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    public boolean equals(Objects objects) {
        if (objects == null) {
            return false;
        }
        return objects.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getLogin();
    }
}
