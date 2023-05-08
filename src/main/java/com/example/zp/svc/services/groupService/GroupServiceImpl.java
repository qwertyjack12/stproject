package com.example.zp.svc.services.groupService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.groups.Group;
import com.example.zp.users.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class GroupServiceImpl implements GroupService {

    private Hashtable<Integer, Group> groupTable;
    private final String fileName = "usedFiles\\Group.bin";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(groupTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.groupTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.groupTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkGroupKey(Integer key) {
        if (groupTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong group key input!");
            return false;
        }
    }

    @Override
    public void setGroup(int id, String name) {
        groupTable.put(id, new Group(id, name));
    }

    @Override
    public Group getGroup(Integer key) {
        return groupTable.get(key);
    }

    @Override
    public void removeGroup(Integer key) {
        if ((groupTable.size() != 0) & (groupTable.containsKey(key))) {
            groupTable.remove(key);
        }
    }

    @Override
    public void removeStudentInGroup(Integer keyGroup, Student student) {
        groupTable.get(keyGroup).removeStudent(student);
    }

    @Override
    public void addStudent(Student student, Integer keyGroup) {
        groupTable.get(keyGroup).addStudent(student);
    }

    @Override
    public void getGroupsRating() {
        for (var x : groupTable.keySet()) {
            System.out.println(x + ": " + groupTable.get(x).getRating());
        }
    }

    @Override
    public void getGroups() {
        System.out.println(groupTable);
    }

}
