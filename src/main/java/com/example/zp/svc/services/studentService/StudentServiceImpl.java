package com.example.zp.svc.services.studentService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.discipline.Discipline;
import com.example.zp.grade.ExamGrade;
import com.example.zp.grade.OffsetGrade;
import com.example.zp.users.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class StudentServiceImpl implements StudentService {

    private Hashtable<Integer, Student> studentTable;
    private final String fileName = "usedFiles\\Student.bin";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(studentTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.studentTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.studentTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkStudentKey(Integer key) {
        if (studentTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong student key input!");
            return false;
        }
    }

    @Override
    public void setStudent(int id, String name, String login, String password) {
        studentTable.put(id, new Student(id, name, login, password));
    }

    @Override
    public Student getStudent(Integer key) {
        return studentTable.get(key);
    }

    @Override
    public void addDiscipline(String DisciplineName, String typeGrade, Integer GradeValue, Integer studentKey) {
        if (typeGrade.equals("exam")) {
            studentTable.get(studentKey).appendDiscipline(new Discipline<>(DisciplineName, new ExamGrade(GradeValue)));
        } else if (typeGrade.equals("offset")) {
            studentTable.get(studentKey).appendDiscipline(new Discipline<>(DisciplineName, new OffsetGrade(GradeValue)));
        }
    }

    @Override
    public void getStudentsRating() {
        for (var x : studentTable.keySet()) {
            System.out.println(x + ": " + studentTable.get(x).getRating());
        }
    }

    @Override
    public void getStudentGrades(Integer studentKey) {
        System.out.println(studentTable.get(studentKey).getStudentGrades());
    }

    @Override
    public void removeStudent(Integer key) {
        if ((studentTable.size() != 0) & (studentTable.containsKey(key))) {
            studentTable.remove(key);
        }
    }

    @Override
    public void getStudents() {
        System.out.println(studentTable);
    }

}
