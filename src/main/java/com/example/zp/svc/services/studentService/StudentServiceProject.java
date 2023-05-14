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

public class StudentServiceProject {

    private static Hashtable<Integer, Student> studentTable;
    private static final String fileName = "usedFiles\\Student.bin";

    private static void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }


    public static void saveData() {
        Serializator.serialization(studentTable, fileName);
    }


    public static void readData() {
        try {
            checkFIle(fileName);
            studentTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            studentTable = new Hashtable<>();
        }
    }

    public static boolean checkStudentKey(Integer key) {
        if (studentTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong student key input!");
            return false;
        }
    }

    public static void setStudent(int id, String name, String login, String password) {
        studentTable.put(id, new Student(id, name, login, password));
    }

    public static void removeDiscipline(int idStudent, String discipline) {
        for (var x: studentTable.get(idStudent).getList()){
            if (x.getName().equals(discipline)){
                studentTable.get(idStudent).getList().remove(x);
                return;
            }
        }
    }

    public static Student getStudent(Integer key) {
        return studentTable.get(key);
    }

    public static void addDiscipline(String DisciplineName, String typeGrade, Integer GradeValue, Integer studentKey) {
        if (typeGrade.equals("exam")) {
            studentTable.get(studentKey).appendDiscipline(new Discipline<>(DisciplineName, new ExamGrade(GradeValue)));
        } else if (typeGrade.equals("offset")) {
            studentTable.get(studentKey).appendDiscipline(new Discipline<>(DisciplineName, new OffsetGrade(GradeValue)));
        }
    }

    public static StringBuilder getStudentsRating() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var x : studentTable.keySet()) {
            stringBuilder.append(studentTable.get(x).getName());
            stringBuilder.append(": ");
            stringBuilder.append(studentTable.get(x).getRating());
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static StringBuilder getStudentsGrades() {
       StringBuilder stringBuilder = new StringBuilder();
       for (var x: studentTable.keySet()){
           stringBuilder.append(studentTable.get(x).getName());
           stringBuilder.append("\n");
           stringBuilder.append(studentTable.get(x).getStudentGrades());
           stringBuilder.append("\n");
       }
       return stringBuilder;
    }

    public static void removeStudent(Integer key) {
        if ((studentTable.size() != 0) & (studentTable.containsKey(key))) {
            studentTable.remove(key);
        }
    }

    public static String getStudents() {
        return studentTable.toString();
    }

}
