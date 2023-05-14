package com.example.zp.svc.services.teacherService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.discipline.Discipline;
import com.example.zp.groups.Group;
import com.example.zp.users.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class TeacherServiceProject {

    private static Hashtable<Integer, Teacher> teacherTable;
    private static final String fileName = "usedFiles\\Teacher.bin";

    private static void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    public static void saveData() {
        Serializator.serialization(teacherTable, fileName);
    }

    public static void readData() {
        try {
            checkFIle(fileName);
            teacherTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            teacherTable = new Hashtable<>();
        }
    }

    public static boolean checkTeacherKey(Integer key) {
        if (teacherTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong teacher key input!");
            return false;
        }
    }

    public static void setTeacher(int id, String name, String login, String password) {
        teacherTable.put(id, new Teacher(id, name, login, password));
    }

    public Teacher getTeacher(Integer key) {
        return teacherTable.get(key);
    }

    public static void removeTeacher(Integer key) {
        if ((teacherTable.size() != 0) & (teacherTable.containsKey(key))) {
            teacherTable.remove(key);
        }
    }

    public static void addTeacherDiscipline(Discipline<?> discipline, Integer keyTeacher) {
        teacherTable.get(keyTeacher).addDiscipline(discipline);
    }

    public static void addTeacherGroup(Integer keyTeacher, Discipline<?> discipline, Group group) {
        teacherTable.get(keyTeacher).addGroup(discipline, group);
    }

    public static StringBuilder getTeachersDisciplines() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var x : teacherTable.keySet()) {
            stringBuilder.append(teacherTable.get(x).getName());
            stringBuilder.append(": \n");
            stringBuilder.append(teacherTable.get(x).getStudentDictionary().entrySet());
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static String getTeachers() {
        return teacherTable.toString();
    }

}
