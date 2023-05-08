package com.example.zp.svc.services.teacherService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.discipline.Discipline;
import com.example.zp.groups.Group;
import com.example.zp.users.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class TeacherServiceImpl implements TeacherService {

    private Hashtable<Integer, Teacher> teacherTable;
    private final String fileName = "usedFiles\\Teacher.bin";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(teacherTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.teacherTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.teacherTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkTeacherKey(Integer key) {
        if (teacherTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong teacher key input!");
            return false;
        }
    }

    @Override
    public void setTeacher(int id, String name, String login, String password) {
        teacherTable.put(id, new Teacher(id, name, login, password));
    }

    @Override
    public Teacher getTeacher(Integer key) {
        return teacherTable.get(key);
    }

    @Override
    public void removeTeacher(Integer key) {
        if ((teacherTable.size() != 0) & (teacherTable.containsKey(key))) {
            teacherTable.remove(key);
        }
    }

    @Override
    public void addTeacherDiscipline(Discipline<?> discipline, Integer keyTeacher) {
        teacherTable.get(keyTeacher).addDiscipline(discipline);
    }

    @Override
    public void addTeacherGroup(Integer keyTeacher, Discipline<?> discipline, Group group) {
        teacherTable.get(keyTeacher).addGroup(discipline, group);
    }

    @Override
    public void getTeachersDisciplines() {
        for (int i = 1; i <= teacherTable.size(); i++) {
            var teacher = teacherTable.get(i);
            System.out.println("Teacher: " + teacher.getName());
            for (var x : teacher.getStudentDictionary().entrySet()) {
                System.out.println(x.getKey());
                System.out.println(x.getValue());
            }
        }
    }

    @Override
    public void getTeachers() {
        System.out.println(teacherTable);
    }

}
