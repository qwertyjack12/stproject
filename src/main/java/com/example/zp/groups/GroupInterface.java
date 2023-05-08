package com.example.zp.groups;

import com.example.zp.users.Student;

public interface GroupInterface {
    void addStudent(Student student);
    void removeStudent(Student student);
    void removeStudent(int index);
    double getRating();
}
