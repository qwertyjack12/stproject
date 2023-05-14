package com.example.zp.svc.services.groupService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.groups.Group;
import com.example.zp.users.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class GroupServiceProject {

    private static Hashtable<Integer, Group> groupTable;
    private static final String fileName = "usedFiles\\Group.bin";

    private static void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    public static void saveData() {
        Serializator.serialization(groupTable, fileName);
    }

    public static void readData() {
        try {
            checkFIle(fileName);
            groupTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            groupTable = new Hashtable<>();
        }
    }

    public static boolean checkGroupKey(Integer key) {
        if (groupTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong group key input!");
            return false;
        }
    }

    public static void setGroup(int id, String name) {
        groupTable.put(id, new Group(id, name));
    }


    public static Group getGroup(Integer key) {
        return groupTable.get(key);
    }

    public static void removeGroup(Integer key) {
        if ((groupTable.size() != 0) & (groupTable.containsKey(key))) {
            groupTable.remove(key);
        }
    }

    public static void removeStudentInGroup(Integer keyGroup, Student student) {
        groupTable.get(keyGroup).removeStudent(student);
    }

    public static void addStudent(Student student, Integer keyGroup) {
        groupTable.get(keyGroup).addStudent(student);
    }

    public static StringBuilder getStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var x: groupTable.keySet()){
            stringBuilder.append(groupTable.get(x).getName());
            stringBuilder.append(": \n");
            stringBuilder.append(groupTable.get(x).getStudentList());
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static void getGroupsRating() {
        for (var x : groupTable.keySet()) {
            System.out.println(x + ": " + groupTable.get(x).getRating());
        }
    }

    public static String getGroups() {
        return groupTable.toString();
    }

}
