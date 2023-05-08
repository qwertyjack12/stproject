package com.example.zp.groups;

import com.example.zp.users.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements GroupInterface, Serializable {
    protected int id;
    protected String name;
    protected List<Student> studentList;

    public Group(){
        this.name = "Excuse me Group?";
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    @Override
    public void removeStudent(int index) {
        studentList.remove(index);
    }

    @Override
    public double getRating() {
        double total = 0;
        for (Student student : studentList) {
            total += student.getRating();
        }
        return total / studentList.size();
    }

    @Override
    public String toString() {
        return "Group: " + this.getName();
    }
}
