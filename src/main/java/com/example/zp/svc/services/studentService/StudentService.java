package com.example.zp.svc.services.studentService;

import com.example.zp.users.Student;

public interface StudentService {

    void saveData();
    void readData();

    boolean checkStudentKey(Integer key);

    void setStudent(int id, String name, String login, String password);
    Student getStudent(Integer key);
    void addDiscipline(String DisciplineName, String typeGrade, Integer GradeValue, Integer studentKey);
    void getStudentsRating();
    void getStudentGrades(Integer studentKey);
    void getStudents();
    void removeStudent(Integer key);

}
