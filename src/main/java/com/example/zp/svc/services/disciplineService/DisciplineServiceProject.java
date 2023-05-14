package com.example.zp.svc.services.disciplineService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.discipline.Discipline;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class DisciplineServiceProject {

    private static Hashtable<Integer, Discipline<?>> disciplineTable;
    private static final String fileName = "usedFiles\\Discipline.bin";


    private static void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    public static void saveData() {
        Serializator.serialization(disciplineTable, fileName);
    }

    public static void readData() {
        try {
            checkFIle(fileName);
            disciplineTable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            disciplineTable = new Hashtable<>();
        }
    }

    public static boolean checkDisciplineKey(Integer key) {
        if (disciplineTable.containsKey(key)){
            return true;
        }else {
            System.out.println("Wrong discipline key input!");
            return false;
        }
    }

    public static void setDiscipline(int id, String name) {
        disciplineTable.put(id, new Discipline<>(id, name));
    }

    public static Discipline<?> getDiscipline(Integer key) {
        return disciplineTable.get(key);
    }

    public static String getDisciplines() {
        return disciplineTable.toString();
    }
}
