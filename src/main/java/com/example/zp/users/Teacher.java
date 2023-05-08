package com.example.zp.users;

import com.example.zp.groups.Group;
import com.example.zp.discipline.Discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teacher extends User implements TeacherInterface, Serializable {
    protected Map<Discipline<?>, ArrayList<Group>> studentDictionary;

    public Teacher(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.studentDictionary = new HashMap<>();
    }

    public Map<Discipline<?>, ArrayList<Group>> getStudentDictionary() {
        return studentDictionary;
    }

    @Override
    public void addDiscipline(Discipline<?> discipline) {
        studentDictionary.put(discipline, new ArrayList<>());
    }

    @Override
    public void addGroup(Discipline<?> discipline, Group group) {
        if (studentDictionary.containsKey(discipline)) {
            studentDictionary.get(discipline).add(group);
        }
    }

    @Override
    public void removeDiscipline(Discipline<?> discipline) {
        studentDictionary.remove(discipline);
    }

    @Override
    public void removeGroupInDiscipline(Discipline<?> discipline, Group group) {
        studentDictionary.get(discipline).remove(group);
    }

    @Override
    public String getStudentsForDiscipline(Discipline<?> discipline) {
        StringBuilder output = new StringBuilder(discipline.toString() + "\n");
        for (int i = 0; i < studentDictionary.get(discipline).size(); i++) {
            output.append(studentDictionary.get(discipline).get(i).getStudentList()).append("\n");
        }
        return output.toString();
    }
}
